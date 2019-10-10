package com.reactive.smartparking.api.services;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.repository.MonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonitoramentoService {

    @Autowired
    public MonitoramentoRepository monitoramentoRepository;

    public Mono inserirEstadoVaga(MonitoramentoVaga monitoramentoVaga){
        return monitoramentoRepository.save(monitoramentoVaga);
    }
    public Flux<MonitoramentoVaga> exibirEstadoVaga(){
        return monitoramentoRepository.findAll();
    }
}
