package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.Feature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends CrudRepository<Feature, Long> {


}

