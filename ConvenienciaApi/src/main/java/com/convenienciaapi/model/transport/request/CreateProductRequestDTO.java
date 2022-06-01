package com.convenienciaapi.model.transport.request;

import com.convenienciaapi.model.persistence.Category;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateProductRequestDTO {

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private String barCode;

    private String category;

    public CreateProductRequestDTO() {
    }

    public CreateProductRequestDTO(String name, BigDecimal price, Integer quantity, String barCode, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.barCode = barCode;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CreateProductRequestDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", barCode='" + barCode + '\'' +
                ", category=" + category +
                '}';
    }
}
