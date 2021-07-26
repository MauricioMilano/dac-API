package com.mauriciomilano.APIdac.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty(value = "sigla")
    private String sigla;
    @JsonProperty(value = "edicao")
    private int edicao;
    @JsonProperty(value = "cidade")
    private String cidade;
    @JsonProperty(value = "data")
    private String data;
    @JsonProperty(value = "descricao")
    private String descricao;
    @JsonProperty(value = "descricao_en")
    private String descricao_en;
    @JsonProperty(value = "artigos")
    @OneToMany
    private List<Artigo> artigos;

    protected Volume(){}

    public Volume(long id, String sigla, int edicao, String cidade, String data, String descricao, String descricao_en, List<Artigo> artigos) {
        this.id = id;
        this.sigla = sigla;
        this.edicao = edicao;
        this.cidade = cidade;
        this.data = data;
        this.descricao = descricao;
        this.descricao_en = descricao_en;
        this.artigos = artigos;
    }
}
