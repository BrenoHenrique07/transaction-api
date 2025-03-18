package br.com.nobre.transaction_api.transacao.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transacao {

    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public Transacao(){}

    public Transacao(BigDecimal valor, OffsetDateTime dataHora){
        this.valor = valor;
        this. dataHora = dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
