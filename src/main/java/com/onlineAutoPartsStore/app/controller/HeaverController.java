package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.HeaverRequestDto;
import com.onlineAutoPartsStore.app.dto.response.HeaverResponseDto;
import com.onlineAutoPartsStore.app.model.Heaver;
import com.onlineAutoPartsStore.app.service.HeaverService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/heaver")
public class HeaverController {

    private final Mapper mapper;

    private final HeaverService heaverService;

    private final LocalizedMessageSource localizedMessageSource;

    public HeaverController(Mapper mapper, HeaverService heaverService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.heaverService = heaverService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @GetMapping
    public ResponseEntity<List<HeaverResponseDto>> getAll() {
        final List<Heaver> heavers = heaverService.findAll();
        final List<HeaverResponseDto> heaverResponseDtoList = heavers.stream()
                .map((heaver) -> mapper.map(heaver, HeaverResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(heaverResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HeaverResponseDto> getOne(@PathVariable Long id) {
        final HeaverResponseDto heaverResponseDto = mapper.map(heaverService.findById(id), HeaverResponseDto.class);
        return new ResponseEntity<>(heaverResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HeaverResponseDto> save(@RequestBody HeaverRequestDto heaverRequestDto) {
        heaverRequestDto.setId(null);
        final HeaverResponseDto heaverResponseDto = mapper.map(heaverService.save(mapper.map(heaverRequestDto, Heaver.class)), HeaverResponseDto.class);
        return new ResponseEntity<>(heaverResponseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<HeaverResponseDto> update(@RequestBody HeaverRequestDto heaverRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, heaverRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.heaver.unexpectedId", new Object[]{}));
        }
        final HeaverResponseDto heaverResponseDto = mapper.map(heaverService.update(mapper.map(heaverRequestDto, Heaver.class)), HeaverResponseDto.class);
        return new ResponseEntity<>(heaverResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        heaverService.deleteById(id);
    }
}
