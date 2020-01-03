package com.ds.smartsearch.searchengineer.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends AbstractBaseEntity{
    private String brand;
    private String fuelType;
    private String plate;
    private Integer numberOfDoors;
    private Integer buildYear;
    private Integer plateYear;
    @ManyToOne()
    @JoinColumn(name = "personId")
    private Person person;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", plate='" + plate + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", buildYear=" + buildYear +
                ", plateYear=" + plateYear +
                "} " + super.toString();
    }
}
