package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Collections;

@Validated
@Controller("/wow")
public class WOWProductController {

    protected final WOWProductService wowProductService;

    public WOWProductController(WOWProductService wowProductService) {
        this.wowProductService = wowProductService;
    }

    @Post("/")
    public Mono<WOWProduct> insert(@Valid WOWProductDTO wowProductDTO) {
        return wowProductService.save(wowProductDTO);
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

    @Post("/send")
    public HttpResponse send(@Body @Valid WOWProductDTO wowProductDTO) { //
        return HttpResponse.ok(Collections.singletonMap("msg", "OK"));
    }
}
