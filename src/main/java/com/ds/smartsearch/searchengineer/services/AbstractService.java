package com.ds.smartsearch.searchengineer.services;

import com.ds.smartsearch.searchengineer.config.rsql.CustomRsqlVisitor;
import com.ds.smartsearch.searchengineer.entities.Person;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public class AbstractService<T, R extends JpaSpecificationExecutor> {

    private final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    public List<T> smartSearch(String criteria) {
        Node rootNode = new RSQLParser().parse(criteria);
        Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
        List<T> results = this.repository.findAll(spec);
        return results;
    }
}
