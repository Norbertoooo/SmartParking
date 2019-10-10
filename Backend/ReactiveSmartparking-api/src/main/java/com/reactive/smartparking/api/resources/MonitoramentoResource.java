package com.reactive.smartparking.api.resources;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.services.MonitoramentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MonitoramentoResource {

    @Autowired
    public MonitoramentoService monitoramentoService;

    @PostMapping("/monitoramento")
    public Mono inserir(@RequestBody MonitoramentoVaga monitoramentoVaga){
        return monitoramentoService.inserirEstadoVaga(monitoramentoVaga);
    }

    @CrossOrigin
    @GetMapping("/monitoramento")
    public ResponseEntity<Flux> exibir(){
        return ResponseEntity.ok().body(monitoramentoService.exibirEstadoVaga());
    }

}
