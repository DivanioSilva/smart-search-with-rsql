package com.ds.smartsearch.searchengineer.services.impl;

import com.ds.smartsearch.searchengineer.entities.Car;
import com.ds.smartsearch.searchengineer.repositories.CarRepository;
import com.ds.smartsearch.searchengineer.services.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends AbstractServiceImpl implements CarService {

    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public Car save(Car car) {
        return this.repository.save(car);
    }
}
