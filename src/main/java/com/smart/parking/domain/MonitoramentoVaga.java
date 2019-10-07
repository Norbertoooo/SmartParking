package com.smart.parking.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode @ToString @Getter @Setter
public class MonitoramentoVaga {

    @Id @GeneratedValue
    private Long id;
    private String nomeSensor;
    private Float estadoVaga;

}
