package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color, Long> {


}

