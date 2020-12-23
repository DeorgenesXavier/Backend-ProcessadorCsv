package com.processador.RestCsvProcessor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/pages")
    public String pages() {
        return "Hello World";
    }
}
