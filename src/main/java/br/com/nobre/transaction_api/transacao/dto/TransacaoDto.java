package br.com.nobre.transaction_api.transacao.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoDto(BigDecimal valor, OffsetDateTime dataHora) {
}
