package com.estoqueapi.convert.impl;

import com.estoqueapi.convert.Converter;
import com.estoqueapi.dto.TypeDTO;
import com.estoqueapi.model.Type;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConvertTypeToDto implements Converter<TypeDTO, Type> {

    @Override
    public TypeDTO convert(Type type) {
        if(Objects.isNull(type)){
            return null;
        }
        return    TypeDTO.builder()
                            .id(type.getId())
                            .name(type.getName())
                            .build();
    }

}
