package br.com.service;

import br.com.DAO.PessoaDAO;
import br.com.model.Pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PessoaService {

    private PessoaDAO pessoaDAO;

    public PessoaService() {
        this.pessoaDAO = new PessoaDAO();
    }

    public List<Pessoa> retornarListaPessoas() {
        return this.pessoaDAO.consultarPessoas();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoaDAO.cadastrar(pessoa);
    }

    public void editar(Pessoa pessoa){
        pessoaDAO.editar(pessoa);
    }

    public void deletar(Integer id){
        pessoaDAO.deletar(id);
    }


}
