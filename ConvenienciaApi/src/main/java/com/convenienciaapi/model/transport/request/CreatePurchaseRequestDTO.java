package com.convenienciaapi.model.transport.request;

import com.convenienciaapi.model.persistence.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreatePurchaseRequestDTO {


    private LocalDate purchaseDate;

    private BigDecimal amount;

    private List<String> barCodes;

    public CreatePurchaseRequestDTO() {
    }

    public CreatePurchaseRequestDTO(LocalDate purchaseDate, BigDecimal amount, List<String> barCodes) {
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.barCodes = barCodes;
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

    public List<String> getBarCodes() {
        return barCodes;
    }

    public void setBarCodes(List<String> barCodes) {
        this.barCodes = barCodes;
    }

    @Override
    public String toString() {
        return "CreatePurchaseRequestDTO{" +
                "purchaseDate=" + purchaseDate +
                ", amount=" + amount +
                ", products=" + barCodes +
                '}';
    }
}
