package com.example;

import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class WOWProductService {

    private final WOWProductRepository wowProductRepository;

    public WOWProductService(WOWProductRepository wowProductRepository) {
        this.wowProductRepository = wowProductRepository;
    }

    Mono<Long> truncate() {
        return wowProductRepository.truncate();
    }

    public Flux<WOWProduct> findAll() {
        return wowProductRepository.findAll();
    }
}
