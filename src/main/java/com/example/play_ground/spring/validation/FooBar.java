package com.example.play_ground.spring.validation;

import jakarta.validation.constraints.NotNull;

public record FooBar(
        @NotNull
        String fooBar
) {
}
