package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Leito;
import model.bo.Quarto;
import utilities.Utilities;
import view.TelaCadastroLeito;

public class ControllerTelaCadastroLeito implements ActionListener {

    TelaCadastroLeito telaCadastroLeito;
    
    public ControllerTelaCadastroLeito(TelaCadastroLeito telaCadastroLeito) {
        this.telaCadastroLeito = telaCadastroLeito;
        
        this.telaCadastroLeito.getjButtonNovo().addActionListener(this);
        this.telaCadastroLeito.getjButtonBuscar().addActionListener(this);
        this.telaCadastroLeito.getjButtonGravar().addActionListener(this);
        this.telaCadastroLeito.getjButtonCancelar().addActionListener(this);
        this.telaCadastroLeito.getjButtonSair().addActionListener(this);
        
        Utilities.ativaDesativa(false, this.telaCadastroLeito.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroLeito.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroLeito.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroLeito.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroLeito.getjPanelDados());
            this.telaCadastroLeito.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroLeito.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroLeito.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonGravar()) {

            Leito leito = new Leito();
            leito.setId(model.bo.ClasseDadosGravacao.listaLeito.size() + 1);
            leito.setDescricao(this.telaCadastroLeito.getDescricaoField().getText());
            leito.setStatus(this.telaCadastroLeito.getStatusComboBox().getSelectedItem() + "");
            leito.setQuarto((Quarto)this.telaCadastroLeito.getQuartoComboBox().getSelectedItem());
            
            model.bo.ClasseDadosGravacao.listaLeito.add(leito);

            Utilities.ativaDesativa(false, this.telaCadastroLeito.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroLeito.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaLeito.toString());
        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonSair()) {
            this.telaCadastroLeito.dispose();
        }

        
    }
    
}
