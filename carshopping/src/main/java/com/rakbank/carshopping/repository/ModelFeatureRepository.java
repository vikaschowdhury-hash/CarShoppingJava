package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.ModelFeature;
import com.rakbank.carshopping.model.ModelFeatureId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelFeatureRepository extends CrudRepository<ModelFeature, ModelFeatureId> {


}

