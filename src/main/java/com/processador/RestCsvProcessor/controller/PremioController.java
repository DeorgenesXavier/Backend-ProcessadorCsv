package com.processador.RestCsvProcessor.controller;

import com.processador.RestCsvProcessor.dto.PremioDto;
import com.processador.RestCsvProcessor.dto.PremioDtoResponse;
import com.processador.RestCsvProcessor.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PremioController {

    private FilmeService filmeService;

    @RequestMapping(value = "/premios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PremioDtoResponse listar() throws Exception {

        List<PremioDto> premios = filmeService.retornaRequisitos();

        return new PremioDtoResponse(premios.get(0),premios.get(1));
    }
}
