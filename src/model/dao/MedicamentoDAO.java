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

        try {
            String sqlInstrucao = "Insert Into medicamento (descricaoMedicamento,"
                    + "principioAtivo,"
                    + "qtdMinima,"
                    + "status, "
                    + "codigoBarras"
                    + "Values(?,?,?,?,?) ";

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
        List<Medicamento> listaMedicamento = new ArrayList<>();

        String sqlInstrucao = " Select descricaoMedicamento,"
                + " principioAtivo,"
                + " quantidadeMinima,"
                + " status, "
                + "codigoBarras"
                + " From medicamento ";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principioAtivo"));
                medicamento.setQtdMinima(resultado.getFloat("quantidadeMinima"));
                medicamento.setStatus(resultado.getString("status"));
                medicamento.setCodigoBarras(resultado.getString(""));
                listaMedicamento.add(medicamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaMedicamento;
        }        
    }

    @Override
    public Medicamento retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Medicamento medicamento = new Medicamento();

        String sqlInstrucao = " Select descricaoMedicamento, principioAtivo, quantidadeMinima, status"
                + " From medicamento Where medicamento.id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principioAtivo"));
                medicamento.setQtdMinima(resultado.getFloat("quantidadeMinima"));
                medicamento.setStatus(resultado.getString("status"));
                medicamento.setCodigoBarras(resultado.getString("codigoBarras"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return medicamento;
        }
    }

     @Override
    public List<Medicamento> retrieve(String parametro, String atributo) {

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Medicamento> listaMedicamento = new ArrayList<>();

        String sqlInstrucao = " Select descricaoMedicamento, principioAtivo, quantidadeMinima, status, codigoBarras"
                + " From medicamento Where " + atributo + " like ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(resultado.getInt("id"));
                medicamento.setDescricaoMedicamento(resultado.getString("descricaoMedicamento"));
                medicamento.setPrincipioAtivo(resultado.getString("principioAtivo"));
                medicamento.setQtdMinima(resultado.getFloat("quantidadeMinima"));
                medicamento.setStatus(resultado.getString("status"));
                medicamento.setCodigoBarras(resultado.getString("codigoBarras"));
                listaMedicamento.add(medicamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return listaMedicamento;
        }
    }

     @Override
    public void update(Medicamento objeto) {

        Connection conexao = ConnectionFactory.getConnection();
        String sqlInstrucao = " Update medicamento "
                + " set "
                + " medicamento.descricaoMedicamento = ? , "
                + " medicamento.principioAtivo = ? , "
                + " medicamento.quantidadeMinima = ? , "
                + " medicamento.status = ?, "
                + "medicamento.codigoBarras = ? "
                + " Where medicamento.id = ?";
        
        PreparedStatement pstm = null;
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
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
