package com.devtest.els.test.service;

import com.devtest.els.test.domain.Salaried;
import com.devtest.els.test.repository.SalariedRepository;
import com.devtest.els.test.service.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing salaried.
 */
@Service
@Transactional
public class SalariedServiceImp implements SalariedService{

    private final Logger log = LoggerFactory.getLogger(SalariedServiceImp.class);

    private final SalariedRepository salariedRepository;

    public SalariedServiceImp(SalariedRepository salariedRepository){
        this.salariedRepository = salariedRepository;
    }
    /**
     * createManySalaried : insert many of salaried.
     * @param salariedList (List<Salaried>) : list of salaried
     * @return the list of salaried created
     */
    @Override
    public List<Salaried> createManySalaried(List<Salaried> salariedList){
        log.debug("Creation list of salaried {}", salariedList);
        List<Salaried> salariedListToSave = new LinkedList<>();
        salariedList.forEach( salaried -> {
            if (!(salariedRepository.getSalariedById(salaried.getId()).isPresent())){
                salariedRepository.save(salaried);
                salariedListToSave.add(salaried);
            }
        });
        return salariedListToSave;
    }
    /**
     * getAllSalariedsNoDuplicateByCreteria : retrieve list fo salaried not duplicated.
     * @param creteria (String) : key filter
     * @return the list of salaried no duplicated
     */
    @Override
    public List<Salaried> getAllSalariedsNoDuplicateByCreteria(String creteria){
        log.debug("retrieve list of salaried not duplicated by {}", creteria);
        List<Salaried> salariedList = salariedRepository.findAll();
        return io.vavr.collection.List.ofAll(salariedList)
                .distinctBy(salaried -> Utils.creteriaMethode(salaried,creteria.toLowerCase()))
                .toJavaList();

    }

}
