package com.processador.RestCsvProcessor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
@NoArgsConstructor
@Setter
@Getter
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String year;

    @Column
    private String title;

    @ElementCollection
    @Column
    private List<String> studios = new ArrayList<String>();

    @ElementCollection
    @Column
    private List<String> producers = new ArrayList<String>();

    @Column
    private String isWinner;
}
