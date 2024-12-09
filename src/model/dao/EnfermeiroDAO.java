package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Enfermeiro;

public class EnfermeiroDAO implements InterfaceDAO<Enfermeiro> {

    @Override
    public void create(Enfermeiro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO enfermeiro (nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, "
                + "data_cadastro, cep, cidade, bairro, logradouro, complemento, cre, senha, login, nome_social) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getCpfCnpj());
            pstm.setString(6, objeto.getRgInscricaoEstadual());
            pstm.setString(7, objeto.getDataCadastro());
            pstm.setString(8, objeto.getCep());
            pstm.setString(9, objeto.getCidade());
            pstm.setString(10, objeto.getBairro());
            pstm.setString(11, objeto.getLogradouro());
            pstm.setString(12, objeto.getComplemento());
            pstm.setString(13, objeto.getCre());
            pstm.setString(14, objeto.getSenha());
            pstm.setString(15, objeto.getLogin());
            pstm.setString(16, objeto.getNomeSocial());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Enfermeiro> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Enfermeiro> listaEnfermeiro = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, "
                + "cep, cidade, bairro, logradouro, complemento, cre, senha, login, nome_social FROM enfermeiro";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setId(resultado.getInt("id"));
                enfermeiro.setNome(resultado.getString("nome"));
                enfermeiro.setFone1(resultado.getString("fone_1"));
                enfermeiro.setFone2(resultado.getString("fone_2"));
                enfermeiro.setEmail(resultado.getString("email"));
                enfermeiro.setCpfCnpj(resultado.getString("cpf_cnpj"));
                enfermeiro.setRgInscricaoEstadual(resultado.getString("rg_inscricao_estadual"));
                enfermeiro.setDataCadastro(resultado.getString("data_cadastro"));
                enfermeiro.setCep(resultado.getString("cep"));
                enfermeiro.setCidade(resultado.getString("cidade"));
                enfermeiro.setBairro(resultado.getString("bairro"));
                enfermeiro.setLogradouro(resultado.getString("logradouro"));
                enfermeiro.setComplemento(resultado.getString("complemento"));
                enfermeiro.setCre(resultado.getString("cre"));
                enfermeiro.setSenha(resultado.getString("senha"));
                enfermeiro.setLogin(resultado.getString("login"));
                enfermeiro.setNomeSocial(resultado.getString("nome_social"));
                listaEnfermeiro.add(enfermeiro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaEnfermeiro;
    }

    @Override
    public Enfermeiro retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Enfermeiro enfermeiro = new Enfermeiro();

        String sqlInstrucao = "SELECT id, nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, "
                + "cep, cidade, bairro, logradouro, complemento, cre, senha, login, nome_social FROM enfermeiro WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                enfermeiro.setId(resultado.getInt("id"));
                enfermeiro.setNome(resultado.getString("nome"));
                enfermeiro.setFone1(resultado.getString("fone_1"));
                enfermeiro.setFone2(resultado.getString("fone_2"));
                enfermeiro.setEmail(resultado.getString("email"));
                enfermeiro.setCpfCnpj(resultado.getString("cpf_cnpj"));
                enfermeiro.setRgInscricaoEstadual(resultado.getString("rg_inscricao_estadual"));
                enfermeiro.setDataCadastro(resultado.getString("data_cadastro"));
                enfermeiro.setCep(resultado.getString("cep"));
                enfermeiro.setCidade(resultado.getString("cidade"));
                enfermeiro.setBairro(resultado.getString("bairro"));
                enfermeiro.setLogradouro(resultado.getString("logradouro"));
                enfermeiro.setComplemento(resultado.getString("complemento"));
                enfermeiro.setCre(resultado.getString("cre"));
                enfermeiro.setSenha(resultado.getString("senha"));
                enfermeiro.setLogin(resultado.getString("login"));
                enfermeiro.setNomeSocial(resultado.getString("nome_social"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return enfermeiro;
    }

    @Override
    public List<Enfermeiro> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Enfermeiro> listaEnfermeiro = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, "
                + "cep, cidade, bairro, logradouro, complemento, cre, senha, login, nome_social FROM enfermeiro "
                + "WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Enfermeiro enfermeiro = new Enfermeiro();
                enfermeiro.setId(resultado.getInt("id"));
                enfermeiro.setNome(resultado.getString("nome"));
                enfermeiro.setFone1(resultado.getString("fone_1"));
                enfermeiro.setFone2(resultado.getString("fone_2"));
                enfermeiro.setEmail(resultado.getString("email"));
                enfermeiro.setCpfCnpj(resultado.getString("cpf_cnpj"));
                enfermeiro.setRgInscricaoEstadual(resultado.getString("rg_inscricao_estadual"));
                enfermeiro.setDataCadastro(resultado.getString("data_cadastro"));
                enfermeiro.setCep(resultado.getString("cep"));
                enfermeiro.setCidade(resultado.getString("cidade"));
                enfermeiro.setBairro(resultado.getString("bairro"));
                enfermeiro.setLogradouro(resultado.getString("logradouro"));
                enfermeiro.setComplemento(resultado.getString("complemento"));
                enfermeiro.setCre(resultado.getString("cre"));
                enfermeiro.setSenha(resultado.getString("senha"));
                enfermeiro.setLogin(resultado.getString("login"));
                enfermeiro.setNomeSocial(resultado.getString("nome_social"));
                listaEnfermeiro.add(enfermeiro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaEnfermeiro;
    }

    @Override
    public void update(Enfermeiro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE enfermeiro SET nome = ?, fone_1 = ?, fone_2 = ?, email = ?, cpf_cnpj = ?, "
                + "rg_inscricao_estadual = ?, data_cadastro = ?, cep = ?, cidade = ?, bairro = ?, logradouro = ?, "
                + "complemento = ?, cre = ?, senha = ?, login = ?, nome_social = ? WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getCpfCnpj());
            pstm.setString(6, objeto.getRgInscricaoEstadual());
            pstm.setString(7, objeto.getDataCadastro());
            pstm.setString(8, objeto.getCep());
            pstm.setString(9, objeto.getCidade());
            pstm.setString(10, objeto.getBairro());
            pstm.setString(11, objeto.getLogradouro());
            pstm.setString(12, objeto.getComplemento());
            pstm.setString(13, objeto.getCre());
            pstm.setString(14, objeto.getSenha());
            pstm.setString(15, objeto.getLogin());
            pstm.setString(16, objeto.getNomeSocial());
            pstm.setInt(17, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
