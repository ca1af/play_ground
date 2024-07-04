package com.example.play_ground.spring.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Foo(
        @NotNull
        String foo,
        @NotNull
        @Valid
        Bar bar
) {
}
