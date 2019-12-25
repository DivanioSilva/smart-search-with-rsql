package com.ds.smartsearch.searchengineer.services;

import com.ds.smartsearch.searchengineer.entities.Person;

import java.util.List;

public interface PersonService {

    Person save(Person person);

    List<Person> smartSearch(String criteria);

    List<Person> findByName(String name);

    List<Person> findAll();
}
