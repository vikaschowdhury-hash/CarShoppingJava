package com.rakbank.carshopping.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "feature", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelFeature> features = new ArrayList<>();


}

