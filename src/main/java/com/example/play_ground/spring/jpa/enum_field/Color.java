package com.example.play_ground.spring.jpa.enum_field;

import lombok.Getter;

import java.util.Arrays;

public enum Color {
    RED("빨간색"),
    YELLOW("노란색"),
    ORANGE("오렌지색");
    @Getter
    private final String name;

    Color(String name) {
        this.name = name;
    }

    public static Color getInstance(String name){
        return Arrays.stream(values())
                .filter(color -> color.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
