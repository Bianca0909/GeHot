package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Farmaceutico;
import service.ServiceFarmaceutico;
import view.TelaBuscaFarmaceutico;


public class ControllerBuscaFarmaceutico implements ActionListener {

    TelaBuscaFarmaceutico telaBuscatelaBuscaFarmaceutico;

    public ControllerBuscaFarmaceutico(TelaBuscaFarmaceutico telaBuscatelaBuscaFarmaceutico) {
        this.telaBuscatelaBuscaFarmaceutico = telaBuscatelaBuscaFarmaceutico;
        this.telaBuscatelaBuscaFarmaceutico.getCarregarButton().addActionListener(this);
        this.telaBuscatelaBuscaFarmaceutico.getButtonFechar().addActionListener(this);
        this.telaBuscatelaBuscaFarmaceutico.getButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscatelaBuscaFarmaceutico.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Farmaceutico objetoAtualDaLista : service.ServiceFarmaceutico.ler()) {
                tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                    objetoAtualDaLista.getCrf(), objetoAtualDaLista.getDataCadastro(),
                    objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
            }
        } else if (evento.getSource() == this.telaBuscatelaBuscaFarmaceutico.getButtonFechar()) {
            this.telaBuscatelaBuscaFarmaceutico.dispose();
        } else if (evento.getSource() == this.telaBuscatelaBuscaFarmaceutico.getButtonFiltrar()) {
            if (this.telaBuscatelaBuscaFarmaceutico.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscatelaBuscaFarmaceutico.getValorField().requestFocus();
            } else {
                if (this.telaBuscatelaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    Farmaceutico farmaceutico = ServiceFarmaceutico.ler(Integer.parseInt(this.telaBuscatelaBuscaFarmaceutico.getValorField().getText()));
                    tabela.addRow(new Object[]{farmaceutico.getId(), farmaceutico.getNome(),
                        farmaceutico.getCrf(), farmaceutico.getDataCadastro(),
                        farmaceutico.getEmail(), farmaceutico.getFone1()});
                } else if (this.telaBuscatelaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().equals("NOME")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.ServiceFarmaceutico.ler(this.telaBuscatelaBuscaFarmaceutico.getValorField().getText(), "nome")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrf(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscatelaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().equals("CRF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.ServiceFarmaceutico.ler(this.telaBuscatelaBuscaFarmaceutico.getValorField().getText(), "crm")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrf(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscatelaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().equals("DATA NASCIMENTO")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.ServiceFarmaceutico.ler(this.telaBuscatelaBuscaFarmaceutico.getValorField().getText(), "dataCadastro")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrf(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscatelaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().equals("EMAIL")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.ServiceFarmaceutico.ler(this.telaBuscatelaBuscaFarmaceutico.getValorField().getText(), "email")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrf(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                } else if (this.telaBuscatelaBuscaFarmaceutico.getFiltroComboBox().getSelectedItem().equals("TELEFONE")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscatelaBuscaFarmaceutico.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Farmaceutico objetoAtualDaLista : service.ServiceFarmaceutico.ler(this.telaBuscatelaBuscaFarmaceutico.getValorField().getText(), "fone1")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCrf(), objetoAtualDaLista.getDataCadastro(),
                            objetoAtualDaLista.getEmail(), objetoAtualDaLista.getFone1()});
                    }
                }
            }
        }
    }

}
