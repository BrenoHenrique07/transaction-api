package br.com.nobre.transaction_api.estatistica.service;

import br.com.nobre.transaction_api.estatistica.dto.EstatisticaDto;
import br.com.nobre.transaction_api.estatistica.model.Estatistica;
import br.com.nobre.transaction_api.transacao.model.Transacao;
import br.com.nobre.transaction_api.transacao.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class EstatisticaService {

    private final int DEFAULT_TIME = 60;
    private final TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticaDto getEstatistica(Integer time) {

        time = time == null ? DEFAULT_TIME : time;

        List<Transacao> transacoes = transacaoRepository.getAllTransacoes();
        Estatistica estatistica = new Estatistica();

        int count = 0;
        for(Transacao transacao : transacoes) {

            if(transacao.getDataHora().isBefore(OffsetDateTime.now().minusSeconds(time))) {
                continue;
            }

            if(count == 0) {
                estatistica.setMax(transacao.getValor());
                estatistica.setMin(transacao.getValor());
                estatistica.setSum(transacao.getValor());
            } else {

                estatistica.setSum(estatistica.getSum().add(transacao.getValor()));

                if(transacao.getValor().compareTo(estatistica.getMax()) > 0) {
                    estatistica.setMax(transacao.getValor());
                }

                if(transacao.getValor().compareTo(estatistica.getMin()) < 0) {
                    estatistica.setMin(transacao.getValor());
                }

            }

            count++;

        }

        estatistica.setCount(count);

        if(count > 0) {
            BigDecimal avg = estatistica.getSum().divide(new BigDecimal(count), 2, RoundingMode.HALF_UP);
            estatistica.setAvg(avg);
        }

        return new EstatisticaDto(estatistica);

    }

}
