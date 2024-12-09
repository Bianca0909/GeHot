
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
        String sqlInstrucao = "INSERT INTO usuario(login, senha) VALUES(?, ?)";

        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getLogin());
            pstm.setString(2, objeto.getSenha());
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
        String sqlInstrucao = "SELECT id, login, senha FROM hospital.usuario";
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            resultado = pstm.executeQuery();
            
            while (resultado.next()){
                                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));

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
        String sqlInstrucao = "SELECT id, login, senha FROM hospital.usuario WHERE id = ?";
        Usuario usuario = new Usuario();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, pk);
            resultado = pstm.executeQuery();
            
            while (resultado.next()){
                usuario.setId(resultado.getInt("id"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));             
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
        String sqlInstrucao = "SELECT id, login, senha FROM usuario WHERE " + atributo + " LIKE ?";
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + parametro + "%");
            resultado = pstm.executeQuery();
            
            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
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
        String sqlInstrucao = "UPDATE usuario SET login = ?, senha = ? "
                + "WHERE id = ?";
        
        try {
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, objeto.getLogin());
            pstm.setString(2, objeto.getSenha());
            pstm.setInt(3, objeto.getId());
            pstm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conexao, pstm, null);
        }
        
    }
    
}
