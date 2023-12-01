package com.example.play_ground.spring.jpa.enum_field;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class FooEntityTest {
    @Test
    void enumPrac() {
        Color color = null;
        assertThatThrownBy(() -> color.getName()).isInstanceOf(NullPointerException.class);
    }
}