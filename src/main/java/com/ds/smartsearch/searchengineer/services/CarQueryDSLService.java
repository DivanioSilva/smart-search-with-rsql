package com.ds.smartsearch.searchengineer.services;

import com.ds.smartsearch.searchengineer.entities.Car;


public interface CarQueryDSLService {
    Iterable<Car> findCarSmartSearch(String brand,
                                 String fuelType,
                                 String plate,
                                 Integer numberOfDoors,
                                 Integer buildYear,
                                 Integer plateYear);
}
