package com.ds.smartsearch.searchengineer.services.impl;

import com.ds.smartsearch.searchengineer.entities.Person;
import com.ds.smartsearch.searchengineer.repositories.PersonRepository;
import com.ds.smartsearch.searchengineer.services.AbstractService;
import com.ds.smartsearch.searchengineer.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends AbstractService implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        super(personRepository);
        this.personRepository = personRepository;
    }


    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> smartSearch(String criteria) {
        //Node rootNode = new RSQLParser().parse(criteria);
        //Specification<Person> spec = rootNode.accept(new CustomRsqlVisitor<Person>());
        //List<Person> results = this.personRepository.findAll(spec);
        //return results;
        return super.smartSearch(criteria);
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
