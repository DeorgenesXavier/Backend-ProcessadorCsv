package com.processador.RestCsvProcessor.util;

public enum FilmeEnum {
    YEAR(0),
    TITLE(1),
    STUDIOS(2),
    PRODUCERS(3),
    WINNER(4);

    public int numeroIndice;

    FilmeEnum(int numeroIndice){
        this.numeroIndice = numeroIndice;
    }

    public int getIndice(){
        return numeroIndice;
    }
}
