package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Acompanhante;
import utilities.Utilities;
import view.TelaCadastroAcompanhante;

public class ControllerCadastroAcompanhante implements ActionListener {

    TelaCadastroAcompanhante telaCadastroAcompanhante;
    
    public ControllerCadastroAcompanhante(TelaCadastroAcompanhante telaCadastroAcompanhante) {
        this.telaCadastroAcompanhante = telaCadastroAcompanhante;
        
        this.telaCadastroAcompanhante.getjButtonNovo().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonGravar().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAcompanhante.getjButtonSair().addActionListener(this);
        
        Utilities.ativaDesativa(false, this.telaCadastroAcompanhante.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroAcompanhante.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
      
        if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroAcompanhante.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroAcompanhante.getjPanelDados());
            this.telaCadastroAcompanhante.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroAcompanhante.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAcompanhante.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonGravar()) {

            Acompanhante acompanhante = new Acompanhante();
            acompanhante.setId(model.bo.ClasseDadosGravacao.listaAcompanhante.size() + 1);
            acompanhante.setNome(this.telaCadastroAcompanhante.getNomeField().getText());
            acompanhante.setEmail(this.telaCadastroAcompanhante.getEmailField().getText());
            acompanhante.setCpf(this.telaCadastroAcompanhante.getCpfCnpjField().getText());
            acompanhante.setFone(this.telaCadastroAcompanhante.getFone1Field().getText());
            acompanhante.setGrauParentesco(this.telaCadastroAcompanhante.getGrauParentescoField().getText());
            acompanhante.setStatus(this.telaCadastroAcompanhante.getStatusComboBox().getSelectedItem() + "");

            model.bo.ClasseDadosGravacao.listaAcompanhante.add(acompanhante);

            Utilities.ativaDesativa(false, this.telaCadastroAcompanhante.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAcompanhante.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaAcompanhante.toString());
        } else if (evento.getSource() == this.telaCadastroAcompanhante.getjButtonSair()) {
            this.telaCadastroAcompanhante.dispose();
        }
    }
    
}
