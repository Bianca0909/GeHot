
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Leito;
import view.TelaBuscaLeito;


public class ControllerBuscaLeito implements ActionListener {
    
    TelaBuscaLeito telaBuscaLeito;

    public ControllerBuscaLeito(TelaBuscaLeito telaBuscaLeito) {
        this.telaBuscaLeito = telaBuscaLeito;
        
        this.telaBuscaLeito.getCarregarButton().addActionListener(this);
        this.telaBuscaLeito.getFecharButton().addActionListener(this);
        this.telaBuscaLeito.getButtonFiltrar().addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaLeito.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Leito objetoAtualDaLista : service.ServiceLeito.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(), 
                    objetoAtualDaLista.getDescricao(),
                    objetoAtualDaLista.getStatus(), 
                    objetoAtualDaLista.getQuarto().getDescricao()
                });
            }
        } else if (evento.getSource() == this.telaBuscaLeito.getFecharButton()) {
            this.telaBuscaLeito.dispose();
            
        } else if (evento.getSource() == this.telaBuscaLeito.getButtonFiltrar()){
            if (this.telaBuscaLeito.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaLeito.getValorField().requestFocus();
                
            } else {
                if (this.telaBuscaLeito.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    
                    Leito leito = service.ServiceLeito.ler(Integer.parseInt(this.telaBuscaLeito.getValorField().getText()));
                    tabela.addRow(new Object[]{leito.getId(), leito.getDescricao(), leito.getStatus(), leito.getQuarto()});
                        
                    } else if (this.telaBuscaLeito.getFiltroComboBox().getSelectedItem().equals("DESCRIÇÃO")) {
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        
                        for (Leito objetoAtualDaLista : service.ServiceLeito.ler(this.telaBuscaLeito.getValorField().getText(), "descriçao")){
                            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getDescricao(),
                                objetoAtualDaLista.getDescricao(), objetoAtualDaLista.getStatus()});
                            }
                        
                    }else if (this.telaBuscaLeito.getFiltroComboBox().getSelectedItem().equals("STATUS")){
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                        tabela.setRowCount(0);
                    for (Leito objetoAtualDaLista : service.ServiceLeito.ler(this.telaBuscaLeito.getValorField().getText(), "status")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getStatus(),
                            objetoAtualDaLista.getStatus(), objetoAtualDaLista.getStatus()});
                        
                    }
                        
                        
                    }else if (this.telaBuscaLeito.getFiltroComboBox().getSelectedItem().equals("QUARTO")){
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLeito.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Leito objetoAtualDaLista : service.ServiceLeito.ler(this.telaBuscaLeito.getValorField().getText(), "quarto")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getStatus(),
                            objetoAtualDaLista.getQuarto(), objetoAtualDaLista.getStatus()});
                        }
                    }
                }
            
            }
        }
    }
   

