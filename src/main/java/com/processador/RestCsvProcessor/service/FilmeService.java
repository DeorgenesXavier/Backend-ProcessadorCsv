package com.processador.RestCsvProcessor.service;

import com.processador.RestCsvProcessor.dto.PremioDto;
import com.processador.RestCsvProcessor.dto.VencedorDto;
import com.processador.RestCsvProcessor.model.Filme;
import com.processador.RestCsvProcessor.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public void salvarTodos(List<Filme> filmes){
        filmeRepository.saveAll(filmes);
    }

    public List<PremioDto> retornaRequisitos(){
        List<Filme> filmes = filmeRepository.findAll();

        return calculaProdutor(filmes);
    }

    private List<PremioDto> calculaProdutor(List<Filme> filmes){

        VencedorDto antigo = new VencedorDto(0, "Ninguém"), atual;
        int maiorTempo = 0, menorTempo = 1000, tempo;
        String produtorMaiorTempo = "Ninguém", produtorMenorTempo = "Ninguém";
        PremioDto premioDtomax = new PremioDto();
        PremioDto premioDtomin = new PremioDto();

        List<VencedorDto> vencedores =
                obtemVencedores(filmes);

        List<VencedorDto> ordenados =
        vencedores.stream()
                .sorted((h1,h2) -> h1.getNome().replace(" ", "")
                        .compareTo(h2.getNome().replace(" ", "")))
                .collect(Collectors.toList());

        for(int i = 0; i < ordenados.size(); i++){

            atual = ordenados.get(i);

            if(atual.getNome().equals(antigo.getNome())){
                tempo = Math.abs(atual.getAno()-antigo.getAno());
                if(tempo > maiorTempo){
                    maiorTempo = tempo;
                    premioDtomax.setProducer(atual.getNome());
                    premioDtomax.setFollowingWin(atual.getAno());
                    premioDtomax.setPreviousWin(antigo.getAno());
                    premioDtomax.setInterval(tempo);
                }
                if(tempo < menorTempo){
                    menorTempo = tempo;
                    premioDtomin.setProducer(atual.getNome());
                    premioDtomin.setFollowingWin(atual.getAno());
                    premioDtomin.setPreviousWin(antigo.getAno());
                    premioDtomin.setInterval(tempo);
                }
            }

            antigo = atual;

        }

        return Arrays.asList(premioDtomin,premioDtomax);
    }

    private List<VencedorDto> obtemVencedores(List<Filme> filmes) {

        List<List<VencedorDto>> vencedores =
                filmes.stream()
                        .filter(filme -> filme.getIsWinner().equals("yes"))
                        .map(filme -> toVencedorDto(filme))
                        .collect(Collectors.toList());

        List<VencedorDto> venc
                = vencedores.stream().flatMap(List::stream).collect(Collectors.toList());

        return venc;
    }

    private List<VencedorDto> toVencedorDto(Filme filme){
        return filme.getProducers().stream()
                .map(p -> new VencedorDto(Integer.valueOf(filme.getYear()), p))
                .collect(Collectors.toList());
    }
}
