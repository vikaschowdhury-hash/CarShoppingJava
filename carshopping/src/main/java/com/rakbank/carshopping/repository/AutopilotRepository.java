package com.rakbank.carshopping.repository;


import com.rakbank.carshopping.model.AutoPilotDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutopilotRepository extends CrudRepository<AutoPilotDetails, Long> {


}

