package br.com.ifsc.hospital.controller;

import br.com.ifsc.hospital.view.TelaCadastroMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerCadastroMedicamento implements ActionListener {

    TelaCadastroMedicamento telaCadastroMedicamento;
    
    public ControllerCadastroMedicamento(TelaCadastroMedicamento telaCadastroMedicamento) {
        this.telaCadastroMedicamento = telaCadastroMedicamento;
        this.telaCadastroMedicamento.getjButtonNovo().addActionListener(this);
        // Fazer para o restante dos botões
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.telaCadastroMedicamento.getjButtonNovo()) {
            JOptionPane.showMessageDialog(null, "Rá gluglu");
    } else if(event.getSource() == this.telaCadastroMedicamento.getjButtonSair()) {
        JOptionPane.showMessageDialog(null, "yéyé");
    }
        
    }
}