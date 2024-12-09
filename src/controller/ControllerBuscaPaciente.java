
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Paciente;
import service.ServicePaciente;
import view.TelaBuscaPaciente;


public class ControllerBuscaPaciente implements ActionListener {
    
    TelaBuscaPaciente telaBuscaPaciente;

    public ControllerBuscaPaciente(TelaBuscaPaciente telaBuscaPaciente) {
        this.telaBuscaPaciente = telaBuscaPaciente;
        
        this.telaBuscaPaciente.getCarregarButton().addActionListener(this);
        this.telaBuscaPaciente.getFecharButton().addActionListener(this);
        this.telaBuscaPaciente.getButtonFiltrar().addActionListener(this);
 
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaPaciente.getCarregarButton()){
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
            tabela.setRowCount(0);
            
            for (Paciente objetoAtualDaLista : service.ServicePaciente.ler()) {
                    tabela.addRow(new Object[]{
                        objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                    objetoAtualDaLista.getCpfCnpj(), objetoAtualDaLista.getCpfCnpj(), objetoAtualDaLista.getNome(),
                    objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1(), objetoAtualDaLista.getDataCadastro(), objetoAtualDaLista.getFone1() });
                                  

            } 
            
        }else if (evento.getSource() == this.telaBuscaPaciente.getFecharButton()) {
            this.telaBuscaPaciente.dispose();
            
        } else if (evento.getSource() == this.telaBuscaPaciente.getButtonFiltrar()){
            if (this.telaBuscaPaciente.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaPaciente.getValorField().requestFocus();
            } else {
                if (this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    
                    Paciente paciente = ServicePaciente.ler(Integer.parseInt(this.telaBuscaPaciente.getValorField().getText()));
                    tabela.addRow(new Object[]{paciente.getId(), paciente.getNome(),
                        paciente.getCpfCnpj(), paciente.getFone1(), paciente.getDataCadastro(), paciente.getEmail()});
                    
                    } else if (this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().equals("NOME")){
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Paciente objetoAtualDaLista : service.ServicePaciente.ler(this.telaBuscaPaciente.getValorField().getText(), "nome")) {
                            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(), objetoAtualDaLista.getDataCadastro(), objetoAtualDaLista.getEmail(),
                            objetoAtualDaLista.getFone1()});
                        }
                    }else if(this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().equals("CPF")) {
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Paciente objetoAtualDaLista : service.ServicePaciente.ler(this.telaBuscaPaciente.getValorField().getText(), "cpf")) {
                            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(), objetoAtualDaLista.getDataCadastro(), objetoAtualDaLista.getEmail(),
                            objetoAtualDaLista.getFone1()});
                        }
                    } else if (this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().equals("DATA NASCIMENTO")) {
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Paciente objetoAtualDaLista : service.ServicePaciente.ler(this.telaBuscaPaciente.getValorField().getText(), "dataCadastro")) {
                            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(),objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                        }
                    } else if (this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().equals("EMAIL")) {
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Paciente objetoAtualDaLista : service.ServicePaciente.ler(this.telaBuscaPaciente.getValorField().getText(), "email")) {
                            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(),objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                        }
                    } else if (this.telaBuscaPaciente.getFiltroComboBox().getSelectedItem().equals("TELEFONE")) {
                        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaPaciente.getJTableDados().getModel();
                        tabela.setRowCount(0);
                        for (Paciente objetoAtualDaLista : service.ServicePaciente.ler(this.telaBuscaPaciente.getValorField().getText(), "telefone")) {
                            tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(),objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                        }
                        
                    
                        
                    }  
                }
    
            }
    
        }
}