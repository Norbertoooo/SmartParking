package com.reactive.smartparking.api.resources;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.services.MonitoramentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class MonitoramentoResource {

    @Autowired
    public MonitoramentoService monitoramentoService;

    @PostMapping("/monitoramento")
    public ResponseEntity<Mono> inserir(@RequestBody MonitoramentoVaga monitoramentoVaga) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monitoramentoService.inserir(monitoramentoVaga));
    }

    @CrossOrigin @GetMapping ("/monitoramento/sensores")
    public ResponseEntity<Flux> listaDeSensores() {
        return ResponseEntity.ok().body(monitoramentoService.listaDeSensores());
    }

    @CrossOrigin @GetMapping("/monitoramento/atual")
    public ResponseEntity<Flux> consultaDeTodosEstadosAtuais() {
        return ResponseEntity.ok().body(monitoramentoService.todosEstadosAtuais());
    }

    @CrossOrigin @GetMapping("/monitoramento")
    public ResponseEntity<Flux> consulta(){
        return ResponseEntity.ok().body(monitoramentoService.exibirTudo());
    }

    @CrossOrigin @GetMapping("/monitoramento/atual/{nomeSensor}")
    public ResponseEntity<Mono> consultaDeEstadoAtual(@PathVariable String nomeSensor) {
        return ResponseEntity.ok().body(monitoramentoService.estadoAtual(nomeSensor));
    }

    @CrossOrigin @GetMapping("/monitoramento/{id}")
    public ResponseEntity<Mono> consultaPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(monitoramentoService.exibirPorId(id));
    }

    @DeleteMapping("/monitoramento")
    public ResponseEntity<Mono> deletarTudo() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(monitoramentoService.deletarTudo());
    }

    @DeleteMapping("/monitoramento/{id}")
    public ResponseEntity<Mono> deletarPorId(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(monitoramentoService.deletarPorId(id));
    }


}
