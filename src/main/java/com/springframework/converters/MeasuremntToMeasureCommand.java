package com.springframework.converters;

import com.springframework.commands.MeasurementCommand;
import com.springframework.domain.Mesurements;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class MeasuremntToMeasureCommand implements Converter<Mesurements, MeasurementCommand> {

    @Synchronized
    @Nullable
    @Override
    public MeasurementCommand convert(Mesurements unitOfMeasure) {

        if(unitOfMeasure != null) {
            final MeasurementCommand uomc = new MeasurementCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
            return uomc;
        }

        return null;

    }
}
