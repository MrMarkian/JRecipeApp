package com.springframework.services;

import com.springframework.commands.MeasurementCommand;
import com.springframework.converters.MeasuremntToMeasureCommand;
import com.springframework.domain.Mesurements;
import com.springframework.domain.repositories.MeasurementsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MeasurementsServiceImplTest {
    MeasuremntToMeasureCommand measuremntToMeasureCommand = new MeasuremntToMeasureCommand();
   MeasurementsService service;

    @Mock
    MeasurementsRepository measurementsRepository;

    @BeforeEach
    protected void setUp(){
        MockitoAnnotations.initMocks(this);
        service = new MeasurementsServiceImpl(measurementsRepository,measuremntToMeasureCommand);
    }

    @Test
    void listAllMeasurements(){

        Set<Mesurements> unitSet = new HashSet<>();
        Mesurements unit = new Mesurements();

        unit.setId(1L);
        unitSet.add(unit);

        Mesurements unit2 = new Mesurements();
        unit2.setId(2L);
        unitSet.add(unit2);

        when(measurementsRepository.findAll()).thenReturn(unitSet);

        Set<MeasurementCommand> commands = service.listAllMeasurements();

        assertEquals(2, commands.size());
        verify(measurementsRepository, times(1)).findAll();



    }
}