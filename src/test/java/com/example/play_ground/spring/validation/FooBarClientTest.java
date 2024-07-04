package com.example.play_ground.spring.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
class FooBarClientTest {
    Validator validator;
    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void validated() {
        Bar bar = new Bar("bar", new FooBar(null));
        Foo foo = new Foo("foo", bar);

        Set<ConstraintViolation<Foo>> validate = validator.validate(foo);
        assertThat(validate).isNotEmpty();
    }
}