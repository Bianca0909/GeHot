package controller;

import view.TelaCadastroLaboratorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Laboratorio;
import utilities.Utilities;

public class ControllerCadastroLaboratorio implements ActionListener {

    TelaCadastroLaboratorio telaCadastroLaboratorio;

    public ControllerCadastroLaboratorio(TelaCadastroLaboratorio telaCadastroLaboratorio) {
        this.telaCadastroLaboratorio = telaCadastroLaboratorio;
        
        this.telaCadastroLaboratorio.getjButtonNovo().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonBuscar().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonGravar().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonCancelar().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativaDesativa(false, this.telaCadastroLaboratorio.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroLaboratorio.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
         if(evento.getSource() == this.telaCadastroLaboratorio.getjButtonNovo()) {
             Utilities.ativaDesativa(true, this.telaCadastroLaboratorio.getjPanelBotoes());
             Utilities.limpaComponentes(true, this.telaCadastroLaboratorio.getjPanelDados());
             this.telaCadastroLaboratorio.getIdField().setEnabled(false);
             
         } else if(evento.getSource() == this.telaCadastroLaboratorio.getjButtonCancelar()) {
             Utilities.ativaDesativa(false, this.telaCadastroLaboratorio.getjPanelBotoes());
             Utilities.limpaComponentes(false, this.telaCadastroLaboratorio.getjPanelDados());
             
         } else if(evento.getSource() == this.telaCadastroLaboratorio.getjButtonGravar()) {
             
             Laboratorio laboratorio = new Laboratorio();
             laboratorio.setId(model.bo.ClasseDadosGravacao.listaLaboratorio.size() + 1);
             laboratorio.setNomeFantasia(this.telaCadastroLaboratorio.getNomeField().getText());
             laboratorio.setContato(this.telaCadastroLaboratorio.getContatoField().getText());
             laboratorio.setStatus(this.telaCadastroLaboratorio.getjComboStatus().getSelectedItem() + "");
             
             model.bo.ClasseDadosGravacao.listaLaboratorio.add(laboratorio);
             
             Utilities.ativaDesativa(false, this.telaCadastroLaboratorio.getjPanelBotoes());
             Utilities.limpaComponentes(false, this.telaCadastroLaboratorio.getjPanelDados());
             
         } else if(evento.getSource() == this.telaCadastroLaboratorio.getjButtonBuscar()) {
             
             JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaLaboratorio.toString());
         } else if(evento.getSource() == this.telaCadastroLaboratorio.getjButtonSair()) {
             this.telaCadastroLaboratorio.dispose();
         }
    }
    
}
