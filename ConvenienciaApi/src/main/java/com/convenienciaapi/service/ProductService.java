package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.transport.request.CreateProductRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateProductRequestDTO;
import com.convenienciaapi.model.transport.response.FindProductResponseDTO;
import com.convenienciaapi.model.transport.response.ListProductResponseDTO;
import com.convenienciaapi.repository.CategoryRepository;
import com.convenienciaapi.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ListProductResponseDTO findAll(Integer page, Integer size, String sort) {
        Pageable newPageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Product> productPage = this.productRepository.findAll(newPageable);
        return new ListProductResponseDTO(productPage);
    }

    @Override
    public FindProductResponseDTO find(String barCode) throws SQLException {
        Optional<Product> product = this.productRepository.findByBarCode(barCode);
        if (product.isPresent()){
            return new FindProductResponseDTO(product.get());
        }
        throw new SQLException("Não existe esse produto");
    }

    @Override
    public Product create(CreateProductRequestDTO createProductRequestDTO) throws SQLException {
        Category category = this.categoryRepository.findByNameLikeIgnoreCase(createProductRequestDTO.getCategory())
                .orElseThrow(() -> new SQLException("Não existe essa categoria"));
        Product product = new Product(createProductRequestDTO, category);
        return this.productRepository.save(product);

    }

    @Override
    public void update(String barCode, UpdateProductRequestDTO updateProductRequestDTO) throws SQLException {
        Product product = this.productRepository.findByBarCode(barCode)
                .orElseThrow(() -> new SQLException("Não existe esse Produto"));

        product.setName(updateProductRequestDTO.getName());
        product.setPrice(updateProductRequestDTO.getPrice());
        product.setQuantity(updateProductRequestDTO.getQuantity());
        product.setBarCode(updateProductRequestDTO.getBarCode());
        product.setIsActive(updateProductRequestDTO.getIsActive());
        if (updateProductRequestDTO.getCategory() != null) {
            if (!updateProductRequestDTO.getCategory().equals(product.getCategory().getName())) {
                Category newCategory =
                        this.categoryRepository.findByNameLikeIgnoreCase(updateProductRequestDTO.getCategory())
                                .orElseThrow(() -> new SQLException("Não existe essa Categoria"));
                product.setCategory(newCategory);
            }
        }

        this.productRepository.save(product);
    }

    @Override
    public void delete(String barCode) throws SQLException {
        Optional<Product> product = this.productRepository.findByBarCode(barCode);
        if (product.isEmpty()){
            throw new SQLException("O produto com esse Bar Code não existe");
        }

        this.productRepository.delete(product.get());
    }
}
