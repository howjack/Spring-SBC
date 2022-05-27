package com.convenienciaapi.repository;

import com.convenienciaapi.model.persistence.Category;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findByUuid(UUID uuid);
}
