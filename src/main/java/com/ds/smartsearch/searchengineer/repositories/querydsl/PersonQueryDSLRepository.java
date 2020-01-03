package com.ds.smartsearch.searchengineer.repositories.querydsl;

import com.ds.smartsearch.searchengineer.entities.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonQueryDSLRepository extends BaseQueryDSLRepository<Person, Long> {
}
