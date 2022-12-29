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
public class ModelColorId implements Serializable {


    @Column(name = "color_id")
    private Long colorId;
    @Column(name = "model_id")
    private Long modelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelColorId that = (ModelColorId) o;
        return colorId.equals(that.colorId) && modelId.equals(that.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorId, modelId);
    }

}
