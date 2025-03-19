package br.com.nobre.transaction_api.transacao.repository;

import br.com.nobre.transaction_api.transacao.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private final List<Transacao> transacoes;

    public TransacaoRepository() {
        this.transacoes = new LinkedList<>();
    }

    public void save(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public void deleteAll() {
        this.transacoes.clear();
    }

}
