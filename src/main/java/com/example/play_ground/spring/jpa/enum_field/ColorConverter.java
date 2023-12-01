package com.example.play_ground.spring.jpa.enum_field;

import jakarta.persistence.AttributeConverter;

public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color attribute) {
        if (attribute == null){
            return null;
        }
        return attribute.getName();
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        return Color.getInstance(dbData);
    }
}
