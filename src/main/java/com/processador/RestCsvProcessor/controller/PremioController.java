package com.processador.RestCsvProcessor.controller;

import com.processador.RestCsvProcessor.service.ProcessaCsv;
import com.processador.RestCsvProcessor.util.ConstantsUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.processador.RestCsvProcessor.util.ConstantsUtil.DIRETORIO;

@AllArgsConstructor
@RestController
public class PremioController {

    private ProcessaCsv processaCsv;

    @RequestMapping("/premios")
    public List<String> listar() throws IOException {
        return processaCsv.leArquivoCsv(DIRETORIO);
    }
}
