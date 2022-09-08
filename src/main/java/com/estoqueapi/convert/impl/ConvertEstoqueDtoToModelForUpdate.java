package com.estoqueapi.convert.impl;

import com.estoqueapi.convert.ConverterForUpdate;
import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.model.Estoque;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class ConvertEstoqueDtoToModelForUpdate implements ConverterForUpdate<Estoque, EstoqueDTO>{

    @Override
    @SneakyThrows
    public Estoque convert(Estoque model, EstoqueDTO dto) {
        if(Objects.isNull(model) || Objects.isNull(dto) ){
            return null;
        }
        model.setProduct(dto.getProduct());
        model.setQuantity(dto.getQuantity());
        model.setType(dto.getType());
        model.setIndustry(dto.getIndustry());
        model.setOrigin(dto.getOrigin());
        model.setFile(dto.getFile());
        model.setPrice(dto.getPrice());
        model.setFile(dto.getFile());
        model.setDataAtualizacao(LocalDateTime.now());
        return model;

    }
}
