package com.onlineAutoPartsStore.app.controller;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.dto.request.ProviderRequestDto;
import com.onlineAutoPartsStore.app.dto.response.ProviderResponseDto;
import com.onlineAutoPartsStore.app.model.Provider;
import com.onlineAutoPartsStore.app.service.ProviderService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final Mapper mapper;

    private final ProviderService providerService;

    private final LocalizedMessageSource localizedMessageSource;


    public ProviderController(Mapper mapper, ProviderService providerService, LocalizedMessageSource localizedMessageSource) {
        this.mapper = mapper;
        this.providerService = providerService;
        this.localizedMessageSource = localizedMessageSource;
    }

    @GetMapping
    public ResponseEntity<List<ProviderResponseDto>> getAll() {
        final List<Provider> providers = providerService.findAll();
        final List<ProviderResponseDto> providerResponseDtoList = providers.stream()
                .map((provider) -> mapper.map(provider, ProviderResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(providerResponseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProviderResponseDto> getOne(@PathVariable Long id) {
        final ProviderResponseDto providerResponseDto = mapper.map(providerService.findById(id), ProviderResponseDto.class);
        return new ResponseEntity<>(providerResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProviderResponseDto> save(@RequestBody ProviderRequestDto providerRequestDto) {
        providerRequestDto.setId(null);
        final ProviderResponseDto providerResponseDto = mapper.map(providerService.save(mapper.map(providerRequestDto, Provider.class)), ProviderResponseDto.class);
        return new ResponseEntity<>(providerResponseDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProviderResponseDto> update(@RequestBody ProviderRequestDto providerRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, providerRequestDto.getId())) {
            throw new RuntimeException(localizedMessageSource.getMessage("controller.provider.unexpectedId", new Object[]{}));
        }
        final ProviderResponseDto providerResponseDto = mapper.map(providerService.update(mapper.map(providerRequestDto, Provider.class)), ProviderResponseDto.class);
        return new ResponseEntity<>(providerResponseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        providerService.deleteById(id);
    }
}
