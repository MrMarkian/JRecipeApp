package com.springframework.repositories;

import com.springframework.domain.Mesurements;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MeasurementsRepository extends CrudRepository<Mesurements, Long> {


    Optional<Mesurements> findByDescription(String unitOfMeasure);
}
