package com.reactive.smartparking.api.repository;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoRepository extends ReactiveMongoRepository<MonitoramentoVaga, String> {
}
