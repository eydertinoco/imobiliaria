package br.com.DAO;

import br.com.model.Pessoa;
import br.com.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public List<Pessoa> consultarPessoas() {
        List<Pessoa> listaPessoas = new ArrayList<>();

        String sql = "select pessoas.id, " +
                "       pessoas.nome, " +
                "       pessoas.nascimento, " +
                "       pessoas.altura, " +
                "       pessoas.peso, " +
                "       pessoas.CPF, " +
                "       pessoas.RG, " +
                "       pessoas.sexo " +
                "   from pessoas order by id ";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa c = new Pessoa();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setNascimento(rs.getDate("nascimento"));
                c.setAltura(rs.getDouble("altura"));
                c.setPeso(rs.getDouble("peso"));
                c.setCPF(rs.getString("cpf"));
                c.setRG(rs.getString("rg"));
                c.setSexo(rs.getString("sexo"));
                listaPessoas.add(c);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.commit();
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return listaPessoas;
    }

    public void cadastrar(Pessoa pessoa) {
        String sql = "INSERT INTO public.pessoas " +
                "(nome, nascimento, altura, peso, cpf, rg, sexo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) ";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            //ps.setString(1, pessoa.getId());
            ps.setString(1, pessoa.getNome());
            ps.setDate(2, new java.sql.Date(pessoa.getNascimento().getTime()));
            if (pessoa.getAltura() != null) {
                ps.setDouble(3, pessoa.getAltura());
            }else {
                ps.setNull(3, Types.DOUBLE);
            }
            if (pessoa.getPeso() != null) {
                ps.setDouble(4, pessoa.getPeso());
            }else {
                ps.setNull(4, Types.DOUBLE);
            }
            ps.setString(5, pessoa.getCPF());
            ps.setString(6, pessoa.getRG());
            ps.setString(7, pessoa.getSexo());
            ps.execute();
            conexao.commit();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void editar(Pessoa pessoa) {
        String sql = "UPDATE public.pessoas " +
                " SET nome=?, nascimento=?, altura=?, peso=?, cpf=?, rg=?, sexo=? " +
                " WHERE id=?; ";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.setDate(2, new java.sql.Date(pessoa.getNascimento().getTime()));

            if (pessoa.getAltura() != null) { ps.setDouble(3, pessoa.getAltura()); }
            else { ps.setNull(3, Types.DOUBLE); }

            if (pessoa.getPeso() != null) { ps.setDouble(4, pessoa.getPeso()); }
            else { ps.setNull(4, Types.DOUBLE); }

            ps.setString(5, pessoa.getCPF());
            ps.setString(6, pessoa.getRG());
            ps.setString(7, pessoa.getSexo());
            ps.setInt(8, pessoa.getId());
            ps.executeUpdate();
            conexao.commit();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void deletar(Integer id) {
        String sql = "DELETE FROM public.pessoas WHERE id=?";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            conexao.commit();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }




}
