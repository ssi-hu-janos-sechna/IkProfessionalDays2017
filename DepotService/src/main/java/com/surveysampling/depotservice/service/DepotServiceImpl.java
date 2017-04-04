package com.surveysampling.depotservice.service;

import com.surveysampling.depotservice.model.Depot;
import com.surveysampling.depotservice.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@Service
public class DepotServiceImpl implements DepotService {

    private final DepotRepository depotRepository;

    @Autowired
    public DepotServiceImpl(DepotRepository depotRepository) {
        this.depotRepository = depotRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Depot> getDepots() {
        return depotRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Depot getDepotById(Long id) {
        return depotRepository.findOne(id);
    }

    @Override
    @Transactional
    public Depot addDepot(Depot depot) {
        return depotRepository.save(depot);
    }

    @Override
    @Transactional
    public void updateDepotStorageStatus(Long depotId, int value) {
        depotRepository.updateDepotStorage(depotId, value);
    }
}
