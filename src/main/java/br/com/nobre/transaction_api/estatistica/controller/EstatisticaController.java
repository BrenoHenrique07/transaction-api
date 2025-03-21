package br.com.nobre.transaction_api.estatistica.controller;

import br.com.nobre.transaction_api.estatistica.dto.EstatisticaDto;
import br.com.nobre.transaction_api.estatistica.service.EstatisticaService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDto> getEstatistica(@RequestParam(name = "time", required = false) Integer time) {

        EstatisticaDto estatisticaDto = estatisticaService.getEstatistica(time);
        return new ResponseEntity<EstatisticaDto>(estatisticaDto, HttpStatus.OK);

    }

}
