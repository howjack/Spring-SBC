package com.convenienciaapi.model.transport;

import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.persistence.Purchase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseDTO {

    private LocalDate purchaseDate;

    private BigDecimal amount;

    private UUID uuid;

    private List<ProductDTO> products = new ArrayList<>();

    public PurchaseDTO() {
    }

    public PurchaseDTO(LocalDate purchaseDate, BigDecimal amount, UUID uuid, List<ProductDTO> products) {
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.uuid = uuid;
        this.products = products;
    }

    public PurchaseDTO(Purchase purchase) {
        this.purchaseDate = purchase.getPurchaseDate();
        this.amount = purchase.getAmount();
        this.uuid = purchase.getUuid();
        purchase.getProducts().forEach(prod -> this.products.add(new ProductDTO(prod)));
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "purchaseDate=" + purchaseDate +
                ", amount=" + amount +
                ", uuid=" + uuid +
                ", products=" + products +
                '}';
    }
}
