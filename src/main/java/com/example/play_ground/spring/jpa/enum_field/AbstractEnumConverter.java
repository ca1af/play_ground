package com.example.play_ground.spring.jpa.enum_field;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractEnumConverter<T extends Enum<T> & EnumInterface<E>, E> implements AttributeConverter<T, E> {
    private final Class<T> clazz;

    protected AbstractEnumConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E convertToDatabaseColumn(T attribute) {
        if (attribute == null){
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        if (Objects.isNull(dbData)){
            return null;
        }
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.getCode().equals(dbData))
                .findFirst()
                .orElseThrow();
    }
}
