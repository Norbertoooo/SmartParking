package com.reactive.smartparking.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document @Data @NoArgsConstructor @AllArgsConstructor
public class MonitoramentoVaga {

    @Id
    private String id;
    @NotNull(message = "not be null")
    private String nomeSensor;
    @NotNull(message = "not be null")
    private String estadoVaga;
    @NotNull(message = "not be null")
    private Date dataInclusao = new Date();

}
