package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.transport.request.CreateCategoryRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateCategoryRequestDTO;
import com.convenienciaapi.model.transport.response.FindCategoryResponseDTO;
import com.convenienciaapi.model.transport.response.FindProductResponseDTO;
import com.convenienciaapi.model.transport.response.ListCategoryResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.UUID;

public interface CategoryServiceInterface {

    Category create(CreateCategoryRequestDTO createCategoryRequestDTO);

    FindCategoryResponseDTO find(UUID uuid) throws SQLException;

    FindCategoryResponseDTO findByName(String name) throws SQLException;

    void update(UpdateCategoryRequestDTO updateCategoryRequestDTO, UUID uuid) throws SQLException;

    ListCategoryResponseDTO List(Integer page, Integer size, String sort);

    void delete(UUID uuid) throws SQLException;

}
