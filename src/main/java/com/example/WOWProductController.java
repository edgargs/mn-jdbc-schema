package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller("/")
public class WOWProductController {

    protected final WOWProductService wowProductService;

    public WOWProductController(WOWProductService wowProductService) {
        this.wowProductService = wowProductService;
    }

    @Get("/list")
    public Flux<WOWProduct> list() {
        return wowProductService.findAll();
    }

    @Post("/")
    public Mono<WOWProduct> insert(@Valid WOWProduct wowProduct) {
        return wowProductService.save(wowProduct);
    }

    @Get("/wow/vencidos")
    public Mono<Integer> vencidos() {
        return wowProductService.findVencidos();
    }

    @Get("/wow")
    public Flux<WOWProduct> byDcto(float dcto) {
        return wowProductService.findDcto(dcto);
    }
}
