package com.springframework.repositories;

import com.springframework.domain.Mesurements;
import com.springframework.services.MeasurementsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class MeasurementsRepositoryTestIT {

    @Autowired
    MeasurementsRepository measurementsRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUnitOfMeasure() {
        Optional <Mesurements> mesurementsOptional = measurementsRepository.findByDescription("Tea Spoon");
        assertEquals("Tea Spoon",mesurementsOptional.get().getDescription());
    }
}