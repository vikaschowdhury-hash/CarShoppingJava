package com.rakbank.carshopping.controller;

import com.rakbank.carshopping.exception.ConstraintsViolationException;
import com.rakbank.carshopping.exception.EntityNotFoundException;
import com.rakbank.carshopping.exception.ServiceException;
import com.rakbank.carshopping.model.Car;
import com.rakbank.carshopping.model.Model;
import com.rakbank.carshopping.service.ModelService;
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

@RestController
@RequestMapping("/model")
public class ModelController {


    @Autowired
    private ModelService modelService;

    @Operation(summary = "Get all car model and its features")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Models",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Model not found",
                    content = @Content)})
    @GetMapping()
    public ResponseEntity<List<Model>> findAll() throws ServiceException {

        List<Model> list = modelService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Operation(summary = "Get model by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found model",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Model not found",
                    content = @Content)})
    @GetMapping(value = "{id}")
    public ResponseEntity<Model> findById(@PathVariable("id") Long id) throws EntityNotFoundException {
        try {
            Optional<Model> model = modelService.findById(id);
            return model.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Entity Car not found");

        }
    }

    @Operation(summary = "Save model")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved car model",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Model not found",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<Model> add(@RequestBody Model model) throws ConstraintsViolationException {
        try {
            Model m = modelService.add(model);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (ConstraintsViolationException e) {
            throw new ConstraintsViolationException("Constraints are violated");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Update a car model if exists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated model",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Model not found",
                    content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<Model> update(@PathVariable("id") long id, @RequestBody Model model) throws ConstraintsViolationException {
        boolean isModelPresent = modelService.existsById(id);

        if (!isModelPresent) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        try {
            Model updatedModel = modelService.add(model);

            return new ResponseEntity<>(updatedModel, HttpStatus.OK);

        } catch (ConstraintsViolationException e) {
            throw new ConstraintsViolationException("Constraints are violated");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Delete model by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted model",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "404", description = "Model not found",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        try {
            modelService.delete(id);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
