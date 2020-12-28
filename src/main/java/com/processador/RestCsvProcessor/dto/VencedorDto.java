package com.processador.RestCsvProcessor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VencedorDto implements Serializable {

    private static final long serialVersionUID = 1586904480157493430L;

    private int ano;
    private String nome;
}
