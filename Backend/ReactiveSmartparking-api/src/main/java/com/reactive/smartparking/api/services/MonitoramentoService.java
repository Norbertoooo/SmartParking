package com.reactive.smartparking.api.services;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import com.reactive.smartparking.api.repository.MonitoramentoRepository;
import com.reactive.smartparking.api.services.dto.MonitoramentoVagaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.*;

@Service
public class MonitoramentoService {

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

    public Mono<MonitoramentoVaga> exibirPorId(String id) {
        return monitoramentoRepository.findById(id);
    }

    public Mono<Void> deletarPorId(String id) {
        return monitoramentoRepository.deleteById(id);
    }

    public Mono<Void> deletarTudo() {
        return monitoramentoRepository.deleteAll();
    }

    public Flux<MonitoramentoVaga> listaDeSensores() {
        List<MonitoramentoVaga> listaSensores = mongoTemplate.
                findDistinct("nomeSensor", MonitoramentoVaga.class, MonitoramentoVaga.class);
        return Flux.fromIterable(listaSensores);
    }

    public Mono<MonitoramentoVaga> estadoAtual(String nomeSensor) {
        return monitoramentoRepository.findAllByNomeSensor(nomeSensor).last();
    }

    public Flux todosEstadosAtuais() {

        List<MonitoramentoVaga> inferno = mongoTemplate.findAll(MonitoramentoVaga.class);

        Map<String, String> vai = new HashMap<>();

        List<MonitoramentoVagaDTO> vagas = new ArrayList<>();

        for (MonitoramentoVaga monitoramentoVaga : inferno) {
            vai.put(monitoramentoVaga.getNomeSensor(), monitoramentoVaga.getEstadoVaga());
        }


        for (String sensor : vai.keySet()) {
            MonitoramentoVagaDTO vaga = new MonitoramentoVagaDTO();
            vaga.setNomeSensor(sensor);
            vaga.setEstadoVaga(vai.get(sensor));

            vagas.add(vaga);
        }

        return Flux.fromIterable(vagas);
    }

}
