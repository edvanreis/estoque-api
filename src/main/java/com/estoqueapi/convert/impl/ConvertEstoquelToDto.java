package com.estoqueapi.convert.impl;

import com.estoqueapi.convert.Converter;
import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.model.Estoque;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConvertEstoquelToDto implements Converter<EstoqueDTO, Estoque> {

    @Override
    public EstoqueDTO convert(Estoque estoque) {
        if(Objects.isNull(estoque)){
            return null;
        }
        return    EstoqueDTO.builder()
                            .id(estoque.getId())
                            .product(estoque.getProduct())
                            .quantity(estoque.getQuantity())
                            .type(estoque.getType())
                            .industry(estoque.getIndustry())
                            .origin(estoque.getOrigin())
                            .file(estoque.getFile())
                            .price(estoque.getPrice())
                            .build();
    }

}
