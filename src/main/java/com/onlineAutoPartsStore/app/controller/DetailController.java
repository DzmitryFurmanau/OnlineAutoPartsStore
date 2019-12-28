package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.DetailRequestDto;
import com.onlineAutoPartsStore.app.dto.response.DetailResponseDto;
import com.onlineAutoPartsStore.app.model.Car;
import com.onlineAutoPartsStore.app.model.Detail;
import com.onlineAutoPartsStore.app.service.DetailService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detail")
public class DetailController {

    private final Mapper mapper;

    private final DetailService detailService;

    private final LocalizedMessageSource localizedMessageSource;

    public DetailController(Mapper mapper, DetailService detailService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.detailService = detailService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @GetMapping
    public ResponseEntity<List<DetailResponseDto>> getAll() {
        final List<Detail> details = detailService.findAll();
        final List<DetailResponseDto> detailResponseDtoList = details.stream()
                .map((detail) -> mapper.map(detail, DetailResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(detailResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetailResponseDto> getOne(@PathVariable Long id) {
        final DetailResponseDto detailResponseDto = mapper.map(detailService.findById(id), DetailResponseDto.class);
        return new ResponseEntity<>(detailResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DetailResponseDto> save(@RequestBody DetailRequestDto detailRequestDto) {
        detailRequestDto.setId(null);
        final DetailResponseDto detailResponseDto = mapper.map(detailService.save(getDetail(detailRequestDto)), DetailResponseDto.class);
        return new ResponseEntity<>(detailResponseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DetailResponseDto> update(@RequestBody DetailRequestDto detailRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, detailRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.detail.unexpectedId", new Object[]{}));
        }
        final DetailResponseDto detailResponseDto = mapper.map(detailService.update(getDetail(detailRequestDto)), DetailResponseDto.class);
        return new ResponseEntity<>(detailResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        detailService.deleteById(id);
    }

    private Detail getDetail(DetailRequestDto detailRequestDto) {
        final Detail detail = mapper.map(detailRequestDto, Detail.class);
        final Car car = new Car();
        car.setId(detailRequestDto.getCarId());
        detail.setCar(car);
        return detail;
    }
}
