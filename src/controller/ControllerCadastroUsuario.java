package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Usuario;
import utilities.Utilities;
import view.TelaBuscaUsuario;
import view.TelaCadastroUsuario;

public class ControllerCadastroUsuario implements ActionListener {

    public static int codigo;

    TelaCadastroUsuario telaCadastroUsuario;

    public ControllerCadastroUsuario(TelaCadastroUsuario telaCadastroUsuario) {
        this.telaCadastroUsuario = telaCadastroUsuario;

        this.telaCadastroUsuario.getjButtonNovo().addActionListener(this);
        this.telaCadastroUsuario.getjButtonBuscar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonGravar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonCancelar().addActionListener(this);
        this.telaCadastroUsuario.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroUsuario.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroUsuario.getjPanelDados());
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
            usuario.setLogin(this.telaCadastroUsuario.getLoginField().getText());
            usuario.setSenha(this.telaCadastroUsuario.getSenhaField().getText());

            if (this.telaCadastroUsuario.getIdField().getText().equals("")) {
                service.ServiceUsuario.adicionar(usuario);

            } else {
                usuario.setId(Integer.parseInt(this.telaCadastroUsuario.getIdField().getText()));
                service.ServiceUsuario.atualizar(usuario);
            }

            Utilities.ativaDesativa(false, this.telaCadastroUsuario.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroUsuario.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaUsuario telaBuscaUsuario = new TelaBuscaUsuario(null, true);
            ControllerBuscaUsuario controllerBuscaUsuario = new ControllerBuscaUsuario(telaBuscaUsuario);
            telaBuscaUsuario.setVisible(true);

            if (codigo != 0) {
                Usuario usuario = service.ServiceUsuario.ler(codigo);

                Utilities.ativaDesativa(true, this.telaCadastroUsuario.getjPanelBotoes());
                Utilities.limpaComponentes(true, this.telaCadastroUsuario.getjPanelDados());

                this.telaCadastroUsuario.getIdField().setText(usuario.getId() + "");
                this.telaCadastroUsuario.getLoginField().setText(usuario.getLogin());
                this.telaCadastroUsuario.getSenhaField().setText(usuario.getSenha());

                this.telaCadastroUsuario.getIdField().setEnabled(false);
                this.telaCadastroUsuario.getLoginField().requestFocus();
            }

        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonSair()) {
            this.telaCadastroUsuario.dispose();
        }
    }
}

