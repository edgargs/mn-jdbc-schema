package com.example;

import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.r2dbc.operations.R2dbcOperations;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import io.r2dbc.spi.Result;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@R2dbcRepository(dialect = Dialect.ORACLE)
public abstract class WOWProductRepository implements ReactiveStreamsCrudRepository<WOWProduct, WOWProductId> {

    private final R2dbcOperations r2dbcOperations;

    protected WOWProductRepository(R2dbcOperations r2dbcOperations) {
        this.r2dbcOperations = r2dbcOperations;
    }


    public abstract Flux<WOWProduct> findAll();

    Mono<Long> truncate() {
        return Mono.from(
                r2dbcOperations.withConnection(connection -> Flux.from(
                                connection.createStatement("TRUNCATE TABLE REGIONALIZACION.LGT_PROD_LOCAL_OFERTA_AUX").execute())
                        .flatMap(Result::getRowsUpdated)
                        .map((Number n) -> n.longValue())
                ));
    }
}
