package com.surveysampling.userservice.model;

import javax.persistence.*;

/**
 * Created by janos_sechna on 3/31/17.
 */
@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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