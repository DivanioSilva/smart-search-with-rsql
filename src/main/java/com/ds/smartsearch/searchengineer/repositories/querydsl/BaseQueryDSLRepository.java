package com.ds.smartsearch.searchengineer.repositories.querydsl;

import com.ds.smartsearch.searchengineer.entities.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

public interface BaseQueryDSLRepository<T extends AbstractBaseEntity, Long> extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {
}
