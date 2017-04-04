package com.surveysampling.depotservice.service;

import com.surveysampling.depotservice.model.Depot;

import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
public interface DepotService {

    List<Depot> getDepots();

    Depot getDepotById(Long id);

    Depot addDepot(Depot depot);

    void updateDepotStorageStatus(Long depotId, int value);
}
