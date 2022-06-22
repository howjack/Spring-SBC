package com.convenienciaapi.model.transport.response;

import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.persistence.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class FindPurchaseResponseDTO {

    private LocalDate purchaseDate;

    private BigDecimal amount;

    private UUID uuid;

    private List<String> products;

    public FindPurchaseResponseDTO() {
    }

    public FindPurchaseResponseDTO(LocalDate purchaseDate, BigDecimal amount, UUID uuid, List<String> products) {
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.uuid = uuid;
        this.products = products;
    }

    public FindPurchaseResponseDTO(Purchase purchase, List<String> products) {
        this.purchaseDate = purchase.getPurchaseDate();
        this.amount = purchase.getAmount();
        this.uuid = purchase.getUuid();
        this.products = products;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "FindPurchaseResponseDTO{" +
                "purchaseDate=" + purchaseDate +
                ", amount=" + amount +
                ", uuid=" + uuid +
                ", products=" + products +
                '}';
    }
}
