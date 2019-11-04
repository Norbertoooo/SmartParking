package com.reactive.smartparking.api.resources;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.services.MonitoramentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// todo Metodo put sem funcionar

@RestController
@RequestMapping("/api")
public class MonitoramentoResource {

    @Autowired
    public MonitoramentoService monitoramentoService;

    @PostMapping("/monitoramento")
    public ResponseEntity<Mono> inserir(@RequestBody MonitoramentoVaga monitoramentoVaga){
        return ResponseEntity.status(201).body(monitoramentoService.inserir(monitoramentoVaga));
    }

    // TODO: 04/11/2019 pesquisar mais sobre "text/event-stream"
    /*
    @CrossOrigin
    @GetMapping(value = "/monitoramento/live", produces = "text/event-stream")
    public ResponseEntity<Flux> liveconsulta(){
        return ResponseEntity.ok().body(monitoramentoService.exibirTudo());
    }
    */
    @CrossOrigin
    @GetMapping("/monitoramento")
    public ResponseEntity<Flux> consulta(){
        return ResponseEntity.ok().body(monitoramentoService.exibirTudo());
    }

    @CrossOrigin
    @GetMapping("/monitoramento/atual")
    public ResponseEntity<Mono> consultaDeEstadoAtual(){
        return ResponseEntity.ok().body(monitoramentoService.estadoAtual());
    }

    @CrossOrigin
    @GetMapping("/monitoramento/{id}")
    public ResponseEntity<Mono> consultaPorId(@PathVariable String id){
        return ResponseEntity.ok().body(monitoramentoService.exibirPorId(id));
    }

    @PutMapping("/monitoramento")
    public ResponseEntity<Mono> atualizar(@RequestBody MonitoramentoVaga monitoramentoVagaAtualizado) {
        monitoramentoService.atualizar(monitoramentoVagaAtualizado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/monitoramento")
    public ResponseEntity<Mono> deletarTudo(){
        return ResponseEntity.status(204).body(monitoramentoService.deletarTudo());
    }

    @DeleteMapping("/monitoramento/{id}")
    public ResponseEntity<Mono> deletarPorId(@PathVariable String id){
        return ResponseEntity.status(204).body(monitoramentoService.deletarPorId(id));
    }


}
