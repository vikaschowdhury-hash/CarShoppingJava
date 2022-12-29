package com.rakbank.carshopping.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "autopilot")
public class AutoPilotDetails {

    @Id
    @Column(name = "auto_pilot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "autoPilotDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModelAutoPilot> autoPilotsDetails = new ArrayList<>();


}
