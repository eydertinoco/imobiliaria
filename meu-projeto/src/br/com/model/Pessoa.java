package br.com.model;

import java.util.Date;

public class Pessoa {
    private Integer id;
    private String nome;
    private Date nascimento;
    private Double altura;
    private Double peso;
    private String CPF;
    private String RG;
    private String sexo;

    public Pessoa(){

    }

    public Pessoa(Integer id, String nome, Date nascimento, Double altura, Double peso, String CPF, String RG, String sexo) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.altura = altura;
        this.peso = peso;
        this.CPF = CPF;
        this.RG = RG;
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
