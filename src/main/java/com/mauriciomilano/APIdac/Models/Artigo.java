package com.mauriciomilano.APIdac.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mauriciomilano.APIdac.Enums.Idioma;

import javax.persistence.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Entity
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty(value = "idioma")
    private String idioma;

    @JsonProperty(value = "titulo")
    private String titulo;

    @JsonProperty(value = "titulo_en")
    private String titulo_en;

    @JsonProperty(value = "resumo")
    private String resumo;
    @JsonProperty(value = "resumo_en")
    private String resumo_en;
    @JsonProperty(value = "palavras_chave")
    private String palavras_chave;
    @JsonProperty(value = "palavras_chave_en")
    private String palavras_chave_en;
    @JsonProperty(value = "num_paginas")
    private int num_paginas;
    @JsonProperty(value = "autores")
    @OneToMany
    private List<Autor> autores;
    @ManyToOne
    private Volume volume;
    protected Artigo(){}

    public Artigo(long id, String idioma, String titulo, String titulo_en, String resumo, String resumo_en, String palavras_chave, String palavras_chave_en, int num_paginas, List<Autor> autores) {
        this.id = id;
        this.idioma = idioma;
        this.titulo = titulo;
        validaIdioma(idioma);
        validaTamanhoString(titulo,"Titulo", 256);
        validaTamanhoString(titulo_en,"Titulo", 256);
        validaTamanhoString(resumo,"Resumo", 256);
        validaTamanhoString(resumo_en,"Resumo em ingles", 256);
        validaTamanhoString(palavras_chave,"Palavras chave", 256);
        validaTamanhoString(palavras_chave_en,"Palavras chave em ingles", 256);
        this.titulo_en = titulo_en;
        this.resumo = resumo;
        this.resumo_en = resumo_en;
        this.palavras_chave = palavras_chave;
        this.palavras_chave_en = palavras_chave_en;
        this.num_paginas = num_paginas;
        this.autores = autores;
    }

    public void validaTamanhoString(String str, String tipo, Integer tamanho){
        if(str.length()>tamanho){
            throw new Error(tipo + " com tamanho inválido");
        }
    }
    public void validaIdioma(String idioma){
        String[] idiomas = new String[]{Idioma.ingles, Idioma.espanhol, Idioma.portugues};
        List<String> list = Arrays.asList(idiomas);
        if(!list.contains(idioma.toLowerCase())){
            throw new Error("Idioma inválido");
        }
    }

}
