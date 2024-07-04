package com.example.play_ground.spring.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record Bar(
        @NotNull
        String bar,
        @Valid
        FooBar fooBar
) {
}
