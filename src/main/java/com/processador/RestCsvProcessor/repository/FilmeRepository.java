package com.processador.RestCsvProcessor.repository;

import com.processador.RestCsvProcessor.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
