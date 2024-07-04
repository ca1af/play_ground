package com.example.play_ground.spring.validation;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;

@Log4j2
@Validated
public class FooBarClient {
    void foo(@Valid Foo foo){
        log.info(foo);
    }
}
