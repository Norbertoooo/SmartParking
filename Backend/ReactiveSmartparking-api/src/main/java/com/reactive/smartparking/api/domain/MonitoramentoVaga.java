package com.reactive.smartparking.api.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// TODO: 23/10/2019 Vereficar se a anotação @data esta funcionando

@Document
@Data
public class MonitoramentoVaga {

    @Id
    private String id;
    private String nomeSensor;
    private String estadoVaga;

}
