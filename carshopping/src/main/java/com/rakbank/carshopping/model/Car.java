package com.rakbank.carshopping.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private List<Model> models = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(name, car.name) && Objects.equals(models, car.models);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, models);
    }
}
