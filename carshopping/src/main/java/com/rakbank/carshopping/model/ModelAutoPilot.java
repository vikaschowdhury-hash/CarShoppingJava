package com.rakbank.carshopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "model_autopilot")
public class ModelAutoPilot {

    @EmbeddedId
    private ModelAutoPilotId modelAutoPilotId;

    @Transient
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private Model model;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auto_pilot_id", insertable = false, updatable = false)
    private AutoPilotDetails autoPilotDetails;

    private Long price;


}
