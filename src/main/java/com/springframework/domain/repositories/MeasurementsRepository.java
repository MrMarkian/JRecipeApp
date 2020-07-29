package com.springframework.domain.repositories;

import com.springframework.domain.Mesurements;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MeasurementsRepository extends CrudRepository<Mesurements, Long> {


    Optional<Mesurements> findByUnitOfMeasure(String unitOfMeasure);
}
