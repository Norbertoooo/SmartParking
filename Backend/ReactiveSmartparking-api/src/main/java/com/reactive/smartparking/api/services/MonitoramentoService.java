package com.reactive.smartparking.api.services;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.repository.MonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MonitoramentoService  {

    @Autowired
    public MonitoramentoRepository monitoramentoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Mono inserir(MonitoramentoVaga monitoramentoVaga) {
        return monitoramentoRepository.insert(monitoramentoVaga);
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

    public Mono<MonitoramentoVaga> atualizar(MonitoramentoVaga monitoramentoVagaNovo) {
       return monitoramentoRepository.save(monitoramentoVagaNovo);
    }

    public List<MonitoramentoVaga> listaDeSensores(){
       return mongoTemplate.findDistinct("nomeSensor", MonitoramentoVaga.class, MonitoramentoVaga.class);
    }

    public Mono<MonitoramentoVaga> estadoAtual(String nomeSensor) {
            return monitoramentoRepository.findAllByNomeSensor(nomeSensor).last();
    }

}
