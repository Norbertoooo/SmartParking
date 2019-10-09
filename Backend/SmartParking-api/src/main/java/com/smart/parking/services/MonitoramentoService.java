package com.smart.parking.services;

import com.smart.parking.domain.MonitoramentoVaga;
import com.smart.parking.repository.MonitoramentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoramentoService {

    @Autowired
    public MonitoramentoRepository monitoramentoRepository;

    public MonitoramentoVaga inserirEstadoVaga( MonitoramentoVaga monitoramentoVaga){
        return monitoramentoRepository.save(monitoramentoVaga);
    }
    public List<MonitoramentoVaga> exibirEstadoVaga(){
        return monitoramentoRepository.findAll();
    }
}
