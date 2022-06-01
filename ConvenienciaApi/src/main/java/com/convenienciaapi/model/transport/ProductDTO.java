package com.convenienciaapi.model.transport;

import com.convenienciaapi.model.persistence.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;

    private BigDecimal price;

    private Integer quantity;

    private String barCode;

    private Boolean isActive;

    public ProductDTO() {
    }

    public ProductDTO(String name, BigDecimal price, Integer quantity, String barCode, Boolean isActive) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.barCode = barCode;
        this.isActive = isActive;
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.barCode = product.getBarCode();
        this.isActive = product.getIsActive();
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", barCode='" + barCode + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
