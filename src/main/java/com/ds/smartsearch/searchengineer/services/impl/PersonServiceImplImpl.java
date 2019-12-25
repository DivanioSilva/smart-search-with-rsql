package com.ds.smartsearch.searchengineer.services.impl;

import com.ds.smartsearch.searchengineer.entities.Person;
import com.ds.smartsearch.searchengineer.repositories.PersonRepository;
import com.ds.smartsearch.searchengineer.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImplImpl extends AbstractServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImplImpl(PersonRepository personRepository) {
        super(personRepository);
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> findByName(String name) {
        return this.personRepository.findByName(name);
    }

    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }
}
