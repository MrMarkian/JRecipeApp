package com.springframework.services;

import com.springframework.commands.MeasurementCommand;

import java.util.Set;

public interface MeasurementsService {

    Set<MeasurementCommand> listAllMeasurements();
}
