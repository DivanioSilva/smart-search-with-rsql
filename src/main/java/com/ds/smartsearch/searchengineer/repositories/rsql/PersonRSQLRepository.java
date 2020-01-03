package com.ds.smartsearch.searchengineer.repositories.rsql;

import com.ds.smartsearch.searchengineer.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRSQLRepository extends BaseRSQLRepository<Person> {
    List<Person> findByName(String name);
}
