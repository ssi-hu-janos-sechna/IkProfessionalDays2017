package com.surveysampling.apigateway.feign.models;

/**
 * Created by janos_sechna on 4/2/17.
 */
public class Category {

    private Long id;

    private String name;

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
}