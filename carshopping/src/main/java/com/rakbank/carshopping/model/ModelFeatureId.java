package com.rakbank.carshopping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@Embeddable
public class ModelFeatureId implements Serializable {


    @Column(name = "feature_id")
    private Long featureId;
    @Column(name = "model_id")
    private Long modelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelFeatureId that = (ModelFeatureId) o;
        return featureId.equals(that.featureId) && modelId.equals(that.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId, modelId);
    }

}
