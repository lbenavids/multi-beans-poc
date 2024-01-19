package com.cleveritgroup.multibeanspoc.service;

import com.cleveritgroup.multibeanspoc.repository.DemoRepo;


public class DemoService {


    private final DemoRepo demoRepo;


    public DemoService(DemoRepo demoRepo) {
        this.demoRepo = demoRepo;
    }


    public String getMessage() {
        return demoRepo.getMessage();
    }


}
