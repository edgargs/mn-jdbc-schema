package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller("/wow")
public class WOWProductController {

    protected final WOWProductService wowProductService;

    public WOWProductController(WOWProductService wowProductService) {
        this.wowProductService = wowProductService;
    }

    @Post("/")
    public Mono<WOWProduct> insert(@Valid WOWProduct wowProduct) {
        return wowProductService.save(wowProduct);
    }

    @Get("/list")
    public Flux<WOWProduct> list() {
        return wowProductService.findAll();
    }

    @Get("/list/vencidos")
    public Mono<Integer> vencidos() {
        return wowProductService.findVencidos();
    }

    @Get("/search")
    public Flux<WOWProduct> byDcto(float dcto) {
        return wowProductService.findDcto(dcto);
    }
}
