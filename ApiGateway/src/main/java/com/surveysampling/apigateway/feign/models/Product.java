package com.surveysampling.apigateway.feign.models;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by janos_sechna on 4/2/17.
 */
public class Product {

    private Long id;

    @NotEmpty
    private String name;

    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}