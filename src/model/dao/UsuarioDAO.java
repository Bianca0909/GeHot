
package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bo.Usuario;


public class UsuarioDAO  implements InterfaceDAO<Usuario>{
    

    @Override
    public void create(Usuario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "INSERT INTO usuario(nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, "
                + "cep, cidade, bairro, logradouro, complemento, login, senha, nomeSocial) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            pstm.setString(13, objeto.getLogin());
            pstm.setString(14, objeto.getSenha());
            pstm.setString(15, objeto.getNomeSocial());
            
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
    }

    @Override
    public List<Usuario> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, "
        + "cep, cidade, bairro, logradouro, complemento, login, senha, nomeSocial FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            
            while (resultado.next()){
                                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setFone1(resultado.getString("fone1"));
                usuario.setFone2(resultado.getString("fone2"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setCpfCnpj(resultado.getString("cpfCnpj"));
                usuario.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                usuario.setDataCadastro(resultado.getString("dataCadastro"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setCidade(resultado.getString("cidade"));
                usuario.setBairro(resultado.getString("bairro"));
                usuario.setLogradouro(resultado.getString("logradouro"));
                usuario.setComplemento(resultado.getString("complemento"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNomeSocial(resultado.getString("nomeSocial"));

                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return usuarios;
        }
        
    }

    @Override
    public Usuario retrieve(int pk) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, "
                + "cep, cidade, bairro, logradouro, complemento, login, senha, nomeSocial FROM usuario WHERE id = ?";
        Usuario usuario = new Usuario();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            
            while (resultado.next()){
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setFone1(resultado.getString("fone1"));
                usuario.setFone2(resultado.getString("fone2"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setCpfCnpj(resultado.getString("cpfCnpj"));
                usuario.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                usuario.setDataCadastro(resultado.getString("dataCadastro"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setCidade(resultado.getString("cidade"));
                usuario.setBairro(resultado.getString("bairro"));
                usuario.setLogradouro(resultado.getString("logradouro"));
                usuario.setComplemento(resultado.getString("complemento"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNomeSocial(resultado.getString("nomeSocial"));
                
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return usuario;
        }
                
    }

    @Override
    public List<Usuario> retrieve(String parametro, String atributo) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        String sqlInstrucao = "SELECT id, nome, fone1, fone2, email, cpfCnpj, rgInscricaoEstadual, dataCadastro, "
                + "cep, cidade, bairro, logradouro, complemento, login, senha, nomeSocial FROM usuario WHERE " + atributo + " LIKE ?";
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setFone1(resultado.getString("fone1"));
                usuario.setFone2(resultado.getString("fone2"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setCpfCnpj(resultado.getString("cpfCnpj"));
                usuario.setRgInscricaoEstadual(resultado.getString("rgInscricaoEstadual"));
                usuario.setDataCadastro(resultado.getString("dataCadastro"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setCidade(resultado.getString("cidade"));
                usuario.setBairro(resultado.getString("bairro"));
                usuario.setLogradouro(resultado.getString("logradouro"));
                usuario.setComplemento(resultado.getString("complemento"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setNomeSocial(resultado.getString("nomeSocial"));

                usuarios.add(usuario);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, resultado);
            return usuarios;
        }
        
    }

    @Override
    public void update(Usuario objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        String sqlInstrucao = "UPDATE usuario SET nome = ?, fone1 = ?, fone2 = ?, email = ?, cpfCnpj = ?, rgInscricaoEstadual = ?, "
                + "dataCadastro = ?, cep = ?, cidade = ?, bairro = ?, logradouro = ?, complemento = ?, login = ?, senha = ?, nomeSocial = ? "
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
            pstm.setString(13, objeto.getLogin());
            pstm.setString(14, objeto.getSenha());
            pstm.setString(15, objeto.getNomeSocial());
            pstm.setInt(16, objeto.getId());

            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
        
    }
    
}
