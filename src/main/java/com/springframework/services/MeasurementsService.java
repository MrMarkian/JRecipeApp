package com.springframework.services;

import com.springframework.commands.MeasurementCommand;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface MeasurementsService {

    Set<MeasurementCommand> listAllMeasurements();
}
