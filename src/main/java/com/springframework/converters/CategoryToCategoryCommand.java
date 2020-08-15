package com.springframework.converters;

import com.springframework.commands.CatagoryCommand;
import com.springframework.domain.Catagory;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryToCategoryCommand implements Converter<Catagory, CatagoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CatagoryCommand convert(Catagory source) {
        if (source == null) {
            return null;
        }


        final CatagoryCommand categoryCommand = new CatagoryCommand();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
