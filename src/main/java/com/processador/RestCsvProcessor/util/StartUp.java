package com.processador.RestCsvProcessor.util;

import com.processador.RestCsvProcessor.model.Filme;
import com.processador.RestCsvProcessor.service.FilmeService;
import com.processador.RestCsvProcessor.service.CsvService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.processador.RestCsvProcessor.util.ConstantsUtil.DIRETORIO;

@AllArgsConstructor
@Component
public class StartUp implements ApplicationListener<ContextRefreshedEvent> {

    private final CsvService csvService;
    private final FilmeService filmeService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        List<Filme> filmes = csvService.leArquivoCsv(DIRETORIO);

        filmeService.salvarTodos(filmes);
    }
}
