package com.ds.smartsearch.searchengineer.repositories;

import com.ds.smartsearch.searchengineer.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByName(String name);
}
