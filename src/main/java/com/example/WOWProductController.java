package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/")
public class WOWProductController {

    protected final WOWProductRepository wowProductRepository;

    public WOWProductController(WOWProductRepository wowProductRepository) {
        this.wowProductRepository = wowProductRepository;
    }

    @Get("/list")
    public List<WOWProduct> list() {
        return wowProductRepository.findAll();
    }
}
