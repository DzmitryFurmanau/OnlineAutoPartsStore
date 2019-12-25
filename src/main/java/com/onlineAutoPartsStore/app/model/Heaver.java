package com.onlineAutoPartsStore.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "heaver", schema = "public")
public class Heaver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.name.notNull}")
    @NotEmpty(message = "{heaver.name.notEmpty}")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.age.notNull}")
    @NotEmpty(message = "{heaver.age.notEmpty}")
    private Short age;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.salary.notNull}")
    @NotEmpty(message = "{heaver.salary.notEmpty}")
    private Integer salary;

    @Column(unique = true, nullable = false)
    @NotNull(message = "{heaver.bonus.notNull}")
    @NotEmpty(message = "{heaver.bonus.notEmpty}")
    private Integer bonus;

    public Heaver() {

    }

    public Heaver(Long id, String name, Short age, Integer salary, Integer bonus) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
    }

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

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
