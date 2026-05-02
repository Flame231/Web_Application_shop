package org.example.converterDTO;

public interface ConverterDTO<T, V> {

    T toEntity(V v);

    V toDTO(T t);
}
