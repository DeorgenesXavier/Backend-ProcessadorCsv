package com.processador.RestCsvProcessor.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PremioDto implements Serializable {

    private static final long serialVersionUID = 7851918800136853824L;

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;
}
