package com.reactive.smartparking.api.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

// TODO: 04/11/2019 Procurar anotação para impedir valores nulos

@Document
@Data
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
