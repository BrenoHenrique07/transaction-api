package br.com.nobre.transaction_api.transacao.controller;

import br.com.nobre.transaction_api.transacao.dto.TransacaoDto;
import br.com.nobre.transaction_api.transacao.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransacao(@RequestBody TransacaoDto transacaoDto)  {

        this.transacaoService.createTransacao(transacaoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTransacoes() {

        this.transacaoService.deleteAllTransacoes();
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
