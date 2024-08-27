package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Medico;
import utilities.Utilities;
import view.TelaCadastroMedico;

public class ControllerCadastroMedico implements ActionListener {

    TelaCadastroMedico telaCadastroMedico;
    
    public ControllerCadastroMedico(TelaCadastroMedico telaCadastroMedico) {
        this.telaCadastroMedico = telaCadastroMedico;

        this.telaCadastroMedico.getjButtonNovo().addActionListener(this);
        this.telaCadastroMedico.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMedico.getjButtonGravar().addActionListener(this);
        this.telaCadastroMedico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMedico.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroMedico.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroMedico.getjPanelDados());
    }
      
    @Override
    public void actionPerformed(ActionEvent evento) {
           if (evento.getSource() == this.telaCadastroMedico.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroMedico.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroMedico.getjPanelDados());
            this.telaCadastroMedico.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroMedico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonGravar()) {

            Medico medico = new Medico();
            medico.setId(model.bo.ClasseDadosGravacao.listaMedico.size() + 1);
            medico.setNome(this.telaCadastroMedico.getNomeField().getText());
            medico.setDataCadastro(this.telaCadastroMedico.getDataCadastroField().getText());
            medico.setNomeSocial(this.telaCadastroMedico.getNomeSocialField().getText());
            medico.setCpfCnpj(this.telaCadastroMedico.getCpfCnpjField().getText());
            medico.setRgInscricaoEstadual(this.telaCadastroMedico.getRgField().getText());
            medico.setFone1(this.telaCadastroMedico.getFone1Field().getText());
            medico.setFone2(this.telaCadastroMedico.getFone2Field().getText());
            medico.setEmail(this.telaCadastroMedico.getEmailField().getText());
            medico.setCep(this.telaCadastroMedico.getCepField().getText());
            medico.setCidade(this.telaCadastroMedico.getCidadeField().getText());
            medico.setBairro(this.telaCadastroMedico.getBairroField().getText());
            medico.setLogradouro(this.telaCadastroMedico.getLogradouroField().getText());
            medico.setComplemento(this.telaCadastroMedico.getComplementoField().getText());
            
            model.bo.ClasseDadosGravacao.listaMedico.add(medico);

            Utilities.ativaDesativa(false, this.telaCadastroMedico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaMedico.toString());
        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonSair()) {
            this.telaCadastroMedico.dispose();
        }
    }
    
}
