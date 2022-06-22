package com.convenienciaapi.model.transport.response;

import com.convenienciaapi.model.persistence.Purchase;
import com.convenienciaapi.model.transport.PurchaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class ListPurchaseResponseDTO {

    private List<PurchaseDTO> content;

    private Integer totalElements;

    private Integer totalPages;

    private Pageable pageable;

    public ListPurchaseResponseDTO() {
    }

    public ListPurchaseResponseDTO(List<PurchaseDTO> content, Integer totalElements, Integer totalPages, Pageable pageable) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageable = pageable;
    }

    public ListPurchaseResponseDTO(Page<Purchase> purchasePage) {
        this.content = purchasePage.get().map(PurchaseDTO::new).collect(Collectors.toList());
        this.totalElements = purchasePage.getNumberOfElements();
        this.totalPages = purchasePage.getTotalPages();
        this.pageable = purchasePage.getPageable();
    }

    public List<PurchaseDTO> getContent() {
        return content;
    }

    public void setContent(List<PurchaseDTO> content) {
        this.content = content;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }

    @Override
    public String toString() {
        return "ListPurchaseResponseDTO{" +
                "content=" + content +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", pageable=" + pageable +
                '}';
    }
}
