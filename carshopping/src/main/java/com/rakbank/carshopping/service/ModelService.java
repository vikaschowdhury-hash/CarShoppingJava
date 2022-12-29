package com.rakbank.carshopping.service;


import com.rakbank.carshopping.exception.ConstraintsViolationException;
import com.rakbank.carshopping.exception.EntityNotFoundException;
import com.rakbank.carshopping.exception.ServiceException;
import com.rakbank.carshopping.model.*;
import com.rakbank.carshopping.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Model Service
 */
@Service
@Transactional
public class ModelService {

    private static final Logger LOG = LoggerFactory.getLogger(ModelService.class);
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private AutopilotRepository autopilotRepository;


    /**
     * Fetch all Model and its details by Id
     *
     * @return model list
     */
    public List<Model> findAll() throws ServiceException {
        LOG.info("entering findAll method: ");
        try {
            List<Model> list = (List<Model>) modelRepository.findAll();
            return list;
        } catch (Exception e) {
            LOG.info("Error occurred: " + e.getMessage());
            throw new ServiceException("Unexpected error occurred: ");
        }
    }

    /**
     * Find Model by id
     *
     * @param modelId PK
     * @return Model object
     */
    public Optional<Model> findById(Long modelId) throws EntityNotFoundException {
        LOG.info("entering findById method: ");
        try {
            Optional<Model> model = modelRepository.findById(modelId);
            if (model.isPresent()) {
                for (ModelFeature mf : model.get().getModelFeatures()) {
                    Optional<Feature> feature = featureRepository.findById(mf.getModelFeatureId().getFeatureId());
                    if (feature.isPresent()) {
                        mf.setName(feature.get().getName());
                    }
                }
                for (ModelColor mc : model.get().getModelColors()) {
                    Optional<Color> color = colorRepository.findById(mc.getModelColorId().getColorId());
                    if (color.isPresent()) {
                        mc.setName(color.get().getName());
                        mc.setType(color.get().getType());
                    }
                }
                for (ModelAutoPilot ma : model.get().getAutoPilotDetails()) {
                    Optional<AutoPilotDetails> autoPilotDetails = autopilotRepository.findById(ma.getModelAutoPilotId().getAutoPilotId());
                    if (autoPilotDetails.isPresent()) {
                        ma.setName(autoPilotDetails.get().getName());
                    }
                }
            }
            return model;
        } catch (Exception e) {
            throw new EntityNotFoundException("Entity not found");
        }

    }


    /**
     * Saves Model
     *
     * @param model Model object
     * @return
     */
    public Model add(Model model) throws ConstraintsViolationException {
        LOG.info("entering add method: ");
        return modelRepository.save(model);

    }

    /**
     * Delete model by id
     *
     * @param id ID
     */
    public void delete(long id) throws EntityNotFoundException {
        LOG.info("entering delete method: ");
        modelRepository.deleteById(id);
    }

    /**
     * Check if an ID exists
     *
     * @param id ID
     * @return true if present
     */
    public boolean existsById(long id) {
        LOG.info("entering existsById method: ");
        return modelRepository.existsById(id);
    }


}

