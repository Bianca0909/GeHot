package model.dao;

import java.util.List;
import model.bo.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LaboratorioDAO implements InterfaceDAO<Laboratorio> {

    @Override
    public void create(Laboratorio objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO laboratorio(nomeFantasia, contato, status) values(?, ?, ?)";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.setString(3, objeto.getStatus());
            pstm.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Laboratorio> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nomeFantasia, contato, status FROM hospital.laboratorio";
        
        List<Laboratorio> laboratorios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            
            while(resultado.next()) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setId(resultado.getInt("id"));
                laboratorio.setNomeFantasia(resultado.getString("nomeFantasia"));
                laboratorio.setContato(resultado.getString("contato"));
                laboratorio.setStatus(resultado.getString("status"));
                
                laboratorios.add(laboratorio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return laboratorios;
        }
    }
    
    @Override
    public Laboratorio retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nomeFantasia, contato, status FROM hospital.laboratorio WHERE id = ?";
        Laboratorio laboratorio = new Laboratorio();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            
            while(resultado.next()) {
                laboratorio.setId(resultado.getInt("id"));
                laboratorio.setNomeFantasia(resultado.getString("nomeFantasia"));
                laboratorio.setContato(resultado.getString("contato"));
                laboratorio.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return laboratorio;
        }
    }

    @Override
    public List<Laboratorio> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nomeFantasia, contato, status FROM hospital.laboratorio WHERE " + atributo + " LIKE ?";
        
        List<Laboratorio> laboratorios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
             pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            
            while(resultado.next()) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setId(resultado.getInt("id"));
                laboratorio.setNomeFantasia(resultado.getString("nomeFantasia"));
                laboratorio.setContato(resultado.getString("contato"));
                laboratorio.setStatus(resultado.getString("status"));
                
                laboratorios.add(laboratorio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return laboratorios;
        }
    }

    @Override
    public void update(Laboratorio objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE laboratorio SET "
                + "laboratorio.nomeFantasia = ?, "
                + "laboratorio.contato = ?,"
                + " laboratorio.status = ?"
                + " WHERE laboratorio.id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getNomeFantasia());
            pstm.setString(2, objeto.getContato());
            pstm.setString(3, objeto.getStatus());
            pstm.setInt(4, objeto.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
