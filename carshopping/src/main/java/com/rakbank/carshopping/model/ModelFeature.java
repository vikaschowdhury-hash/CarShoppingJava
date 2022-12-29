package com.rakbank.carshopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "model_feature")
public class ModelFeature {

    @EmbeddedId
    private ModelFeatureId modelFeatureId;

    @Transient
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private Model model;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", insertable = false, updatable = false)
    private Feature feature;

    private Long price;


}

