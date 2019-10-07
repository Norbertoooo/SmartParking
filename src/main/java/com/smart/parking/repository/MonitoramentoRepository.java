package com.smart.parking.repository;

import com.smart.parking.domain.MonitoramentoVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoramentoRepository extends JpaRepository<MonitoramentoVaga, Long> {
}
