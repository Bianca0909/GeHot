package model.dao;

import java.util.List;
import model.bo.Leito;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LeitoDAO implements InterfaceDAO<Leito>{

    @Override
    public void create(Leito objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO leito(descricao, status) VALUES(?, ?)";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.execute();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
        
    }

    @Override
    public List<Leito> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status FROM leito";
        List<Leito> leitos = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            
            while (resultado.next()) {
                Leito leito = new Leito();
                leito.setId(resultado.getInt("id"));
                leito.setDescricao(resultado.getString("descricao"));
                leito.setStatus(resultado.getString("status"));
                
                leitos.add(leito);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return leitos;
        }
        
        
    }

    @Override
    public Leito retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status FROM leito WHERE id = ?";
        Leito leito = new Leito();
        
        try { 
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            
            while (resultado.next()) {
                leito.setId(resultado.getInt("id"));
                leito.setDescricao(resultado.getString("descricao"));
                leito.setStatus(resultado.getString("status"));
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return leito;
        }
        
        
    }

    @Override
    public List<Leito> retrieve(String parametro, String atributo) {
        
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status FROM leito "
                            + "WHERE " + atributo + " LIKE ?";
        
        List<Leito> leitos = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            
            while (resultado.next()) {
                Leito leito = new Leito();
                leito.setId(resultado.getInt("id"));
                leito.setDescricao(resultado.getString("descricao"));
                leito.setStatus(resultado.getString("status"));
                
                leitos.add(leito);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return leitos;
        }
    }

    @Override
    public void update(Leito objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE leito SET "
                + "descricao = ?, "
                + "status = ?, "
                + "WHERE id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.setInt(4, objeto.getId());
            pstm.execute();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
        
    }
}
