package com.smart.parking.resources;

import com.smart.parking.domain.MonitoramentoVaga;
import com.smart.parking.services.MonitoramentoService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MonitoramentoResource {

    @Autowired
    public MonitoramentoService monitoramentoService;

    @PostMapping("/monitoramento")
    public ResponseEntity<MonitoramentoVaga> inserir(@RequestBody MonitoramentoVaga monitoramentoVaga){
        monitoramentoVaga = monitoramentoService.inserirEstadoVaga(monitoramentoVaga);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(monitoramentoVaga.getId()).
                toUri();
        return ResponseEntity.created(uri).body(monitoramentoVaga);
    }

    @CrossOrigin
    @GetMapping("/monitoramento")
    public ResponseEntity<List<MonitoramentoVaga>> exibir(){
        return ResponseEntity.ok().body(monitoramentoService.exibirEstadoVaga());
    }

}
