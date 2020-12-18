package br.com.controller;

import br.com.service.CalculadoraService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Scanner;

@ViewScoped
@ManagedBean(name = "testeControleMB")

public class TesteController {
    private CalculadoraService calculadora;
    private Double resultado;
    private Double numero1;
    private Double numero2;
    private Integer operacao;

    public TesteController() {
        this.calculadora = new CalculadoraService();
        this.resultado = 0.0;
    }

    public void calcular() {
        FacesContext context = FacesContext.getCurrentInstance();
        switch(operacao){
            case 1:
                this.resultado = calculadora.somar(numero1, numero2);
                break;
            case 2:
                this.resultado = calculadora.subtrair(numero1, numero2);
                break;
            case 3:
                this.resultado = calculadora.multiplicacao(numero1, numero2);
                break;
            case 4:
                this.resultado = calculadora.divisao(numero1, numero2);
                break;
            default:
                context.addMessage(null, new FacesMessage("Error: Complete todos os dados.", ""));
                break;
        }
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public Integer getOperacao() {
        return operacao;
    }

    public void setOperacao(Integer operacao) {
        this.operacao = operacao;
    }




}
