package com.cleveritgroup.multibeanspoc.controller;

import com.cleveritgroup.multibeanspoc.service.DemoService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Profile("a")
@RequestMapping("/rest-a")
public class ControllerA {

    private final DemoService demoService;

    public ControllerA(Map<String, DemoService> demoServiceMap) {
        this.demoService = demoServiceMap.get("a");
    }

    @GetMapping
    public String getMessage() {
        return demoService.getMessage();
    }
}
