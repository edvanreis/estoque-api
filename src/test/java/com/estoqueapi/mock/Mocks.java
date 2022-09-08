package com.estoqueapi.mock;

import com.estoqueapi.dto.EstoqueDTO;
import com.estoqueapi.model.Estoque;


public class Mocks {

    public static EstoqueDTO createEstoqueDto(){
        return EstoqueDTO.builder()
                .id("63175bbcdb93e17ca4c27cf7")
                .product("LONE")
                .quantity(47l)
                .price("$5.83")
                .type("2XL")
                .industry("Oil & Gas Production")
                .origin("CA")
                .build();
    }

    public static Estoque createEstoque(){
        return Estoque.builder()
                .id("63175bbcdb93e17ca4c27cf7")
                .product("LONE")
                .quantity(47l)
                .price("$5.83")
                .type("2XL")
                .industry("Oil & Gas Production")
                .origin("CA")
                .build();
    }
}
