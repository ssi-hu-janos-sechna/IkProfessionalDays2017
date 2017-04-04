package com.surveysampling.apigateway.feign.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

/**
 * Created by janos_sechna on 4/2/17.
 */
public class Depot {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @Min(0)
    private Long maximumStorageUnit;

    private Long currentStoredUnit;

    public Depot(String name, String address, Long maximumStorageUnit, Long currentStoredUnit) {
        this.name = name;
        this.address = address;
        this.maximumStorageUnit = maximumStorageUnit;
        this.currentStoredUnit = currentStoredUnit;
    }

    public Depot() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMaximumStorageUnit() {
        return maximumStorageUnit;
    }

    public void setMaximumStorageUnit(Long maximumStorageUnit) {
        this.maximumStorageUnit = maximumStorageUnit;
    }

    public Long getCurrentStoredUnit() {
        return currentStoredUnit;
    }

    public void setCurrentStoredUnit(Long currentStoredUnit) {
        this.currentStoredUnit = currentStoredUnit;
    }
}