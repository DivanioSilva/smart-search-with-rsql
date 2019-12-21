package com.ds.smartsearch.searchengineer.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Person extends AbstractBaseEntity{
    private String name;
    private Integer age;
}
