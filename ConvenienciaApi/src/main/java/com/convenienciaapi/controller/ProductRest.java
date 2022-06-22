package com.convenienciaapi.controller;

import com.convenienciaapi.model.persistence.Product;
import com.convenienciaapi.model.transport.request.CreateProductRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateCategoryRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateProductRequestDTO;
import com.convenienciaapi.model.transport.response.FindProductResponseDTO;
import com.convenienciaapi.model.transport.response.ListProductResponseDTO;
import com.convenienciaapi.service.ProductService;
import com.convenienciaapi.service.ProductServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductRest {

    private final ProductServiceInterface productService;

    public ProductRest(ProductServiceInterface productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        try {
            Product product = this.productService.create(createProductRequestDTO);
            return ResponseEntity.ok(product);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{barCode}")
    public ResponseEntity<FindProductResponseDTO> findByBarCode(@PathVariable String barCode){
        try {
            FindProductResponseDTO product = this.productService.find(barCode);
            return ResponseEntity.ok(product);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<ListProductResponseDTO> list(@RequestParam(defaultValue = "0") Integer page,
                                                       @RequestParam(defaultValue = "10") Integer size,
                                                       @RequestParam(defaultValue = "name") String sort){
        ListProductResponseDTO list = this.productService.findAll(page, size, sort);

        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{barCode}")
    public ResponseEntity<HttpStatus> update(@RequestBody UpdateProductRequestDTO updateProductRequestDTO, @PathVariable String barCode){
        try {
            this.productService.update(barCode, updateProductRequestDTO);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{barCode}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String barCode){
        try {
            this.productService.delete(barCode);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
}
