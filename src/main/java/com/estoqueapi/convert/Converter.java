package com.estoqueapi.convert;

@FunctionalInterface
public interface Converter <T,D>{

    T converter (final D domain);

}
