package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {


}

