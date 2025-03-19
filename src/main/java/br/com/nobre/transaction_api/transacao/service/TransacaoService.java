package br.com.nobre.transaction_api.transacao.service;

import br.com.nobre.transaction_api.transacao.repository.TransacaoRepository;
import br.com.nobre.transaction_api.transacao.dto.TransacaoDto;
import br.com.nobre.transaction_api.transacao.model.Transacao;
import br.com.nobre.transaction_api.transacao.validate.TransacaoValidate;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public void createTransacao(TransacaoDto transacaoDto) {

        TransacaoValidate.validateInputs(transacaoDto);
        Transacao transacao = new Transacao(transacaoDto.valor(), transacaoDto.dataHora());

        transacaoRepository.save(transacao);

    }

    public void deleteAllTransacoes() {
        transacaoRepository.deleteAll();
    }

}
