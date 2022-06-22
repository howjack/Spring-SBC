package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.transport.request.CreateCategoryRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateCategoryRequestDTO;
import com.convenienciaapi.model.transport.response.FindCategoryResponseDTO;
import com.convenienciaapi.model.transport.response.ListCategoryResponseDTO;
import com.convenienciaapi.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService implements CategoryServiceInterface{

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CreateCategoryRequestDTO createCategoryRequestDTO) {
        Category category = new Category(createCategoryRequestDTO, UUID.randomUUID());
        return this.categoryRepository.save(category);
    }

    @Override
    public FindCategoryResponseDTO find(UUID uuid) throws SQLException {
        Optional<Category> category = this.categoryRepository.findByUuid(uuid);

        if (category.isPresent()){
            return new FindCategoryResponseDTO(category.get());
        }
        throw new SQLException("Não existe essa Categoria");

    }

    public FindCategoryResponseDTO findByName(String name) throws SQLException {
        Optional<Category> category = this.categoryRepository.findByNameLikeIgnoreCase(name);

        if (category.isPresent()){
            return new FindCategoryResponseDTO(category.get());
        }
        throw new SQLException("Não existe essa Categoria");

    }

    @Override
    @Transactional
    public void update(UpdateCategoryRequestDTO updateCategoryRequestDTO, UUID uuid) throws SQLException {
        Optional<Category> category = this.categoryRepository.findByUuid(uuid);
        if (category.isPresent()){
            Category newCategory = category.get();
            if (updateCategoryRequestDTO.getName() != null){
                newCategory.setName(updateCategoryRequestDTO.getName());
            }
            if (updateCategoryRequestDTO.getIsActive() != null){
                newCategory.setIsActive(updateCategoryRequestDTO.getIsActive());
            }
            this.categoryRepository.save(newCategory);
        }else{
            throw new SQLException("Não existe essa Categoria");
        }
    }

    @Override
    public ListCategoryResponseDTO List(Integer page, Integer size, String sort) {
        Pageable newPageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Category> categoryPage = this.categoryRepository.findAll(newPageable);
        return new ListCategoryResponseDTO(categoryPage);
    }

    @Override
    public void delete(UUID uuid) throws SQLException {
        Optional<Category> category = this.categoryRepository.findByUuid(uuid);
        if (category.isEmpty()){
            throw new SQLException("A categoria com esse uuid não existe");
        }

        this.categoryRepository.delete(category.get());

    }
}
