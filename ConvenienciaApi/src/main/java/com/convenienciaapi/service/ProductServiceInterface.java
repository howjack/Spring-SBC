package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.transport.request.CreateProductRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateProductRequestDTO;
import com.convenienciaapi.model.transport.response.FindProductResponseDTO;
import com.convenienciaapi.model.transport.response.ListProductResponseDTO;

import java.sql.SQLException;

public interface ProductServiceInterface {

    ListProductResponseDTO findAll(Integer page, Integer size, String sort);

    FindProductResponseDTO find(String barCode) throws SQLException;

    Product create(CreateProductRequestDTO createProductRequestDTO) throws SQLException;

    void update(String barCode, UpdateProductRequestDTO updateProductRequestDTO) throws SQLException;

    void delete(String barCode) throws SQLException;
}
