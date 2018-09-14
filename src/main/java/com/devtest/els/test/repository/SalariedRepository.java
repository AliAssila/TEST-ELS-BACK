package com.devtest.els.test.repository;

import com.devtest.els.test.domain.Salaried;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalariedRepository extends MongoRepository<Salaried,String> {
    Optional<Salaried> getSalariedById(String id);
}
