package com.ds.smartsearch.searchengineer.repositories.querydsl;

import com.ds.smartsearch.searchengineer.entities.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarQueryDSLRepository extends BaseQueryDSLRepository<Car, Long> {
}
