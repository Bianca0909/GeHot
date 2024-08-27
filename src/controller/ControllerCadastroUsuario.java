package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Usuario;
import utilities.Utilities;
import view.TelaCadastroUsuario;

public class ControllerCadastroUsuario implements ActionListener {

    TelaCadastroUsuario telaCadastroUsuario;

    public ControllerCadastroUsuario(TelaCadastroUsuario telaCadastroUsuario) {
        this.telaCadastroUsuario = telaCadastroUsuario;

        this.telaCadastroUsuario.getjButtonNovo().addActionListener(this);
        this.telaCadastroUsuario.getjButtonBuscar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonGravar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaCadastroUsuario.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroUsuario.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if (evento.getSource() == this.telaCadastroUsuario.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroUsuario.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroUsuario.getjPanelDados());
            this.telaCadastroUsuario.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroUsuario.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroUsuario.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonGravar()) {

            Usuario usuario = new Usuario();
            usuario.setId(model.bo.ClasseDadosGravacao.listaQuarto.size() + 1);
            usuario.setNome(this.telaCadastroUsuario.getNomeField().getText());
            usuario.setDataCadastro(this.telaCadastroUsuario.getDataCadastroField().getText());
            usuario.setNomeSocial(this.telaCadastroUsuario.getNomeSocialField().getText());
            usuario.setCpfCnpj(this.telaCadastroUsuario.getRgField().getText());
            usuario.setFone1(this.telaCadastroUsuario.getFone1Field().getText());
            usuario.setFone2(this.telaCadastroUsuario.getFone2Field().getText());
            usuario.setEmail(this.telaCadastroUsuario.getEmailField().getText());
            usuario.setCep(this.telaCadastroUsuario.getCepField().getText());
            usuario.setCep(this.telaCadastroUsuario.getCepField().getText());
            usuario.setCidade(this.telaCadastroUsuario.getCidadeField().getText());
            usuario.setBairro(this.telaCadastroUsuario.getBairroField().getText());
            usuario.setLogradouro(this.telaCadastroUsuario.getLogradouroField().getText());
            usuario.setComplemento(this.telaCadastroUsuario.getComplementoField().getText());
            
            model.bo.ClasseDadosGravacao.listaUsuario.add(usuario);

            Utilities.ativaDesativa(false, this.telaCadastroUsuario.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroUsuario.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonBuscar()) {
            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaUsuario.toString());
        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonSair()) {
            this.telaCadastroUsuario.dispose();
        }
    }

}
