package com.rakbank.carshopping.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "color")
public class Color {

    @Id
    @Column(name = "color_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelColor> colors = new ArrayList<>();

}

