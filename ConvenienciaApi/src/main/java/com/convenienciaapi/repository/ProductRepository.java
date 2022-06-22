package com.convenienciaapi.repository;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.persistence.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @NonNull
    Page<Product> findAll(@NonNull Pageable pageable);
    Optional<Product> findByBarCode(String barCode);

}
