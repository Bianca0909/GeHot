package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Laboratorio;
import service.ServiceLaboratorio;
import view.TelaBuscaLaboratorio;

public class ControllerBuscaLaboratorio implements ActionListener {

    TelaBuscaLaboratorio telaBuscaLaboratorio;

    public ControllerBuscaLaboratorio(TelaBuscaLaboratorio telaBuscaLaboratorio) {

        this.telaBuscaLaboratorio = telaBuscaLaboratorio;
        this.telaBuscaLaboratorio.getCarregarButton().addActionListener(this);
        this.telaBuscaLaboratorio.getFecharButton().addActionListener(this);
        this.telaBuscaLaboratorio.getButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaLaboratorio.getCarregarButton()) {

            if ((!this.telaBuscaLaboratorio.getJTableDados().getValueAt(this.telaBuscaLaboratorio.getJTableDados().getSelectedRow(), 0).equals("")) && 
                    (this.telaBuscaLaboratorio.getJTableDados().getValueAt(this.telaBuscaLaboratorio.getJTableDados().getSelectedRow(), 3).equals("ATIVO"))) {
                ControllerCadastroLaboratorio.codigo = (int) this.telaBuscaLaboratorio.getJTableDados().getValueAt(this.telaBuscaLaboratorio.getJTableDados().getSelectedRow(), 0);
                this.telaBuscaLaboratorio.dispose();
            }
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFechar()) {
            this.telaBuscaLaboratorio.dispose();
        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFiltrar()) {
            if (this.telaBuscaLaboratorio.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaLaboratorio.getValorField().requestFocus();
            } else {
                if (this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    Laboratorio laboratorio = ServiceLaboratorio.ler(Integer.parseInt(this.telaBuscaLaboratorio.getValorField().getText()));
                    tabela.addRow(new Object[]{laboratorio.getId(), laboratorio.getNomeFantasia(), laboratorio.getContato(), laboratorio.getStatus()});
                } else if (this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedItem().equals("DESCRIÇÃO")) {

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Laboratorio objetoAtualDaLista : service.ServiceLaboratorio.ler(this.telaBuscaLaboratorio.getValorField().getText(), "nomeFantasia")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNomeFantasia(),
                            objetoAtualDaLista.getContato(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedItem().equals("CONTATO")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Laboratorio objetoAtualDaLista : service.ServiceLaboratorio.ler(this.telaBuscaLaboratorio.getValorField().getText(), "contato")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNomeFantasia(),
                            objetoAtualDaLista.getContato(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedItem().equals("STATUS")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Laboratorio objetoAtualDaLista : service.ServiceLaboratorio.ler(this.telaBuscaLaboratorio.getValorField().getText(), "status")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNomeFantasia(),
                            objetoAtualDaLista.getContato(), objetoAtualDaLista.getStatus()});
                    }
                }
            }
        }
    }
}
