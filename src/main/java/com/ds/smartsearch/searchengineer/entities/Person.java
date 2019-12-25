package com.ds.smartsearch.searchengineer.entities;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person extends AbstractBaseEntity{
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Car> cars;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                "} ";
    }
}
