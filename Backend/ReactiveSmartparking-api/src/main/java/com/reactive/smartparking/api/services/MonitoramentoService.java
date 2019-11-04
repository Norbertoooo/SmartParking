package com.reactive.smartparking.api.services;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.repository.MonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonitoramentoService  {

    @Autowired
    public MonitoramentoRepository monitoramentoRepository;

    public Mono inserir(MonitoramentoVaga monitoramentoVaga) {
        return monitoramentoRepository.save(monitoramentoVaga);
    }
    public Flux<MonitoramentoVaga> exibirTudo(){
        return monitoramentoRepository.findAll();
    }
    public Mono<MonitoramentoVaga> exibirPorId(String id){
        return monitoramentoRepository.findById(id);
    }
    public Mono<Void> deletarPorId(String id){
        return monitoramentoRepository.deleteById(id);
    }
    public Mono<Void> deletarTudo() {
        return monitoramentoRepository.deleteAll();
    }
    public void atualizar(MonitoramentoVaga monitoramentoVagaNovo) {
       Mono mono = monitoramentoRepository.save(monitoramentoVagaNovo);
    }
    public Mono<MonitoramentoVaga> estadoAtual() {
        return exibirTudo().last();
    }

}
