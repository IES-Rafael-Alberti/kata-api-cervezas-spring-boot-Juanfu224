package com.alberti.kata.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cat_name")
    private String catName;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public LocalDateTime getLastMod() {
        return lastMod;
    }

    public void setLastMod(LocalDateTime lastMod) {
        this.lastMod = lastMod;
    }
}
