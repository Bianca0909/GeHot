package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Farmaceutico;
import model.bo.Farmaceutico;
import model.bo.Farmaceutico;

public class FarmaceuticoDAO implements InterfaceDAO<Farmaceutico>{

    @Override
    public void create(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO farmaceutico(nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, "
                + "cidade, bairro, logradouro, complemento, crf, senha, login, nomeSocial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
            pstm.setString(13, objeto.getCrf());
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
    public List<Farmaceutico> retrieve() {
       Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;

        String sqlInstrucao = "SELECT id, nome, crf, dataCadastro, email, fone1 FROM hospital.farmaceutico";

        List<Farmaceutico> farmaceuticos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setNome(resultado.getString("nome"));
                farmaceutico.setCrf(resultado.getString("crf"));
                farmaceutico.setDataCadastro(resultado.getString("dataCadastro"));
                farmaceutico.setEmail(resultado.getString("email"));
                farmaceutico.setFone1(resultado.getString("fone1"));
                farmaceuticos.add(farmaceutico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return farmaceuticos;
        }

    }

    @Override
    public Farmaceutico retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, crf, dataCadastro, email, fone1 FROM hospital.farmaceutico WHERE id = ?";
        Farmaceutico farmaceutico = new Farmaceutico();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setNome(resultado.getString("nome"));
                farmaceutico.setFone1(resultado.getString("fone1"));
                farmaceutico.setFone2(resultado.getString("fone2"));
                farmaceutico.setEmail(resultado.getString("email"));
                farmaceutico.setCpfCnpj(resultado.getString("cpfCnpj"));
                farmaceutico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                farmaceutico.setDataCadastro(resultado.getString("dataCadastro"));
                farmaceutico.setCep(resultado.getString("cep"));
                farmaceutico.setCidade(resultado.getString("cidade"));
                farmaceutico.setBairro(resultado.getString("bairro"));
                farmaceutico.setLogradouro(resultado.getString("logradouro"));
                farmaceutico.setComplemento(resultado.getString("complemento"));
                farmaceutico.setCrf(resultado.getString("crm"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return farmaceutico;
        }
    }

    @Override
    public List<Farmaceutico> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, crf, dataCadastro, email, fone1 FROM hospital.medico WHERE " + atributo + " LIKE ?";

        List<Farmaceutico> farmaceuticos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Farmaceutico farmaceutico = new Farmaceutico();
                farmaceutico.setId(resultado.getInt("id"));
                farmaceutico.setNome(resultado.getString("nome"));
                farmaceutico.setFone1(resultado.getString("fone1"));
                farmaceutico.setFone2(resultado.getString("fone2"));
                farmaceutico.setEmail(resultado.getString("email"));
                farmaceutico.setCpfCnpj(resultado.getString("cpfCnpj"));
                farmaceutico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                farmaceutico.setDataCadastro(resultado.getString("dataCadastro"));
                farmaceutico.setCep(resultado.getString("cep"));
                farmaceutico.setCidade(resultado.getString("cidade"));
                farmaceutico.setBairro(resultado.getString("bairro"));
                farmaceutico.setLogradouro(resultado.getString("logradouro"));
                farmaceutico.setComplemento(resultado.getString("complemento"));
                farmaceutico.setCrf(resultado.getString("crm"));
                farmaceutico.setSenha(resultado.getString("senha"));
                farmaceutico.setLogin(resultado.getString("login"));
                farmaceutico.setNomeSocial(resultado.getString("nomeSocial"));

                farmaceuticos.add(farmaceutico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return farmaceuticos;
        }
    }

    @Override
    public void update(Farmaceutico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE farmaceutico SET "
                + "nome = ?, "
                + "fone1 = ?, "
                + "fone2 = ?, "
                + "email = ?, "
                + "cpfCnpj = ?, "
                + "rgInscricaoEstadual = ?, "
                + "dataCadastro = ?, "
                + "cep = ?, "
                + "cidade = ?, "
                + "bairro = ?, "
                + "logradouro = ?, "
                + "complemento = ?, "
                + "crf = ?, "
                + "senha = ?, "
                + "login = ?, "
                + "nomeSocial = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
