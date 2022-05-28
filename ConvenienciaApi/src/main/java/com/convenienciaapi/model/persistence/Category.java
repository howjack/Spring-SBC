package com.convenienciaapi.model.persistence;

import com.convenienciaapi.model.transport.request.CreateCategoryRequestDTO;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "uuid", nullable = false, unique = true)
    private UUID uuid;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Product> product;

    public Category() {
    }

    public Category(String name, UUID uuid, Boolean isActive) {
        this.name = name;
        this.uuid = uuid;
        this.isActive = isActive;
    }

    public Category(CreateCategoryRequestDTO createCategoryRequestDTO, UUID uuid) {
        this.name = createCategoryRequestDTO.getName();
        this.uuid = uuid;
        this.isActive = createCategoryRequestDTO.getIsActive();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uuid=" + uuid +
                ", isActive=" + isActive +
                '}';
    }
}
