package br.com.controller;

import br.com.model.Pessoa;
import br.com.model.Usuario;
import br.com.service.PessoaService;
import br.com.util.JSFUtil;
import br.com.util.SessionUtil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static br.com.util.JSFUtil.atualizarComponente;
import static br.com.util.JSFUtil.fecharDialog;
import static br.com.util.StringUtil.retirarMascara;

@ViewScoped
@ManagedBean(name = "pessoaMB")
public class PessoaController {
    private Pessoa pessoaCadastro;
    private Pessoa pessoaEditar;
    private PessoaService pessoaService;
    private List<Pessoa> listaPessoas;

    public PessoaController() {
        this.pessoaService = new PessoaService();
        this.listaPessoas = this.pessoaService.retornarListaPessoas();
        this.pessoaCadastro = new Pessoa();
        this.pessoaEditar = new Pessoa();
    }

    public void abrirDialogCadastroPessoa() {
        this.pessoaCadastro = new Pessoa();
        JSFUtil.abrirDialog("dlg2");
    }

    public void salvarCadastro() {
        String cpf = this.pessoaCadastro.getCPF().replaceAll("\\.", "").replaceAll("-", "");
        this.pessoaCadastro.setCPF(cpf);
        this.pessoaCadastro.setRG(this.pessoaCadastro.getRG().replaceAll("-", ""));
        this.pessoaService.cadastrarPessoa(this.pessoaCadastro);
        this.listaPessoas = this.pessoaService.retornarListaPessoas();
        JSFUtil.fecharDialog("dlg2");
        //JSFUtil.atualizarComponente("form");
    }

    public void abrirDialogEditarPessoa(Pessoa pessoa) {
        this.pessoaEditar = new Pessoa(pessoa.getId(), pessoa.getNome(), pessoa.getNascimento(),
                pessoa.getAltura(), pessoa.getPeso(), pessoa.getCPF(), pessoa.getRG(),
                pessoa.getSexo());
        System.out.println("Abrir informações no 'dlgEdit' ao abrir o Dialog.");
        JSFUtil.abrirDialog("dlgEdit");
    }

    public void abrirDialogPessoa(Pessoa pessoa){
        (pessoa.getId() == null) ? "Cadastro" : "Editar");
        JSFUtil.abrirDialog("dlgPessoa");
    }

    public void salvarEdicao() {
        this.pessoaEditar.setCPF(this.pessoaEditar.getCPF().replaceAll("\\.", "")
                .replaceAll("-", ""));
        this.pessoaEditar.setRG(this.pessoaEditar.getRG().replaceAll("-", ""));
        this.pessoaService.editar(this.pessoaEditar);
        this.listaPessoas = this.pessoaService.retornarListaPessoas();
        JSFUtil.fecharDialog("dlgEdit");
    }

    //  Função do Botão Cancelar das abas de Cadastro e Editar.
    public void cancelar() {
        JSFUtil.fecharDialog("dlg2");
        JSFUtil.fecharDialog("dlgEdit");
    }

    //  Deletar informações do Banco de Dados.
    public void deletar(Pessoa pessoa){
        this.pessoaService.deletar(pessoa.getId());
        this.listaPessoas = this.pessoaService.retornarListaPessoas();
    }

    //=======================================================================
    //  Getter and Setter
    //=======================================================================

    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setListaPessoas(List<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public Pessoa getPessoaCadastro() {
        return pessoaCadastro;
    }

    public void setPessoaCadastro(Pessoa pessoaCadastro) {
        this.pessoaCadastro = pessoaCadastro;
    }

    public Pessoa getPessoaEditar() {
        return pessoaEditar;
    }

    public void setPessoaEditar(Pessoa pessoaEditar) {
        this.pessoaEditar = pessoaEditar;
    }
}
