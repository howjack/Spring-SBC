package com.convenienciaapi.model.persistence;

import com.convenienciaapi.model.transport.request.CreatePurchaseRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PURCHASE")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "uuid", nullable = false, unique = true)
    private UUID uuid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "purchases_products", joinColumns = {
            @JoinColumn(name = "purchase_id")}, inverseJoinColumns = {
            @JoinColumn(name = "product_id")
    })
    private List<Product> products;

    public Purchase() {
    }

    public Purchase(Long id, LocalDate purchaseDate, BigDecimal amount, UUID uuid, List<Product> products) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.uuid = uuid;
        this.products = products;
    }

    public Purchase(CreatePurchaseRequestDTO createPurchaseRequestDTO, UUID uuid, List<Product> products) {
        this.purchaseDate = createPurchaseRequestDTO.getPurchaseDate();
        this.amount = createPurchaseRequestDTO.getAmount();
        this.uuid = uuid;
        this.products = products;
    }

    public Long getId() {
        return id;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                ", amount=" + amount +
                ", uuid=" + uuid +
                ", products=" + products +
                '}';
    }
}
