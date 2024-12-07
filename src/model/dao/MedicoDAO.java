package model.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bo.Medico;

public class MedicoDAO implements InterfaceDAO<Medico> {

    @Override
    public void create(Medico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO medico(nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, "
                + "cidade, bairro, logradouro, complemento, crm, senha, login, nomeSocial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(13, objeto.getCrm());
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
    public List<Medico> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;

        String sqlInstrucao = "SELECT id, nome, crm, dataCadastro, email, fone1 FROM hospital.medico";

        List<Medico> medicos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Medico medico = new Medico();
                medico.setId(resultado.getInt("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setCrm(resultado.getString("crm"));
                medico.setDataCadastro(resultado.getString("dataCadastro"));
                medico.setEmail(resultado.getString("email"));
                medico.setFone1(resultado.getString("fone1"));
                medicos.add(medico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return medicos;
        }

    }

    @Override
    public Medico retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, crm, dataCadastro, email, fone1 FROM hospital.medico WHERE id = ?";
        Medico medico = new Medico();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                medico.setId(resultado.getInt("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setFone1(resultado.getString("fone1"));
                medico.setFone2(resultado.getString("fone2"));
                medico.setEmail(resultado.getString("email"));
                medico.setCpfCnpj(resultado.getString("cpfCnpj"));
                medico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                medico.setDataCadastro(resultado.getString("dataCadastro"));
                medico.setCep(resultado.getString("cep"));
                medico.setCidade(resultado.getString("cidade"));
                medico.setBairro(resultado.getString("bairro"));
                medico.setLogradouro(resultado.getString("logradouro"));
                medico.setComplemento(resultado.getString("complemento"));
                medico.setCrm(resultado.getString("crm"));
                medico.setSenha(resultado.getString("senha"));
                medico.setLogin(resultado.getString("login"));
                medico.setNomeSocial(resultado.getString("nomeSocial"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return medico;
        }
    }

    @Override
    public List<Medico> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, crm, dataCadastro, email, fone1 FROM hospital.medico WHERE " + atributo + " LIKE ?";

        List<Medico> medicos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Medico medico = new Medico();
                medico.setId(resultado.getInt("id"));
                medico.setNome(resultado.getString("nome"));
                medico.setFone1(resultado.getString("fone1"));
                medico.setFone2(resultado.getString("fone2"));
                medico.setEmail(resultado.getString("email"));
                medico.setCpfCnpj(resultado.getString("cpfCnpj"));
                medico.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                medico.setDataCadastro(resultado.getString("dataCadastro"));
                medico.setCep(resultado.getString("cep"));
                medico.setCidade(resultado.getString("cidade"));
                medico.setBairro(resultado.getString("bairro"));
                medico.setLogradouro(resultado.getString("logradouro"));
                medico.setComplemento(resultado.getString("complemento"));
                medico.setCrm(resultado.getString("crm"));
                medico.setSenha(resultado.getString("senha"));
                medico.setLogin(resultado.getString("login"));
                medico.setNomeSocial(resultado.getString("nomeSocial"));

                medicos.add(medico);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return medicos;
        }
    }

    @Override
    public void update(Medico objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE medico SET "
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
                + "crm = ?, "
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
