package com.onlineAutoPartsStore.app.service.impl;

import com.onlineAutoPartsStore.app.component.LocalizedMessageSource;
import com.onlineAutoPartsStore.app.model.Heaver;
import com.onlineAutoPartsStore.app.repository.HeaverRepository;
import com.onlineAutoPartsStore.app.service.HeaverService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class HeaverServiceImpl implements HeaverService {

    private final LocalizedMessageSource localizedMessageSource;

    private final HeaverRepository heaverRepository;

    public HeaverServiceImpl(HeaverRepository heaverRepository, LocalizedMessageSource localizedMessageSource) {
        this.heaverRepository = heaverRepository;
        this.localizedMessageSource = localizedMessageSource;
    }

    @Override
    public List<Heaver> findAll() {
        return heaverRepository.findAll();
    }

    @Override
    public Heaver findById(Long id) {
        return heaverRepository.findById(id).orElseThrow(() -> new RuntimeException(localizedMessageSource.getMessage("error.heaver.notExist", new Object[]{})));
    }

    @Override
    public Heaver save(Heaver heaver) {
        validate(heaver.getId() != null, localizedMessageSource.getMessage("error.heaver.notHaveId", new Object[]{}));
        validate(heaverRepository.existsByName(heaver.getName()), localizedMessageSource.getMessage("error.heaver.Name.notUnique", new Object[]{}));
        return heaverRepository.saveAndFlush(heaver);
    }

    @Override
    public Heaver update(Heaver heaver) {
        final Long id = heaver.getId();
        validate(id == null, localizedMessageSource.getMessage("error.heaver.haveId", new Object[]{}));
        final Heaver duplicateHeaver = heaverRepository.findByName(heaver.getName());
        findById(id);
        final boolean isDuplicateExists = duplicateHeaver != null && !Objects.equals(duplicateHeaver.getId(), id);
        validate(isDuplicateExists, localizedMessageSource.getMessage("error.heaver.name.notUnique", new Object[]{}));
        return heaverRepository.saveAndFlush(heaver);
    }

    @Override
    public void delete(Heaver heaver) {
        final Long id = heaver.getId();
        validate(id == null, localizedMessageSource.getMessage("error.heaver.haveId", new Object[]{}));
        findById(id);
        heaverRepository.delete(heaver);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        heaverRepository.deleteById(id);
    }

    private void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }
}
