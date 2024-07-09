package com.example.play_ground.spring.asnyc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncTaskController{

    private final DataSupplyService dataSupplyService;
    @GetMapping("/simple/async")
    public void foo(){
        dataSupplyService.getData();
    }
}
