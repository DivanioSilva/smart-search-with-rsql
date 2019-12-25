package com.ds.smartsearch.searchengineer.services.impl;

import com.ds.smartsearch.searchengineer.config.rsql.CustomRsqlVisitor;
import com.ds.smartsearch.searchengineer.entities.Person;
import com.ds.smartsearch.searchengineer.repositories.PersonRepository;
import com.ds.smartsearch.searchengineer.services.PersonService;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> smartSearch(String criteria) {
        Node rootNode = new RSQLParser().parse(criteria);
        Specification<Person> spec = rootNode.accept(new CustomRsqlVisitor<Person>());
        List<Person> results = this.personRepository.findAll(spec);
        return results;
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
