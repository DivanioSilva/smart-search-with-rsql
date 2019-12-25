package com.ds.smartsearch.searchengineer.entities;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car extends AbstractBaseEntity{
    private String brand;
    private String fuelType;
    private String plate;
    private Integer numberOfDoors;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", plate='" + plate + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                "} " + super.toString();
    }
}
