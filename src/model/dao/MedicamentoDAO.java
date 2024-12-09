package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Medicamento;

public class MedicamentoDAO implements InterfaceDAO<Medicamento> {

    @Override
    public void create(Medicamento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO medicamento (descricao_medicamento, principio_ativo, qtd_minima, status, codigo_barras) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricaoMedicamento());
            pstm.setString(2, objeto.getPrincipioAtivo());
            pstm.setFloat(3, objeto.getQtdMinima());
            pstm.setString(4, objeto.getStatus());
            pstm.setString(5, objeto.getCodigoBarras());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Medicamento> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Medicamento> listaMedicamentos = new ArrayList<>();

        String sqlInstrucao = "SELECT id, descricao_medicamento, principio_ativo, qtd_minima, status, codigo_barras FROM medicamento";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricao_medicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principio_ativo"));
                medicamento.setQtdMinima(resultado.getFloat("qtd_minima"));
                medicamento.setStatus(resultado.getString("status"));
                medicamento.setCodigoBarras(resultado.getString("codigo_barras"));
                listaMedicamentos.add(medicamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaMedicamentos;
    }

    @Override
    public Medicamento retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Medicamento medicamento = new Medicamento();

        String sqlInstrucao = "SELECT id, descricao_medicamento, principio_ativo, qtd_minima, status, codigo_barras FROM medicamento WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricao_medicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principio_ativo"));
                medicamento.setQtdMinima(resultado.getFloat("qtd_minima"));
                medicamento.setStatus(resultado.getString("status"));
                medicamento.setCodigoBarras(resultado.getString("codigo_barras"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return medicamento;
    }

    @Override
    public List<Medicamento> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Medicamento> listaMedicamentos = new ArrayList<>();

        String sqlInstrucao = "SELECT id, descricao_medicamento, principio_ativo, qtd_minima, status, codigo_barras FROM medicamento "
                + "WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricao_medicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principio_ativo"));
                medicamento.setQtdMinima(resultado.getFloat("qtd_minima"));
                medicamento.setStatus(resultado.getString("status"));
                medicamento.setCodigoBarras(resultado.getString("codigo_barras"));
                listaMedicamentos.add(medicamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaMedicamentos;
    }

    @Override
    public void update(Medicamento objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE medicamento SET descricao_medicamento = ?, principio_ativo = ?, qtd_minima = ?, "
                + "status = ?, codigo_barras = ? WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getDescricaoMedicamento());
            pstm.setString(2, objeto.getPrincipioAtivo());
            pstm.setFloat(3, objeto.getQtdMinima());
            pstm.setString(4, objeto.getStatus());
            pstm.setString(5, objeto.getCodigoBarras());
            pstm.setInt(6, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
