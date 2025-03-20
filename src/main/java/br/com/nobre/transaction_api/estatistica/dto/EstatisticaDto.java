package br.com.nobre.transaction_api.estatistica.dto;

import br.com.nobre.transaction_api.estatistica.model.Estatistica;

import java.math.BigDecimal;

public record EstatisticaDto(int count, BigDecimal sum, BigDecimal min, BigDecimal max, BigDecimal avg) {

    public EstatisticaDto(Estatistica estatistica) {
        this(estatistica.getCount(), estatistica.getSum(), estatistica.getMin(), estatistica.getMax(), estatistica.getAvg());
    }

}
