package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.ModelColor;
import com.rakbank.carshopping.model.ModelColorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelColorRepository extends CrudRepository<ModelColor, ModelColorId> {
}

