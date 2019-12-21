package com.ds.smartsearch.searchengineer.repositories;

import com.ds.smartsearch.searchengineer.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
