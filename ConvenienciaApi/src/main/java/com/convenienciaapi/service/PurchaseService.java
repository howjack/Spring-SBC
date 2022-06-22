package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.persistence.Purchase;
import com.convenienciaapi.model.transport.request.CreatePurchaseRequestDTO;
import com.convenienciaapi.model.transport.response.FindPurchaseResponseDTO;
import com.convenienciaapi.model.transport.response.ListPurchaseResponseDTO;
import com.convenienciaapi.repository.ProductRepository;
import com.convenienciaapi.repository.PurchaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService implements PurchaseServiceInterface{

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ListPurchaseResponseDTO findAll(Integer page, Integer size, String sort) {
        Pageable newPageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Purchase> purchasePage = this.purchaseRepository.findAll(newPageable);

        return new ListPurchaseResponseDTO(purchasePage);
    }

    @Override
    public FindPurchaseResponseDTO find(UUID uuid) throws SQLException {
        Purchase purchase = this.purchaseRepository.findByUuid(uuid).orElseThrow(() -> new SQLException("Não existe essa Compra"));
        List<String> products = new ArrayList<>();
        purchase.getProducts().forEach(prod -> products.add(prod.getName()));
        return new FindPurchaseResponseDTO(purchase, products);
    }

    @Transactional
    @Override
    public Purchase create(CreatePurchaseRequestDTO createPurchaseRequestDTO) throws SQLException {
        List<Product> products = new ArrayList<>();

        createPurchaseRequestDTO.getBarCodes().forEach(barCode -> {
            try {
                products.add(this.productRepository.findByBarCode(barCode)
                        .orElseThrow(() -> new SQLException("Não existe esse Produto")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        Purchase purchase = new Purchase(createPurchaseRequestDTO, UUID.randomUUID(), products);

        return this.purchaseRepository.save(purchase);
    }
}
