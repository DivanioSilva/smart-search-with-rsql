package com.ds.smartsearch.searchengineer.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person extends AbstractBaseEntity{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                "} ";
    }
}
