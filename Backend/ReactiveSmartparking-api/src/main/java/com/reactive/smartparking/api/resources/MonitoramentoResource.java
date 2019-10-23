package com.reactive.smartparking.api.resources;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.services.MonitoramentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// TODO: 23/10/2019 Implementar crud e endpoint que retorne apenas o ultimo dado

@RestController
@RequestMapping("/api")
public class MonitoramentoResource {

    @Autowired
    public MonitoramentoService monitoramentoService;

    @CrossOrigin
    @GetMapping("/")
    public String paginaIncial(){
        return "Pagina inicial";
    }

    @PostMapping("/monitoramento")
    public ResponseEntity<Mono> inserir(@RequestBody MonitoramentoVaga monitoramentoVaga){
        return ResponseEntity.status(201).body(monitoramentoService.inserirEstadoVaga(monitoramentoVaga));
    }

    @CrossOrigin
    @GetMapping("/monitoramento")
    public ResponseEntity<Flux> exibir(){
        return ResponseEntity.ok().body(monitoramentoService.exibirEstadoVaga());
    }

}
