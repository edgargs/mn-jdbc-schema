package com.example;

import io.micronaut.validation.validator.Validator;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.Set;

@Singleton
public class WOWProductService {
    private static final Logger LOG = LoggerFactory.getLogger(WOWProductService.class);

    private final WOWProductRepository wowProductRepository;
    private final Validator validator;

    public WOWProductService(WOWProductRepository wowProductRepository, Validator validator) {
        this.wowProductRepository = wowProductRepository;
        this.validator = validator;
    }

    Mono<Long> truncate() {
        return wowProductRepository.truncate();
    }

    public Flux<WOWProduct> findAll() {
        return wowProductRepository.findAll();
    }

    public Mono<WOWProduct> save(WOWProduct wowProduct) {
        Set<ConstraintViolation<WOWProduct>> constraintViolations = validator.validate(wowProduct);
        LOG.info(String.valueOf(constraintViolations.size()));
        return wowProductRepository.truncate()
                .then(wowProductRepository.save(wowProduct));
    }

    public Mono<Integer> findVencidos() {
        return wowProductRepository.countVencidos(LocalDateTime.now());
    }

    public Flux<WOWProduct> findDcto(float dcto) {
        return wowProductRepository.findByPorcDctoOferta(dcto);
    }
}
