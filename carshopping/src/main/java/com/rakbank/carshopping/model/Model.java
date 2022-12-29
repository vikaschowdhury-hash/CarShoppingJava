package com.rakbank.carshopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@Entity
@Table(name = "model")
public class Model {

    @Id
    @Column(name = "model_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", insertable = false, updatable = false)
    private Car car;

    @Column(name = "car_id")
    private Long carId;

    private String name;
    private Long basePrice;
    private String imageLink;
    private String baseColorCode;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelFeature> modelFeatures = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelColor> modelColors = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelAutoPilot> autoPilotDetails = new ArrayList<>();


}
