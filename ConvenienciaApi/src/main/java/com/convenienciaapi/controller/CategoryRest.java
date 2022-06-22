package com.convenienciaapi.controller;

import com.convenienciaapi.model.persistence.Category;
import com.convenienciaapi.model.transport.request.CreateCategoryRequestDTO;
import com.convenienciaapi.model.transport.request.UpdateCategoryRequestDTO;
import com.convenienciaapi.model.transport.response.FindCategoryResponseDTO;
import com.convenienciaapi.model.transport.response.ListCategoryResponseDTO;
import com.convenienciaapi.service.CategoryServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.SQLException;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryRest {

    private final CategoryServiceInterface categoryService;

    public CategoryRest(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CreateCategoryRequestDTO> create(@RequestBody CreateCategoryRequestDTO createCategoryRequestDTO){

        Category category = this.categoryService.create(createCategoryRequestDTO);

        if(category != null){
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                    .buildAndExpand(category.getId()).toUri();

            return ResponseEntity.created(uri).body(createCategoryRequestDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<FindCategoryResponseDTO> find(@PathVariable("uuid") UUID uuid){
        try {
            return ResponseEntity.ok().body(this.categoryService.find(uuid));
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<HttpStatus> update(@RequestBody UpdateCategoryRequestDTO updateCategoryRequestDTO, @PathVariable UUID uuid){
        try {
            this.categoryService.update(updateCategoryRequestDTO, uuid);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<ListCategoryResponseDTO> list(@RequestParam(defaultValue = "0") Integer page,
                                                        @RequestParam(defaultValue = "10") Integer size,
                                                        @RequestParam(defaultValue = "name") String sort){
        ListCategoryResponseDTO list = this.categoryService.List(page, size, sort);

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("uuid") UUID uuid){
        try {
            this.categoryService.delete(uuid);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.noContent().build();
        }
    }
}
