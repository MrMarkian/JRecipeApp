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
public class MeasureCommandToMesurment implements Converter<MeasurementCommand, Mesurements>{

    @Synchronized
    @Nullable
    @Override
    public Mesurements convert(MeasurementCommand source) {


        final Mesurements uom = new Mesurements();
        uom.setId(source.getId());
        uom.setUnitOfMeasure(source.getDescription());
        return uom;
    }
}
