package com.estoqueapi.convert;

import com.estoqueapi.model.Estoque;

@FunctionalInterface
public interface ConverterForUpdate<T, D> {
    T convert(final T model,final D domain);

}
