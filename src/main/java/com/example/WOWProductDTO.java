package com.example;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Introspected
public class WOWProductDTO {

    @NotBlank
    private String codGrupoCia;
    private String codLocal;
    private String codOferta;
    private String codProd;
    @Min(8L)
    private long porcDctoOferta;
    private LocalDateTime fecIniVigOferta;

    public String getCodGrupoCia() {
        return codGrupoCia;
    }

    public void setCodGrupoCia(String codGrupoCia) {
        this.codGrupoCia = codGrupoCia;
    }

    public String getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(String codLocal) {
        this.codLocal = codLocal;
    }

    public String getCodOferta() {
        return codOferta;
    }

    public void setCodOferta(String codOferta) {
        this.codOferta = codOferta;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public long getPorcDctoOferta() {
        return porcDctoOferta;
    }

    public void setPorcDctoOferta(long porcDctoOferta) {
        this.porcDctoOferta = porcDctoOferta;
    }

    public LocalDateTime getFecIniVigOferta() {
        return fecIniVigOferta;
    }

    public void setFecIniVigOferta(LocalDateTime fecIniVigOferta) {
        this.fecIniVigOferta = fecIniVigOferta;
    }
}
