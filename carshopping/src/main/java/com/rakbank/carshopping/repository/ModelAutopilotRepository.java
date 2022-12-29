package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.ModelAutoPilot;
import com.rakbank.carshopping.model.ModelAutoPilotId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelAutopilotRepository extends CrudRepository<ModelAutoPilot, ModelAutoPilotId> {


}

