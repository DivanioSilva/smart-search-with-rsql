package com.ds.smartsearch.searchengineer.repositories;

import com.ds.smartsearch.searchengineer.entities.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseRepository<T extends AbstractBaseEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
