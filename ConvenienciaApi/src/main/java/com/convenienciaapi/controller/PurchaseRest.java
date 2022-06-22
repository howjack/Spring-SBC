package com.convenienciaapi.controller;

import com.convenienciaapi.model.persistence.Purchase;
import com.convenienciaapi.model.transport.request.CreatePurchaseRequestDTO;
import com.convenienciaapi.model.transport.response.FindProductResponseDTO;
import com.convenienciaapi.model.transport.response.FindPurchaseResponseDTO;
import com.convenienciaapi.model.transport.response.ListProductResponseDTO;
import com.convenienciaapi.model.transport.response.ListPurchaseResponseDTO;
import com.convenienciaapi.service.PurchaseServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.UUID;

@RestController
@RequestMapping("/purchase")
public class PurchaseRest {

    private final PurchaseServiceInterface purchaseService;

    public PurchaseRest(PurchaseServiceInterface purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> create(@RequestBody CreatePurchaseRequestDTO createPurchaseRequestDTO){
        try {
            System.out.println(createPurchaseRequestDTO);
            Purchase purchase = this.purchaseService.create(createPurchaseRequestDTO);
            return ResponseEntity.ok(purchase);
        }catch (SQLException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<FindPurchaseResponseDTO> findByUUID(@PathVariable UUID uuid){
        try {
            FindPurchaseResponseDTO product = this.purchaseService.find(uuid);
            return ResponseEntity.ok(product);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<ListPurchaseResponseDTO> list(@RequestParam(defaultValue = "0") Integer page,
                                                        @RequestParam(defaultValue = "10") Integer size,
                                                        @RequestParam(defaultValue = "id") String sort){
        ListPurchaseResponseDTO list = this.purchaseService.findAll(page, size, sort);

        return ResponseEntity.ok(list);
    }
}
