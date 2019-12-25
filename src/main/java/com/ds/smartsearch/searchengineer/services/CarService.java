package com.ds.smartsearch.searchengineer.services;

import com.ds.smartsearch.searchengineer.entities.Car;

import java.util.List;

public interface CarService {

    List<Car> smartSearch(String criteria);

    Car save(Car car);
}
