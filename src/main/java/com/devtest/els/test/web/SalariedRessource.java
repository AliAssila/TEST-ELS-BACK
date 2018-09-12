package com.devtest.els.test.web;


import com.devtest.els.test.domain.Salaried;
import com.devtest.els.test.service.SalariedServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for managing all the salaried .
 */
@RestController
@RequestMapping("/api")
public class SalariedRessource {

    private final Logger log = LoggerFactory.getLogger(SalariedServiceImp.class);


    private final SalariedServiceImp salariedServiceImp;

    public SalariedRessource(SalariedServiceImp salariedServiceImp){
        this.salariedServiceImp = salariedServiceImp;
    }

    /**
     * GET  /salaried : get all salarieds no duplicate.
     * @param creteria creteria of filter
     * @return the ResponseEntity with status 200 (OK) and with body all salaried no duplicate
     */
    @GetMapping("/salaried/{creteria}")
    public  ResponseEntity<List<Salaried>> getAllSalriedNoduplicate(@PathVariable String creteria){
        log.debug("REST request to get list salaried not duplicated by : {}",creteria);
        final List<Salaried> salariedList = salariedServiceImp.getAllSalariedsNoDuplicateByCreteria(creteria);
    return new ResponseEntity<>(salariedList, HttpStatus.OK);
    }
    /**
     * POST  /salaried : insert Many of  salarieds.
     * @param salariedList : list of salaried
     * @return the ResponseEntity with status 200 (OK) and with body all salaried created
     */
    @PostMapping("/salaried")
    public ResponseEntity createSalaried(@Valid @RequestBody List<Salaried> salariedList){
        log.debug("REST request to save list of Salaried : {}", salariedList);
        List<Salaried> allSalried= salariedServiceImp.createManySalaried(salariedList);
        return new ResponseEntity<>(allSalried, HttpStatus.OK);
    }

}
