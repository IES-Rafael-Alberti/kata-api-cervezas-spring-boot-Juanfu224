package com.alberti.kata.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "beers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brewery_id")
    private Integer breweryId;

    private String name;

    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "style_id")
    private Integer styleId;

    private Float abv;
    private Float ibu;
    private Float srm;
    private Integer upc;
    private String filepath;

    @Column(columnDefinition = "TEXT")
    private String descript;

    @Column(name = "add_user")
    private Integer addUser;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;
}
