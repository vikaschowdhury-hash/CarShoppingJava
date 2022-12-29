package com.rakbank.carshopping;

import com.rakbank.carshopping.model.Car;
import com.rakbank.carshopping.model.Color;
import com.rakbank.carshopping.model.Feature;
import com.rakbank.carshopping.model.Model;
import com.rakbank.carshopping.repository.CarRepository;
import com.rakbank.carshopping.repository.ColorRepository;
import com.rakbank.carshopping.repository.FeatureRepository;
import com.rakbank.carshopping.repository.ModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarShoppingApplicationTests {


    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void addCar() {

        Car c = new Car();
        c.setName("Audi");

        assertNull(c.getId());
        carRepository.save(c);
        assertNotNull(c.getId());
    }

    @Test
    public void addModel() {

        Model m = new Model();
        m.setName("VC");
        assertNull(m.getId());
        modelRepository.save(m);
        Optional<Model> findModel = modelRepository.findById(m.getId());
        assertTrue(findModel.isPresent());
    }

    @Test
    public void addFeature() {

        Feature f = new Feature();
        f.setName("Performance");
        assertNull(f.getId());
        featureRepository.save(f);
        Optional<Feature> findFeature = featureRepository.findById(f.getId());
        assertTrue(findFeature.isPresent());
    }

    @Test
    public void addColor() {

        Color c = new Color();
        c.setName("Brown");
        c.setType("Exterior");
        assertNull(c.getId());
        colorRepository.save(c);
        Optional<Color> findColor = colorRepository.findById(c.getId());
        assertTrue(findColor.isPresent());
    }


}
