package com.example;

import io.micronaut.core.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 *
 * @param id
 * @param porcDctoOferta
 * @param fecIniVigOferta
 * @param fecFinVigOferta
 * @param usuCreaProdLocOfe
 * @param fecCreaProdLocOfe
 */
@Table(name = "LGT_PROD_LOCAL_OFERTA_AUX", schema = "REGIONALIZACION")
public record WOWProduct(@EmbeddedId WOWProductId id,
                         float porcDctoOferta,
                         LocalDateTime fecIniVigOferta,
                         @Nullable LocalDateTime fecFinVigOferta,
                         @Nullable String usuCreaProdLocOfe,
                         @Nullable LocalDateTime fecCreaProdLocOfe) {
}

/**
 *
 * @param codGrupoCia
 * @param codLocal
 * @param codOferta
 * @param codProd
 */
@Embeddable
record WOWProductId(
        @Column(name = "COD_GRUPO_CIA") String codGrupoCia,
        @Column(name = "COD_LOCAL") String codLocal,
        @Column(name = "COD_OFERTA") String codOferta,
        @Column(name = "COD_PROD") String codProd) {
}
