package br.com.nobre.transaction_api.transacao.validate;

import br.com.nobre.transaction_api.transacao.dto.TransacaoDto;
import br.com.nobre.transaction_api.core.exception.model.PayloadException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransacaoValidate {

    public static void validateInputs(TransacaoDto transacaoDto) {

        if(transacaoDto.valor() == null || transacaoDto.dataHora() == null) {
            throw new PayloadException("Campos valor e dataHora não pode ser nulos");
        }

        if(transacaoDto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new PayloadException("Campo dataHora não pode estar no futuro");
        }

        if(transacaoDto.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new PayloadException("Campo valor não pode ser igual ou menor que zero");
        }

    }

}
