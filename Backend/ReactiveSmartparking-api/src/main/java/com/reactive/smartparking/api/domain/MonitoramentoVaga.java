package com.reactive.smartparking.api.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MonitoramentoVaga {

    @Id
    private String id;
    private String nomeSensor;
    private String estadoVaga;

}
