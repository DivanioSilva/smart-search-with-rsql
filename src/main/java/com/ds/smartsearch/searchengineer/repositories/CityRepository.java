package com.ds.smartsearch.searchengineer.repositories;

import com.ds.smartsearch.searchengineer.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CityRepository extends JpaRepository<City, Long>, QuerydslPredicateExecutor<City> {
}
