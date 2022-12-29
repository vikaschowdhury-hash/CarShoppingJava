package com.rakbank.carshopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@Embeddable
public class ModelAutoPilotId implements Serializable {


    @Column(name = "auto_pilot_id")
    private Long autoPilotId;
    @Column(name = "model_id")
    private Long modelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelAutoPilotId that = (ModelAutoPilotId) o;
        return autoPilotId.equals(that.autoPilotId) && modelId.equals(that.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoPilotId, modelId);
    }

}
