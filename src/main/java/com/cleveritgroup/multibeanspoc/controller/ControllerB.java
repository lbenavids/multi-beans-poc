
package com.cleveritgroup.multibeanspoc.controller;

import com.cleveritgroup.multibeanspoc.service.DemoService;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Profile("b")
@RequestMapping("/rest-b")
public class ControllerB {

    private final DemoService demoService;

    public ControllerB(Map<String, DemoService> demoServiceMap) {
        this.demoService = demoServiceMap.get("b");
    }


    @GetMapping
    public String getMessage() {
        return demoService.getMessage();
    }
}
