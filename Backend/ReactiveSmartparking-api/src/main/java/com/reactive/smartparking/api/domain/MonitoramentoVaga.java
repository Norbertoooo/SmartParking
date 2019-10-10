package com.reactive.smartparking.api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;

@Document
@EqualsAndHashCode @ToString @Getter @Setter
public class MonitoramentoVaga {

    @Id
    private String id;
    private String nomeSensor;
    private Float estadoVaga;

}
