package com.convenienciaapi.service;

import com.convenienciaapi.model.persistence.Purchase;
import com.convenienciaapi.model.transport.request.CreatePurchaseRequestDTO;
import com.convenienciaapi.model.transport.response.FindPurchaseResponseDTO;
import com.convenienciaapi.model.transport.response.ListPurchaseResponseDTO;

import java.sql.SQLException;
import java.util.UUID;

public interface PurchaseServiceInterface {

    ListPurchaseResponseDTO findAll(Integer page, Integer size, String sort);

    FindPurchaseResponseDTO find(UUID uuid) throws SQLException;

    Purchase create(CreatePurchaseRequestDTO createPurchaseRequestDTO) throws SQLException;
}
