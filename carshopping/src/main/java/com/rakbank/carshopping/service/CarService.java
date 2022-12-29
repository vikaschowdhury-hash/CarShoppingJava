package com.rakbank.carshopping.service;

import com.rakbank.carshopping.exception.ConstraintsViolationException;
import com.rakbank.carshopping.exception.EntityNotFoundException;
import com.rakbank.carshopping.exception.ServiceException;
import com.rakbank.carshopping.model.Car;
import com.rakbank.carshopping.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Car Service
 */
@Service
@Transactional
public class CarService {

    private static final Logger LOG = LoggerFactory.getLogger(CarService.class);
    @Autowired
    private CarRepository carRepository;

    /**
     * Fetch all cars
     *
     * @return Car list
     */
    public List<Car> findAll() throws ServiceException {
        LOG.info("entering findAll method: ");
        try {
            List<Car> list = (List<Car>) carRepository.findAll();
            return list;
        } catch (Exception e) {
            LOG.info("Error occurred: " + e.getMessage());
            throw new ServiceException("Unexpected error occurred: ");
        }

    }

    /**
     * Fetch all cars by brandName with its model and feature details
     *
     * @param name brandName e.g. Tesla
     * @return Car object if present
     */
    public Optional<Car> findByBrandName(String name) throws EntityNotFoundException {
        LOG.info("entering findByBrandName method: ");
        return Optional.ofNullable(carRepository.findByName(name));

    }

    /**
     * Retrieves car by PK
     *
     * @param carId PK carId
     * @return Car object if present
     */
    public Optional<Car> findById(Long carId) throws EntityNotFoundException {
        LOG.info("entering findById method: ");
        return carRepository.findById(carId);
    }

    /**
     * Saves Car object in db
     *
     * @param car Car object
     * @return Car object
     */
    public Car add(Car car) throws ConstraintsViolationException {
        LOG.info("entering add method: ");
        return carRepository.save(car);
    }

    /**
     * Deletes car.
     *
     * @param id Deletes car by car Id.
     */
    public void delete(long id) throws EntityNotFoundException {
        LOG.info("entering delete method: ");
        carRepository.deleteById(id);
    }

    /**
     * Checks if there is row in table with particular id
     *
     * @param id ID
     * @return true if exists
     */
    public boolean existsById(long id) {
        LOG.info("entering existsById method: ");
        return carRepository.existsById(id);
    }


}

