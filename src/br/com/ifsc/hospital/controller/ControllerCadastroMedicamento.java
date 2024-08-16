package br.com.ifsc.hospital.controller;

import br.com.ifsc.hospital.view.TelaCadastroMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCadastroMedicamento implements ActionListener {

    TelaCadastroMedicamento telaCadastroMedicamento;
    
    public ControllerCadastroMedicamento(TelaCadastroMedicamento telaCadastroMedicamento) {
        this.telaCadastroMedicamento = telaCadastroMedicamento;
        this.telaCadastroMedicamento.getjButtonNovo().addActionListener(this);
        
    }

    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
}
