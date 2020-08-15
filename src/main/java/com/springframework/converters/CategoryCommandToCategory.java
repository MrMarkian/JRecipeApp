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
public class CategoryCommandToCategory implements Converter<CatagoryCommand, Catagory> {

    @Synchronized
    @Nullable
    @Override
    public Catagory convert(CatagoryCommand source) {
        if (source == null) {
            return null;
        }

        final Catagory category = new Catagory();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
