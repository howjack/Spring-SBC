package com.convenienciaapi.repository;

import com.convenienciaapi.model.persistence.Category;
import com.sun.istack.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    @NonNull
    Page<Category> findAll(@NonNull Pageable pageable);

    Optional<Category> findByUuid(UUID uuid);

    Optional<Category> findByNameLikeIgnoreCase(String name);
}
