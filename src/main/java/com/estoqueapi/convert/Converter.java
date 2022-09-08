package com.estoqueapi.convert;

@FunctionalInterface
public interface Converter <T,D>{

    T convert (final D domain);

}
