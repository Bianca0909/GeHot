package model.dao;

import java.util.List;
import model.bo.Quarto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class QuartoDAO implements InterfaceDAO<Quarto>{

    @Override
    public void create(Quarto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO quarto(descricao, status, ala_id) VALUES(?, ?, ?)";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, objeto.getStatus());
            pstm.setInt(3, objeto.getAla_id());
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Quarto> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status FROM quarto";
        List<Quarto> quartos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(resultado.getInt("id"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setStatus(resultado.getString("status"));

                quartos.add(quarto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return quartos;
        }
    }

    @Override
    public Quarto retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status FROM quarto WHERE id = ?";
        Quarto quarto = new Quarto();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                quarto.setId(resultado.getInt("id"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setStatus(resultado.getString("status"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return quarto;
        }
    }

    @Override
    public List<Quarto> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, descricao, status FROM quarto  "
                            + " WHERE " + atributo + " LIKE ?";

        List<Quarto> quartos = new ArrayList<>();

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();

            while (resultado.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(resultado.getInt("id"));
                quarto.setDescricao(resultado.getString("descricao"));
                quarto.setStatus(resultado.getString("status"));

                quartos.add(quarto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return quartos;
        }
    }

    @Override
    public void update(Quarto objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE quarto SET "
                            + "descricao = ?, "
                            + "status = ?, "
                            + "WHERE id = ?";

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
