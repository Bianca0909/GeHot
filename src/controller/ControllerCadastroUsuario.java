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
            usuario.setId(model.bo.ClasseDadosGravacao.listaUsuario.size() + 1);
            usuario.setNome(this.telaCadastroUsuario.getNomeField().getText());
            usuario.setFone1(this.telaCadastroUsuario.getFone1Field().getText());
            usuario.setFone2(this.telaCadastroUsuario.getFone2Field().getText());
            usuario.setEmail(this.telaCadastroUsuario.getEmailField().getText());
            usuario.setCpfCnpj(this.telaCadastroUsuario.getCpfField().getText());
            usuario.setRgInscricaoEstadual(this.telaCadastroUsuario.getRgField().getText());
            usuario.setDataCadastro(this.telaCadastroUsuario.getDataCadastroField().getText());
            usuario.setCep(this.telaCadastroUsuario.getCepField().getText());
            usuario.setCidade(this.telaCadastroUsuario.getCidadeField().getText());
            usuario.setBairro(this.telaCadastroUsuario.getBairroField().getText());
            usuario.setLogradouro(this.telaCadastroUsuario.getLogradouroField().getText());
            usuario.setComplemento(this.telaCadastroUsuario.getComplementoField().getText());
            usuario.setLogin(this.telaCadastroUsuario.getLoginField().getText());
            usuario.setSenha(this.telaCadastroUsuario.getSenhaField().getText());
            usuario.setNomeSocial(this.telaCadastroUsuario.getNomeSocialField().getText());

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
                this.telaCadastroUsuario.getNomeField().setText(usuario.getNome());
                this.telaCadastroUsuario.getNomeSocialField().setText(usuario.getNomeSocial());
                this.telaCadastroUsuario.getFone1Field().setText(usuario.getFone1());
                this.telaCadastroUsuario.getFone2Field().setText(usuario.getFone2());
                this.telaCadastroUsuario.getEmailField().setText(usuario.getEmail());
                this.telaCadastroUsuario.getCpfField().setText(usuario.getCpfCnpj());
                this.telaCadastroUsuario.getRgField().setText(usuario.getRgInscricaoEstadual());
                this.telaCadastroUsuario.getDataCadastroField().setText(usuario.getDataCadastro());
                this.telaCadastroUsuario.getCepField().setText(usuario.getCep());
                this.telaCadastroUsuario.getCidadeField().setText(usuario.getCidade());
                this.telaCadastroUsuario.getBairroField().setText(usuario.getBairro());
                this.telaCadastroUsuario.getLogradouroField().setText(usuario.getLogradouro());
                this.telaCadastroUsuario.getComplementoField().setText(usuario.getComplemento());
                this.telaCadastroUsuario.getLoginField().setText(usuario.getLogin());
                this.telaCadastroUsuario.getSenhaField().setText(usuario.getSenha());

                this.telaCadastroUsuario.getIdField().setEnabled(false);
                this.telaCadastroUsuario.getNomeField().requestFocus();
            }

        } else if (evento.getSource() == this.telaCadastroUsuario.getjButtonSair()) {
            this.telaCadastroUsuario.dispose();
        }
    }
}

