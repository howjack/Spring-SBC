package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.transport.request.CreateCategoryRequestDTO;
import com.convenienciaapi.model.transport.response.FindCategoryResponseDTO;
import com.convenienciaapi.model.transport.response.ListCategoryResponseDTO;

import java.sql.SQLException;
import java.util.UUID;

public interface CategoryServiceInterface {

    Category create(CreateCategoryRequestDTO createCategoryRequestDTO);

    FindCategoryResponseDTO find(UUID uuid) throws SQLException;

    ListCategoryResponseDTO List(Integer page, Integer size, String sort);

    void delete(UUID uuid) throws SQLException;

    //TODO: Criar service para pegar uma categoria por nome para buscar na hora de salvar o produto
}
