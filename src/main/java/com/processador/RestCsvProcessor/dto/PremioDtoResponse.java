package com.processador.RestCsvProcessor.dto;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class PremioDtoResponse implements Serializable {

    private static final long serialVersionUID = 2462075793771310983L;

    public PremioDto min;
    public PremioDto max;
}
