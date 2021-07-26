package com.mauriciomilano.APIdac.Models;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @JsonProperty(value = "email")

    private String email;
    @JsonProperty(value = "primeiro_nome")
    private String primeiro_nome;
    @JsonProperty(value = "nome_meio")
    private String nome_meio;
    @JsonProperty(value = "sobrenome")
    private String sobrenome;
    @JsonProperty(value = "afiliacao")
    private String afiliacao;
    @JsonProperty(value = "afiliacao_en")
    private String afiliacao_en;
    protected  Autor(){}


    public Autor(long id, String email, String primeiro_nome, String nome_meio, String sobrenome, String afiliacao, String afiliacao_en) {
        this.id = id;
        validaEmail(email);
        this.email = email;
        validaTamanhoString(primeiro_nome, "Primeiro nome", 64 );
        validaTamanhoString(nome_meio, "Nome do meio", 64 );
        validaTamanhoString(sobrenome, "Sobrenome", 64 );
        validaTamanhoString(afiliacao, "Afiliacao", 64 );
        validaTamanhoString(afiliacao_en, "Afiliacao em Inglês", 64 );
        this.primeiro_nome = primeiro_nome;
        this.nome_meio = nome_meio;
        this.sobrenome = sobrenome;
        this.afiliacao = afiliacao;
        this.afiliacao_en = afiliacao_en;
    }
    public void validaEmail(String email){
        if (!email.matches("(\\w|\\d)*[@](\\w|\\d)*[.](\\w|\\d)*")){
            throw new Error("Email no formato invalido");
        }
    }
    public void validaTamanhoString(String str, String tipo, Integer tamanho){
        if(str.length()>tamanho){
            throw new Error(tipo + " com tamanho inválido");
        }
    }
}
