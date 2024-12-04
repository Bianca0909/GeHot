package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bo.Jornada;

public class JornadaDAO {

    public void create(Jornada objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        String sqlInstrucao = "INSERT INTO jornada(dataInicial, dataFinal, cargaHoraria, profissionalId) VALUES(?, ?, ?)";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setDate(1, Date.valueOf(objeto.getDataInicial()));
            pstm.setDate(2, Date.valueOf(objeto.getDataFinal()));
            pstm.setInt(3, objeto.getCargaHoraria());
            pstm.setInt(4, objeto.getProfissionalId());
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
    
    public void update(Jornada objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        String sqlInstrucao = "UPDATE jornada SET"
                + "dataInicial = ?, "
                + "dataFinal = ?, "
                + "cargaHoraria = ?, "
                + "profissionalId = ?"
                + "WHERE jornada.id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setDate(1, Date.valueOf(objeto.getDataInicial()));
            pstm.setInt(2, objeto.getCargaHoraria());
            pstm.setInt(3, objeto.getProfissionalId());
            pstm.execute();
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
    
    public void delete(Jornada objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        String sqlInstrucao = "DELETE hospital.jornada WHERE id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
