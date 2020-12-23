package com.processador.RestCsvProcessor.service;

import com.processador.RestCsvProcessor.util.ConstantsUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static com.processador.RestCsvProcessor.util.ConstantsUtil.DIRETORIO;

@Service
public class ProcessaCsv {

    public List<String> leArquivoCsv(String diretorio) throws IOException {

        Path path = Paths.get(diretorio);

        List<String> files = Files.readAllLines(path);

        return files;
    }
}
