package com.convenienciaapi.model.persistence;

import com.convenienciaapi.model.transport.request.CreateProductRequestDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "bar_code", nullable = false, unique = true)
    private String barCode;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    @JsonBackReference
    private Category category;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, Integer quantity, String barCode, Boolean isActive, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.barCode = barCode;
        this.isActive = isActive;
        this.category = category;
    }

    public Product(String name, BigDecimal price, Integer quantity, String barCode, Boolean isActive) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.barCode = barCode;
        this.isActive = isActive;
    }

    public Product(CreateProductRequestDTO createProductRequestDTO, Category category) {
        this.name = createProductRequestDTO.getName();
        this.price = createProductRequestDTO.getPrice();
        this.quantity = createProductRequestDTO.getQuantity();
        this.barCode = createProductRequestDTO.getBarCode();
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", barCode=" + barCode +
                ", isActive=" + isActive +
                ", category=" + category +
                '}';
    }
}
