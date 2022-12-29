package com.rakbank.carshopping.controller;

import com.rakbank.carshopping.exception.ConstraintsViolationException;
import com.rakbank.carshopping.exception.EntityNotFoundException;
import com.rakbank.carshopping.exception.ServiceException;
import com.rakbank.carshopping.model.Car;
import com.rakbank.carshopping.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Car Rest Controller
 */
@RestController
@RequestMapping("/cars")
public class CarController {


    @Autowired
    private CarService carService;

    @Operation(summary = "Get All cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Cars",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Car not found",
                    content = @Content)})
    @GetMapping()
    public ResponseEntity<List<Car>> findAll() throws ServiceException {

        List<Car> list = carService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "Get a car and its models by brand name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Car not found",
                    content = @Content)})
    @GetMapping("/make")
    public ResponseEntity<Car> findByBrandName(@RequestParam("name") String name) throws EntityNotFoundException {

        try {
            Optional<Car> car = carService.findByBrandName(name);
            return car.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Entity Car not found");

        }

    }

    @Operation(summary = "Get a car and its models by carID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Car not found",
                    content = @Content)})
    @GetMapping(value = "{id}")
    public ResponseEntity<Car> findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        try {
            Optional<Car> car = carService.findById(id);
            return car.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Entity Car not found");

        }
    }

    @Operation(summary = "Save car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "400", description = "Car not found",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<Car> add(@RequestBody Car car) throws ConstraintsViolationException {
        try {
            Car c = carService.add(car);
            return new ResponseEntity<>(c, HttpStatus.OK);

        } catch (ConstraintsViolationException e) {
            throw new ConstraintsViolationException("Constraints are violated");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Update car if exists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request. Constraints are violated.",
                    content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable("id") long id, @RequestBody Car car) throws ConstraintsViolationException {
        boolean isCarPresent = carService.existsById(id);

        if (!isCarPresent) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            Car updatedCar = carService.add(car);

            return new ResponseEntity<>(updatedCar, HttpStatus.OK);

        } catch (ConstraintsViolationException e) {
            throw new ConstraintsViolationException("Constraints are violated");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Delete car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleted car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Car not found",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        try {
            carService.delete(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
