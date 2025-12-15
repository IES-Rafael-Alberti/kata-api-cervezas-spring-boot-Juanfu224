package com.alberti.kata.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "style_name")
    private String styleName;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;

    public Style() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public LocalDateTime getLastMod() {
        return lastMod;
    }

    public void setLastMod(LocalDateTime lastMod) {
        this.lastMod = lastMod;
    }
}
