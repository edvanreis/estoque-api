package com.estoqueapi.mock;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.model.Estoque;

public class Mocks {

    public static EstoqueDTO createEstoqueDto(){
        return EstoqueDTO.builder()
                .product("LONE")
                .quantity(47l)
                .price("$5.83")
                .type("2XL")
                .industry("Oil & Gas Production")
                .origin("CA")
                .build();
    }
}
