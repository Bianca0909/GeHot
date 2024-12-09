package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Enfermeiro;
import utilities.Utilities;
import view.TelaCadastroEnfermeiro;
import view.TelaBuscaEnfermeiro;

public class ControllerCadastroEnfermeiro implements ActionListener {

    TelaCadastroEnfermeiro telaCadastroEnfermeiro;
    public static int codigo;

    public ControllerCadastroEnfermeiro(TelaCadastroEnfermeiro telaCadastroEnfermeiro) {
        this.telaCadastroEnfermeiro = telaCadastroEnfermeiro;

        this.telaCadastroEnfermeiro.getjButtonNovo().addActionListener(this);
        this.telaCadastroEnfermeiro.getjButtonBuscar().addActionListener(this);
        this.telaCadastroEnfermeiro.getjButtonGravar().addActionListener(this);
        this.telaCadastroEnfermeiro.getjButtonCancelar().addActionListener(this);
        this.telaCadastroEnfermeiro.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroEnfermeiro.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroEnfermeiro.getjPanelDados());
    }

    @Override
public void actionPerformed(ActionEvent evento) {

    if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonNovo()) {
        Utilities.ativaDesativa(true, this.telaCadastroEnfermeiro.getjPanelBotoes());
        Utilities.limpaComponentes(true, this.telaCadastroEnfermeiro.getjPanelDados());
        this.telaCadastroEnfermeiro.getIdField().setEnabled(false);

    } else if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonCancelar()) {
        Utilities.ativaDesativa(false, this.telaCadastroEnfermeiro.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroEnfermeiro.getjPanelDados());

    } else if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonGravar()) {

        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setNome(this.telaCadastroEnfermeiro.getNomeField().getText());
        enfermeiro.setCpfCnpj(this.telaCadastroEnfermeiro.getCpfCnpjField().getText());
        enfermeiro.setFone1(this.telaCadastroEnfermeiro.getFone1Field().getText());
        enfermeiro.setFone2(this.telaCadastroEnfermeiro.getFone2Field().getText());
        enfermeiro.setEmail(this.telaCadastroEnfermeiro.getEmailField().getText());
        enfermeiro.setCre(this.telaCadastroEnfermeiro.getCreField().getText());
        enfermeiro.setLogin(this.telaCadastroEnfermeiro.getLoginField().getText());
        enfermeiro.setSenha(this.telaCadastroEnfermeiro.getSenhaField().getText());
        enfermeiro.setNomeSocial(this.telaCadastroEnfermeiro.getNomeSocialField().getText());
        enfermeiro.setRgInscricaoEstadual(this.telaCadastroEnfermeiro.getRgInscricaoEstadualField().getText());
        enfermeiro.setDataCadastro(this.telaCadastroEnfermeiro.getDataCadastroField().getText());
        enfermeiro.setCep(this.telaCadastroEnfermeiro.getCepField().getText());
        enfermeiro.setCidade(this.telaCadastroEnfermeiro.getCidadeField().getText());
        enfermeiro.setBairro(this.telaCadastroEnfermeiro.getBairroField().getText());
        enfermeiro.setLogradouro(this.telaCadastroEnfermeiro.getLogradouroField().getText());
        enfermeiro.setComplemento(this.telaCadastroEnfermeiro.getComplementoField().getText());

        if (this.telaCadastroEnfermeiro.getIdField().getText().equals("")) {
            service.ServiceEnfermeiro.adicionar(enfermeiro);
        } else {
            enfermeiro.setId(Integer.parseInt(this.telaCadastroEnfermeiro.getIdField().getText()));
            service.ServiceEnfermeiro.atualizar(enfermeiro);
        }

        Utilities.ativaDesativa(false, this.telaCadastroEnfermeiro.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroEnfermeiro.getjPanelDados());

    } else if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonBuscar()) {
        codigo = 0;

        TelaBuscaEnfermeiro telaBuscaEnfermeiro = new TelaBuscaEnfermeiro(null, true);
        ControllerBuscaEnfermeiro controllerBuscaEnfermeiro = new ControllerBuscaEnfermeiro(telaBuscaEnfermeiro);
        telaBuscaEnfermeiro.setVisible(true);

        if (codigo != 0) {
            Enfermeiro enfermeiro = service.ServiceEnfermeiro.ler(codigo);

            Utilities.ativaDesativa(true, this.telaCadastroEnfermeiro.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroEnfermeiro.getjPanelDados());

            this.telaCadastroEnfermeiro.getIdField().setText(enfermeiro.getId() + "");
            this.telaCadastroEnfermeiro.getNomeField().setText(enfermeiro.getNome());
            this.telaCadastroEnfermeiro.getCpfCnpjField().setText(enfermeiro.getCpfCnpj());
            this.telaCadastroEnfermeiro.getFone1Field().setText(enfermeiro.getFone1());
            this.telaCadastroEnfermeiro.getFone2Field().setText(enfermeiro.getFone2());
            this.telaCadastroEnfermeiro.getEmailField().setText(enfermeiro.getEmail());
            this.telaCadastroEnfermeiro.getCreField().setText(enfermeiro.getCre());
            this.telaCadastroEnfermeiro.getLoginField().setText(enfermeiro.getLogin());
            this.telaCadastroEnfermeiro.getSenhaField().setText(enfermeiro.getSenha());
            this.telaCadastroEnfermeiro.getNomeSocialField().setText(enfermeiro.getNomeSocial());
            this.telaCadastroEnfermeiro.getRgInscricaoEstadualField().setText(enfermeiro.getRgInscricaoEstadual());
            this.telaCadastroEnfermeiro.getDataCadastroField().setText(enfermeiro.getDataCadastro());
            this.telaCadastroEnfermeiro.getCepField().setText(enfermeiro.getCep());
            this.telaCadastroEnfermeiro.getCidadeField().setText(enfermeiro.getCidade());
            this.telaCadastroEnfermeiro.getBairroField().setText(enfermeiro.getBairro());
            this.telaCadastroEnfermeiro.getLogradouroField().setText(enfermeiro.getLogradouro());
            this.telaCadastroEnfermeiro.getComplementoField().setText(enfermeiro.getComplemento());

            this.telaCadastroEnfermeiro.getIdField().setEnabled(false);
            this.telaCadastroEnfermeiro.getNomeField().requestFocus();
        }

    } else if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonSair()) {
        this.telaCadastroEnfermeiro.dispose();
    }
}
}
