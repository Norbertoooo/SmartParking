package com.reactive.smartparking.api.services.dto;

import com.reactive.smartparking.api.domain.MonitoramentoVaga;
import lombok.Data;

@Data
public class MonitoramentoVagaDTO {

    private String nomeSensor;
    private String estadoVaga;

    public MonitoramentoVagaDTO() {
    }

    public MonitoramentoVagaDTO(MonitoramentoVaga monitoramentoVaga) {
        this.nomeSensor = monitoramentoVaga.getNomeSensor();
        this.estadoVaga = monitoramentoVaga.getEstadoVaga();
    }

}
