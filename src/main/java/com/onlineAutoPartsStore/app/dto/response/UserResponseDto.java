package com.onlineAutoPartsStore.app.dto.response;

import com.onlineAutoPartsStore.app.dto.RoleDto;

/**
 * The type User response dto.
 */
public class UserResponseDto {

    private Long id;

    private String name;

    private RoleDto role;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public RoleDto getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(RoleDto role) {
        this.role = role;
    }
}
