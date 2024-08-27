package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Enfermeiro;
import utilities.Utilities;
import view.TelaCadastroEnfermeiro;

public class ControllerCadastroEnfermeiro implements ActionListener {

    TelaCadastroEnfermeiro telaCadastroEnfermeiro;
    
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
            enfermeiro.setId(model.bo.ClasseDadosGravacao.listaEnfermeiro.size() + 1);
            enfermeiro.setNome(this.telaCadastroEnfermeiro.getNomeField().getText());
            enfermeiro.setDataCadastro(this.telaCadastroEnfermeiro.getDataCadastroField().getText());
            enfermeiro.setNomeSocial(this.telaCadastroEnfermeiro.getNomeSocialField().getText());
            enfermeiro.setCpfCnpj(this.telaCadastroEnfermeiro.getCpfCnpjField().getText());
            enfermeiro.setRgInscricaoEstadual(this.telaCadastroEnfermeiro.getRgInscricaoEstadualField().getText());
            enfermeiro.setFone1(this.telaCadastroEnfermeiro.getFone1Field().getText());
            enfermeiro.setFone2(this.telaCadastroEnfermeiro.getFone2Field().getText());
            enfermeiro.setEmail(this.telaCadastroEnfermeiro.getEmailField().getText());
            enfermeiro.setCep(this.telaCadastroEnfermeiro.getCepField().getText());
            enfermeiro.setCidade(this.telaCadastroEnfermeiro.getCidadeField().getText());
            enfermeiro.setBairro(this.telaCadastroEnfermeiro.getBairroField().getText());
            enfermeiro.setLogradouro(this.telaCadastroEnfermeiro.getLogradouroField().getText());
            enfermeiro.setComplemento(this.telaCadastroEnfermeiro.getComplementoField().getText());
            
            model.bo.ClasseDadosGravacao.listaEnfermeiro.add(enfermeiro);

            Utilities.ativaDesativa(false, this.telaCadastroEnfermeiro.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroEnfermeiro.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaEnfermeiro.toString());
        } else if (evento.getSource() == this.telaCadastroEnfermeiro.getjButtonSair()) {
            this.telaCadastroEnfermeiro.dispose();
        }
    }
    
}
