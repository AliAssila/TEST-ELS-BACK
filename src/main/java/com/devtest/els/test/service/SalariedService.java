package com.devtest.els.test.service;

import com.devtest.els.test.domain.Salaried;

import java.util.List;
/**
 * Service interface for managing salaried.
 */
public interface SalariedService {

    List<Salaried> getAllSalarieds();
    List<Salaried> createManySalaried(List<Salaried> salariedList);
    List<Salaried> getAllSalariedsNoDuplicateByCreteria(String creteria);
}
