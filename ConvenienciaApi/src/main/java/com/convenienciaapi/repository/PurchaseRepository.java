package com.convenienciaapi.repository;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.persistence.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {

    @NonNull
    Page<Purchase> findAll(@NonNull Pageable pageable);

    Optional<Purchase> findByUuid(UUID uuid);
}
