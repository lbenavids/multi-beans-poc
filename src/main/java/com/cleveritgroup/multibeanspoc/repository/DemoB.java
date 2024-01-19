package com.cleveritgroup.multibeanspoc.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("b")
public class DemoB implements DemoRepo {
    @Override
    public String getMessage() {
        return "Repo B";
    }
}
