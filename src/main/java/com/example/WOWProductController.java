package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Mono<WOWProduct> insert(WOWProduct wowProduct) {
        return wowProductService.truncate()
                .log()
                .thenReturn(
                        new WOWProduct(null,0,null,null,null,null)
                );
    }
}
