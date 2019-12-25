package com.onlineAutoPartsStore.app.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProviderRequestDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{provider.name.notNull}")
    @NotEmpty(message = "{provider.name.notEmpty}")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
