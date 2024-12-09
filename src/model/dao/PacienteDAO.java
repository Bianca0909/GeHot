package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bo.Paciente;

public class PacienteDAO implements InterfaceDAO<Paciente> {

    @Override
    public void create(Paciente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO paciente(nome, fone1, fone2, email, cpf_cnpj, rg_inscricao_estadual, data_cadastro, cep, cidade, bairro, "
                + "logradouro, complemento, tipo_sanguineo, sexo, nome_social) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        
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
            pstm.setString(13, objeto.getTipoSanguineo());
            pstm.setString(14, objeto.getSexo());
            pstm.setString(15, objeto.getNomeSocial());
            
            pstm.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
            
    }


    @Override
    public List<Paciente> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
         String sqlInstrucao = "SELECT id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, "
                + "logradouro, complemento, tipoSanguineo, sexo, nomeSocial FROM paciente";
         List<Paciente> pacientes = new ArrayList<>();

        
                
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            
            while (resultado.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getInt("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setFone1(resultado.getString("fone1"));
                paciente.setFone2(resultado.getString("fone2"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setCpfCnpj(resultado.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                paciente.setDataCadastro(resultado.getString("dataCadastro"));
                paciente.setCep(resultado.getString("cep"));
                paciente.setCidade(resultado.getString("cidade"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setComplemento(resultado.getString("complemento"));
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                
                pacientes.add(paciente);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return pacientes;
        }

    }

    @Override
    public Paciente retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, "
                + "logradouro, complemento, tipoSanguineo, sexo, nomeSocial FROM paciente WHERE id = ?";
        Paciente paciente = new Paciente();
        
                try {
                                pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
                            
            while (resultado.next()) {
                
                paciente.setId(resultado.getInt("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setFone1(resultado.getString("fone1"));
                paciente.setFone2(resultado.getString("fone2"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setCpfCnpj(resultado.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                paciente.setDataCadastro(resultado.getString("dataCadastro"));
                paciente.setCep(resultado.getString("cep"));
                paciente.setCidade(resultado.getString("cidade"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setComplemento(resultado.getString("complemento"));
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));
                
                
            }
        
    }   catch (SQLException ex) {
        ex.printStackTrace();
        
    }finally {
                    ConnectionFactory.closeConnection(conexao, pstm, resultado);
                    return paciente;
                }
        }

    @Override
    public List<Paciente> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, cep, cidade, bairro, "
                + "logradouro, complemento, tipoSanguineo, sexo, nomeSocial FROM paciente WHERE " + atributo + " LIKE ?";

        List<Paciente> pacientes = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            
            while (resultado.next()){
                
                Paciente paciente = new Paciente();
                paciente.setId(resultado.getInt("id"));
                paciente.setNome(resultado.getString("nome"));
                paciente.setFone1(resultado.getString("fone1"));
                paciente.setFone2(resultado.getString("fone2"));
                paciente.setEmail(resultado.getString("email"));
                paciente.setCpfCnpj(resultado.getString("cpfCnpj"));
                paciente.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                paciente.setDataCadastro(resultado.getString("dataCadastro"));
                paciente.setCep(resultado.getString("cep"));
                paciente.setCidade(resultado.getString("cidade"));
                paciente.setBairro(resultado.getString("bairro"));
                paciente.setLogradouro(resultado.getString("logradouro"));
                paciente.setComplemento(resultado.getString("complemento"));
                paciente.setTipoSanguineo(resultado.getString("tipoSanguineo"));
                paciente.setSexo(resultado.getString("sexo"));
                paciente.setNomeSocial(resultado.getString("nomeSocial"));

                pacientes.add(paciente);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return pacientes;
        }
        
    }
    

    @Override
    public void update(Paciente objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE paciente SET nome = ?, fone1 = ?, fone2 = ?, email = ?, cpfCnpj = ?, rgInscricaoEstadual = ?, "
                + "dataCadastro = ?, cep = ?, cidade = ?, bairro = ?, logradouro = ?, complemento = ?, tipoSanguineo = ?, sexo = ?, nomeSocial = ? "
                + "WHERE id = ?";
        
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
            pstm.setString(13, objeto.getTipoSanguineo());
            pstm.setString(14, objeto.getSexo());
            pstm.setString(15, objeto.getNomeSocial());
            pstm.setInt(16, objeto.getId());

            pstm.execute();

        
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
           
    }        
                
}


