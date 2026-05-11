package org.example.dto.NewDTO.NewConverterDTO;

public interface ConverterDTO<T, V> {

    T toEntity(V v);

    V toDTO(T t);
}
