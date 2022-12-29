package com.rakbank.carshopping.repository;

import com.rakbank.carshopping.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Car Repository
 */
public interface CarRepository extends CrudRepository<Car, Long> {

    /**
     * Finds car by brand name
     *
     * @param name brand name
     * @return Car object if present
     */
    @Query("select c from Car c where c.name=:name")
    Car findByName(String name);
}

