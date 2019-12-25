package com.ds.smartsearch.searchengineer.config.rsql;

import cz.jirutka.rsql.parser.ast.AndNode;
import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.OrNode;
import cz.jirutka.rsql.parser.ast.RSQLVisitor;
import org.springframework.data.jpa.domain.Specification;

public class CustomRsqlVisitor<T> implements RSQLVisitor<Specification<T>, Void> {

    private GenericRsqlSpecBuilder<T> builder;

    public CustomRsqlVisitor() {
        this.builder = new GenericRsqlSpecBuilder<>();
    }

    @Override
    public Specification<T> visit(AndNode andNode, Void aVoid) {
        return builder.createSpecification(andNode);
    }

    @Override
    public Specification<T> visit(OrNode orNode, Void aVoid) {
        return builder.createSpecification(orNode);
    }

    @Override
    public Specification<T> visit(ComparisonNode comparisonNode, Void aVoid) {
        return builder.createSpecification(comparisonNode);
    }
}
