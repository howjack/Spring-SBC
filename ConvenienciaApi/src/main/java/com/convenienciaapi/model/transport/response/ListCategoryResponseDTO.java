package com.convenienciaapi.model.transport.response;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.transport.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class ListCategoryResponseDTO {

    private List<CategoryDTO> content;

    private Integer totalElements;

    private Integer totalPages;

    private Pageable pageable;

    public ListCategoryResponseDTO() {
    }

    public ListCategoryResponseDTO(Page<Category> categoryPage) {
        this.content = categoryPage.get().map(CategoryDTO::new).collect(Collectors.toList());
        this.totalElements = categoryPage.getNumberOfElements();
        this.totalPages = categoryPage.getTotalPages();
        this.pageable = categoryPage.getPageable();
    }

    public List<CategoryDTO> getContent() {
        return content;
    }

    public void setContent(List<CategoryDTO> content) {
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
        return "ListCategoryResponseDTO{" +
                "content=" + content +
                ", totalElements=" + totalElements +
                ", totalpages=" + totalPages +
                ", pageable=" + pageable +
                '}';
    }
}
