package com.cleveritgroup.multibeanspoc.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("a")
public class RepoA implements DemoRepo {
    @Override
    public String getMessage() {
        return "Repo A";
    }
}
