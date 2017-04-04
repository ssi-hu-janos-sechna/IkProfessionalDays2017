package com.surveysampling.depotservice;

import com.surveysampling.depotservice.model.Depot;
import com.surveysampling.depotservice.service.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by janos_sechna on 4/2/17.
 */
@RestController
@RequestMapping("/depots")
public class DepotController {

    private final DepotService depotService;

    @Autowired
    public DepotController(DepotService depotService) {
        this.depotService = depotService;
    }

    @GetMapping
    List<Depot> getDepots() {
        return depotService.getDepots();
    }

    @GetMapping("/{depotId}")
    Depot getDepotById(@PathVariable("depotId") @Min(1) Long depotId) {
        return depotService.getDepotById(depotId);
    }

    @PostMapping
    Depot addDepot(@RequestBody @Valid Depot depot) {
        return depotService.addDepot(depot);
    }

    @PutMapping("/{id}")
    void updateDepotStorageStatus(@PathVariable("id") @Min(1) Long depotId,
                                  @RequestParam("value") int value) {
        depotService.updateDepotStorageStatus(depotId, value);
    }
}
