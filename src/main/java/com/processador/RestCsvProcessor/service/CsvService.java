package com.processador.RestCsvProcessor.service;

import com.processador.RestCsvProcessor.model.Filme;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.processador.RestCsvProcessor.util.FilmeEnum.*;

@AllArgsConstructor
@Service
public class CsvService {

    public List<Filme> leArquivoCsv(String diretorio) throws Exception {
         return leLinhas(new Scanner(new File(diretorio)));
    }

    private List<Filme> leLinhas(Scanner scanner) {
        List<String> linhas = new ArrayList<String>();

        scanner.useDelimiter("\r\n").forEachRemaining(linhas::add);

        return leColunas(linhas);
    }

    private List<Filme> leColunas(List<String> linhas) {
        List<String[]> colunas = linhas.stream()
                .map(linha -> linha.split(";"))
                .collect(Collectors.toList());

        return colunas.stream()
                      .filter(coluna -> coluna.length > 4)
                      .map(coluna -> toFilme(coluna))
                      .collect(Collectors.toList());
    }

    private Filme toFilme(String[] coluna) {
        Filme filme = new Filme();
        filme.setYear(coluna[YEAR.getIndice()]);
        filme.setTitle(coluna[TITLE.getIndice()]);
        filme.setStudios(toStringsStudio(coluna[STUDIOS.getIndice()]));
        filme.setProducers(toStringsProducers(coluna[PRODUCERS.getIndice()]));
        filme.setIsWinner(coluna[WINNER.getIndice()].replace(",",""));
        return filme;
    }

    private List<String> toStringsProducers(String string) {
        return Arrays.asList(string.replace("and ",", ").split(", "));
    }

    private List<String> toStringsStudio(String string) {
        return Arrays.asList(string.split(","));
    }
}
/*
aulas.sort(Comparator.comparing(Aula::getTempo));

palavras.forEach(System.out::println);COPIA
         */