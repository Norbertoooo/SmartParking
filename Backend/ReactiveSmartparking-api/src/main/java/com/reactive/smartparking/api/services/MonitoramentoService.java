package com.reactive.smartparking.api.services;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.repository.MonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class MonitoramentoService  {

    @Autowired
    public MonitoramentoRepository monitoramentoRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Mono inserir(MonitoramentoVaga monitoramentoVaga) {
        return monitoramentoRepository.insert(monitoramentoVaga);
    }

    public Flux<MonitoramentoVaga> exibirTudo() {
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

    public Flux<MonitoramentoVaga> listaDeSensores() {
        List<MonitoramentoVaga> lista = mongoTemplate.
                findDistinct("nomeSensor", MonitoramentoVaga.class, MonitoramentoVaga.class);
        return Flux.fromIterable(lista);
    }

    public Mono<MonitoramentoVaga> estadoAtual(String nomeSensor) {
        return monitoramentoRepository.findAllByNomeSensor(nomeSensor).last();
    }

    public Mono todosEstadosAtuais() {

        List<MonitoramentoVaga> inferno = mongoTemplate.findAll(MonitoramentoVaga.class);

        Map<String,String> vai = new HashMap<String, String>();

        for (MonitoramentoVaga monitoramentoVaga: inferno) {
            vai.put(monitoramentoVaga.getNomeSensor(), monitoramentoVaga.getEstadoVaga());
        }

        return Mono.just(vai);
    }

}
