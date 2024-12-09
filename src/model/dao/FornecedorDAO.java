package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO fornecedor (nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, "
                + "data_cadastro, cep, cidade, bairro, logradouro, complemento, nome_fantasia, contato) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(13, objeto.getNomeFantasia());
            pstm.setString(14, objeto.getContato());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, "
                + "cep, cidade, bairro, logradouro, complemento, nome_fantasia, contato FROM fornecedor";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setFone1(resultado.getString("fone_1"));
                fornecedor.setFone2(resultado.getString("fone_2"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setCpfCnpj(resultado.getString("cpf_cnpj"));
                fornecedor.setRgInscricaoEstadual(resultado.getString("rg_inscricao_estadual"));
                fornecedor.setDataCadastro(resultado.getString("data_cadastro"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setLogradouro(resultado.getString("logradouro"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setNomeFantasia(resultado.getString("nome_fantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaFornecedor;
    }

    @Override
    public Fornecedor retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        Fornecedor fornecedor = new Fornecedor();

        String sqlInstrucao = "SELECT id, nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, "
                + "cep, cidade, bairro, logradouro, complemento, nome_fantasia, contato FROM fornecedor WHERE id = ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            if (resultado.next()) {
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setFone1(resultado.getString("fone_1"));
                fornecedor.setFone2(resultado.getString("fone_2"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setCpfCnpj(resultado.getString("cpf_cnpj"));
                fornecedor.setRgInscricaoEstadual(resultado.getString("rg_inscricao_estadual"));
                fornecedor.setDataCadastro(resultado.getString("data_cadastro"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setLogradouro(resultado.getString("logradouro"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setNomeFantasia(resultado.getString("nome_fantasia"));
                fornecedor.setContato(resultado.getString("contato"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        String sqlInstrucao = "SELECT id, nome, fone_1, fone_2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, "
                + "cep, cidade, bairro, logradouro, complemento, nome_fantasia, contato FROM fornecedor "
                + "WHERE " + atributo + " LIKE ?";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setFone1(resultado.getString("fone_1"));
                fornecedor.setFone2(resultado.getString("fone_2"));
                fornecedor.setEmail(resultado.getString("email"));
                fornecedor.setCpfCnpj(resultado.getString("cpf_cnpj"));
                fornecedor.setRgInscricaoEstadual(resultado.getString("rg_inscricao_estadual"));
                fornecedor.setDataCadastro(resultado.getString("data_cadastro"));
                fornecedor.setCep(resultado.getString("cep"));
                fornecedor.setCidade(resultado.getString("cidade"));
                fornecedor.setBairro(resultado.getString("bairro"));
                fornecedor.setLogradouro(resultado.getString("logradouro"));
                fornecedor.setComplemento(resultado.getString("complemento"));
                fornecedor.setNomeFantasia(resultado.getString("nome_fantasia"));
                fornecedor.setContato(resultado.getString("contato"));
                listaFornecedor.add(fornecedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
        }
        return listaFornecedor;
    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE fornecedor SET nome = ?, fone_1 = ?, fone_2 = ?, email = ?, cpf_cnpj = ?, "
                + "rg_inscricao_estadual = ?, data_cadastro = ?, cep = ?, cidade = ?, bairro = ?, logradouro = ?, "
                + "complemento = ?, nome_fantasia = ?, contato = ? WHERE id = ?";

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
            pstm.setString(13, objeto.getNomeFantasia());
            pstm.setString(14, objeto.getContato());
            pstm.setInt(15, objeto.getId());
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }
}
