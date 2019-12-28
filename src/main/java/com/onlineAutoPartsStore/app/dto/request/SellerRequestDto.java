package com.onlineAutoPartsStore.app.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SellerRequestDto {

    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.name.notNull}")
    @NotEmpty(message = "{seller.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.age.notNull}")
    @NotEmpty(message = "{seller.age.notEmpty}")
    private Short age;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.salary.notNull}")
    @NotEmpty(message = "{seller.salary.notEmpty}")
    private Integer salary;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{seller.category.notNull}")
    @NotEmpty(message = "{seller.category.notEmpty}")
    private Short category;

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

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Short getCategory() {
        return category;
    }

    public void setCategory(Short category) {
        this.category = category;
    }
}