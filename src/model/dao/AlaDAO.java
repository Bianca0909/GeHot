package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Ala;

public class AlaDAO implements InterfaceDAO<Ala> {

    @Override
    public void create(Ala objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO ala (descricao, status) VALUES(?,?) ";
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Ala> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Ala> listaAla = new ArrayList<>();

        String sqlInstrucao = " SELECT id, descricao,"
                + " status"
                + " FROM ala ";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Ala ala = new Ala();
                ala.setId(resultado.getInt("id"));
                ala.setDescricao(resultado.getString("descricao"));
                ala.setStatus(resultado.getString("status"));
             
                listaAla.add(ala);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }    
        return listaAla;
    }

    @Override
    public Ala retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Ala ala = new Ala();

        String sqlInstrucao = " Select id, descricao, status"
                + " from ala where ala.id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                ala.setId(resultado.getInt("id"));
                ala.setDescricao(resultado.getString("descricao"));
                ala.setStatus(resultado.getString("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return ala;
        }
    }

    @Override
    public List<Ala> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Ala> listaAla = new ArrayList<>();

        String sqlInstrucao = "Select id, descricao, status"
                + " from ala Where " + atributo + " like ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Ala ala = new Ala();
                ala.setId(resultado.getInt("id"));
                ala.setDescricao(resultado.getString("descricao"));
                ala.setStatus(resultado.getString("status"));
                listaAla.add(ala);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaAla;
        }
    }

    @Override
    public void update(Ala objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE ala SET "
                + "ala.descricao = ?, "
                + "ala.status = ?, "
                + " WHERE acompanhante.id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.setInt(3, objeto.getId());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    } 
}
