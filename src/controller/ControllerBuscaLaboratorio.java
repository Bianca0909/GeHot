package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Laboratorio;
import view.TelaBuscaLaboratorio;

public class ControllerBuscaLaboratorio implements ActionListener {
    
    TelaBuscaLaboratorio telaBuscaLaboratorio;
    public static Laboratorio laboratorio;
    
    public ControllerBuscaLaboratorio(TelaBuscaLaboratorio telaBuscaLaboratorio) {
        
        this.telaBuscaLaboratorio = telaBuscaLaboratorio;    
        this.telaBuscaLaboratorio.getCarregarButton().addActionListener(this);
        this.telaBuscaLaboratorio.getFecharButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource() == this.telaBuscaLaboratorio.getCarregarButton()) {
            
            
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFiltrar()) {
          
            
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFechar()) {
            this.telaBuscaLaboratorio.dispose();
        }
    }
}
