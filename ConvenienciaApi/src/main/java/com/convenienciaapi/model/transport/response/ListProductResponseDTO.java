package com.convenienciaapi.model.transport.response;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.transport.CategoryDTO;
import com.convenienciaapi.model.transport.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class ListProductResponseDTO {

    private List<ProductDTO> content;

    private Integer totalElements;

    private Integer totalPages;

    private Pageable pageable;

    public ListProductResponseDTO() {
    }

    public ListProductResponseDTO(Page<Product> productPage) {
        this.content = productPage.get().map(ProductDTO::new).collect(Collectors.toList());
        this.totalElements = productPage.getNumberOfElements();
        this.totalPages = productPage.getTotalPages();
        this.pageable = productPage.getPageable();
    }

    public ListProductResponseDTO(List<ProductDTO> content, Integer totalElements, Integer totalPages, Pageable pageable) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageable = pageable;
    }

    public List<ProductDTO> getContent() {
        return content;
    }

    public void setContent(List<ProductDTO> content) {
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
        return "ListProductResponseDTO{" +
                "content=" + content +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", pageable=" + pageable +
                '}';
    }
}
