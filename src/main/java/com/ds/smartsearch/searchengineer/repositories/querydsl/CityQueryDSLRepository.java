package com.ds.smartsearch.searchengineer.repositories.querydsl;

import com.ds.smartsearch.searchengineer.entities.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityQueryDSLRepository extends BaseQueryDSLRepository<City, Long> {
}
