package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Medico;
import service.ServiceMedico;
import view.TelaBuscaMedico;

public class ControllerBuscaMedico implements ActionListener {

    TelaBuscaMedico telaBuscaMedico;

    public ControllerBuscaMedico(TelaBuscaMedico telaBuscaMedico) {
        this.telaBuscaMedico = telaBuscaMedico;
        this.telaBuscaMedico.getCarregarButton().addActionListener(this);
        this.telaBuscaMedico.getButtonFechar().addActionListener(this);
        this.telaBuscaMedico.getButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaMedico.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Medico objetoAtualDaLista : service.ServiceMedico.ler()) {
                tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                    objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                    objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
            }
        } else if (evento.getSource() == this.telaBuscaMedico.getButtonFechar()) {
            this.telaBuscaMedico.dispose();
        } else if (evento.getSource() == this.telaBuscaMedico.getButtonFiltrar()) {
            if (this.telaBuscaMedico.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaMedico.getValorField().requestFocus();
            } else {
                if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    Medico medico = ServiceMedico.ler(Integer.parseInt(this.telaBuscaMedico.getValorField().getText()));
                    tabela.addRow(new Object[]{medico.getId(), medico.getNome(),
                        medico.getCrm(), medico.getCrm(), medico.getDataCadastro(),
                        medico.getEmail(), medico.getFone1()});
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("NOME")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "nome")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("CRM")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "crm")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("DATA NASCIMENTO")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "dataCadastro")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("EMAIL")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "email")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscaMedico.getFiltroComboBox().getSelectedItem().equals("TELEFONE")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medico objetoAtualDaLista : service.ServiceMedico.ler(this.telaBuscaMedico.getValorField().getText(), "fone1")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrm(), objetoAtualDaLista.getCrm(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                }
            }
        }
    }
}
