package com.convenienciaapi.model.transport.request;

public class UpdateCategoryRequestDTO {

    private String name;

    private Boolean isActive;

    public UpdateCategoryRequestDTO(String name, Boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "UpdateCategoryRequestDTO{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
