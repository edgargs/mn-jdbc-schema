package com.example;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Singleton
public class WOWProductService {
    private static final Logger LOG = LoggerFactory.getLogger(WOWProductService.class);

    private final WOWProductRepository wowProductRepository;

    public WOWProductService(WOWProductRepository wowProductRepository) {
        this.wowProductRepository = wowProductRepository;
    }

    public Mono<Long> truncate() {
        return wowProductRepository.truncate();
    }

    public Mono<WOWProduct> save(WOWProductDTO wowProductDTO) {
        var wowProductId = new WOWProductId(wowProductDTO.getCodGrupoCia(),
                wowProductDTO.getCodLocal(),
                wowProductDTO.getCodOferta(),
                wowProductDTO.getCodProd());
        var wowProduct = new WOWProduct(wowProductId,
                wowProductDTO.getPorcDctoOferta(),
                wowProductDTO.getFecIniVigOferta(),
                null,null,null);
        return wowProductRepository.save(wowProduct);
    }

    public Flux<WOWProduct> findAll() {
        return wowProductRepository.findAll();
    }

    public Mono<Integer> findVencidos() {
        return wowProductRepository.countVencidos(LocalDateTime.now());
    }

    public Flux<WOWProduct> findDcto(float dcto) {
        return wowProductRepository.findByPorcDctoOferta(dcto);
    }
}
