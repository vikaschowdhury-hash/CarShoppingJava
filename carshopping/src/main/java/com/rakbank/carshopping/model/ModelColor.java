package com.rakbank.carshopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "model_color")
public class ModelColor {

    @EmbeddedId
    private ModelColorId modelColorId;

    @Transient
    private String name;

    @Transient
    private String type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", insertable = false, updatable = false)
    private Model model;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id", insertable = false, updatable = false)
    private Color color;
    private String colorCode;
    private Long price;
    private Boolean included;
    private String imageUrl;


}

