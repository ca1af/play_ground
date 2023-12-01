package com.example.play_ground.spring.jpa.enum_field;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FooEntity {
    @Id
    private Long id;
    @Convert(converter = ColorConverter.class)
    private Color color;
}
