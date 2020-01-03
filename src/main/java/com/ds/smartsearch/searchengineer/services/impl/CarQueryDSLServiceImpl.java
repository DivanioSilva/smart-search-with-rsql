package com.ds.smartsearch.searchengineer.services.impl;

import com.ds.smartsearch.searchengineer.entities.Car;
import com.ds.smartsearch.searchengineer.entities.QCar;
import com.ds.smartsearch.searchengineer.repositories.querydsl.CarQueryDSLRepository;
import com.ds.smartsearch.searchengineer.services.CarQueryDSLService;
import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarQueryDSLServiceImpl implements CarQueryDSLService {
    private final CarQueryDSLRepository carQueryDSLRepository;

    public CarQueryDSLServiceImpl(CarQueryDSLRepository carQueryDSLRepository) {
        this.carQueryDSLRepository = carQueryDSLRepository;
    }

    @Override
    public Iterable<Car> findCarSmartSearch(String brand, String fuelType, String plate, Integer numberOfDoors, Integer buildYear, Integer plateYear) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if(!Strings.isNullOrEmpty(brand)){
            booleanBuilder.and(QCar.car.brand.contains(brand));
        }

        if(!Strings.isNullOrEmpty(fuelType)){
            booleanBuilder.and(QCar.car.fuelType.contains(fuelType));
        }

        if(!Strings.isNullOrEmpty(plate)){
            booleanBuilder.and(QCar.car.plate.contains(plate));
        }

        if(Objects.nonNull(numberOfDoors)){
            booleanBuilder.and(QCar.car.numberOfDoors.eq(numberOfDoors));
        }

        if(Objects.nonNull(buildYear)){
            booleanBuilder.and(QCar.car.buildYear.eq(buildYear));
        }

        if(Objects.nonNull(plateYear)){
            booleanBuilder.and(QCar.car.plateYear.eq(plateYear));
        }

        return this.carQueryDSLRepository.findAll(booleanBuilder);
    }
}
