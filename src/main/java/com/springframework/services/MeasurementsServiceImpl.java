package com.springframework.services;

import com.springframework.commands.MeasurementCommand;
import com.springframework.converters.MeasuremntToMeasureCommand;
import com.springframework.repositories.MeasurementsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MeasurementsServiceImpl implements MeasurementsService {

    private final MeasurementsRepository measurementsRepository;
    private final MeasuremntToMeasureCommand measuremntToMeasureCommand;

    public MeasurementsServiceImpl(MeasurementsRepository measurementsRepository, MeasuremntToMeasureCommand measuremntToMeasureCommand) {
        this.measurementsRepository = measurementsRepository;
        this.measuremntToMeasureCommand = measuremntToMeasureCommand;
    }

    @Override
    @Transactional
    public Set<MeasurementCommand> listAllMeasurements() {
        return StreamSupport.stream(measurementsRepository.findAll()
        .spliterator(), false)
                .map(measuremntToMeasureCommand::convert)
                .collect(Collectors.toSet());
    }
}
