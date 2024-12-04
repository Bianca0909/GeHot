package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Acompanhante;

public class AcompanhanteDAO implements InterfaceDAO<Acompanhante> {

    @Override
    public void create(Acompanhante objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO acompanhante(nome, grau_parentesco, cpf, fone, email, status) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getGrauParentesco());
            pstm.setString(3, objeto.getCpf());
            pstm.setString(4, objeto.getFone());
            pstm.setString(5, objeto.getEmail());
            pstm.setString(6, objeto.getStatus());
            pstm.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Acompanhante> retrieve() {
         Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, grau_parentesco, cpf, fone, email, status FROM hospital.acompanhante";
        
        List<Acompanhante> acompanhantes = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            
            while(resultado.next()) {
                Acompanhante acompanhante = new Acompanhante();
                acompanhante.setId(resultado.getInt("id"));
                acompanhante.setNome(resultado.getString("nome"));
                acompanhante.setGrauParentesco(resultado.getString("grau_parentesco"));
                acompanhante.setCpf(resultado.getString("cpf"));
                acompanhante.setFone(resultado.getString("fone"));
                acompanhante.setEmail(resultado.getString("email"));
                acompanhante.setStatus(resultado.getString("status"));
                
                acompanhantes.add(acompanhante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return acompanhantes;
        }
    }

    @Override
    public Acompanhante retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, grau_parentesco, cpf, fone, email, status FROM hospital.acompanhante WHERE id = ?";
        Acompanhante acompanhante = new Acompanhante();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            
            while(resultado.next()) {
                acompanhante.setId(resultado.getInt("id"));
                acompanhante.setNome(resultado.getString("nome"));
                acompanhante.setGrauParentesco(resultado.getString("grau_parentesco"));
                acompanhante.setCpf(resultado.getString("cpf"));
                acompanhante.setFone(resultado.getString("fone"));
                acompanhante.setEmail(resultado.getString("email"));
                acompanhante.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return acompanhante;
        }
    }

    @Override
    public List<Acompanhante> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, grau_parentesco, cpf, fone, email, status FROM hospital.acompanhante WHERE " + atributo + " LIKE ?";
        
        List<Acompanhante> acompanhantes = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
             pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            
            while(resultado.next()) {
                Acompanhante acompanhante = new Acompanhante();
                acompanhante.setId(resultado.getInt("id"));
                acompanhante.setNome(resultado.getString("nome"));
                acompanhante.setGrauParentesco(resultado.getString("grau_parentesco"));
                acompanhante.setCpf(resultado.getString("cpf"));
                acompanhante.setFone(resultado.getString("fone"));
                acompanhante.setEmail(resultado.getString("email"));
                acompanhante.setStatus(resultado.getString("status"));
                
                acompanhantes.add(acompanhante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return acompanhantes;
        }
    }

    @Override
    public void update(Acompanhante objeto) {
         Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE acompanhante SET "
                + "acompanhante.nome = ?, "
                + "acompanhante.grau_parentesco = ?, "
                + "acompanhante.cpf = ?, "
                + "acompanhante.fone = ?, "
                + "acompanhante.email = ?, "
                + "acompanhante.status = ?, "
                + " WHERE acompanhante.id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getGrauParentesco());
            pstm.setString(3, objeto.getCpf());
            pstm.setString(4, objeto.getFone());
            pstm.setString(5, objeto.getEmail());
            pstm.setString(6, objeto.getStatus());
            pstm.setInt(7, objeto.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
