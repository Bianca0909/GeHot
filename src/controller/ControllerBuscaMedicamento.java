package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Medicamento;
import service.ServiceMedicamento;
import view.TelaBuscaMedicamento;

public class ControllerBuscaMedicamento implements ActionListener {

    TelaBuscaMedicamento telaBuscaMedicamento;

    public ControllerBuscaMedicamento(TelaBuscaMedicamento telaBuscaMedicamento) {
        this.telaBuscaMedicamento = telaBuscaMedicamento;

        this.telaBuscaMedicamento.getjButtonCarregar().addActionListener(this);
        this.telaBuscaMedicamento.getjButtonSair().addActionListener(this);
        this.telaBuscaMedicamento.getjCBFiltro().addActionListener(this);
        this.telaBuscaMedicamento.getjButtonFiltar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaMedicamento.getjButtonCarregar()) {
            
        } else if (evento.getSource() == this.telaBuscaMedicamento.getjButtonSair()) {
            this.telaBuscaMedicamento.dispose();

        } else if (evento.getSource() == this.telaBuscaMedicamento.getjButtonFiltar()) {
            if (this.telaBuscaMedicamento.getjTFFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaMedicamento.getjTFFiltro().requestFocus();
            } else {
                if (this.telaBuscaMedicamento.getjCBFiltro().getSelectedItem().equals("ID")) {

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    Medicamento medicamento = ServiceMedicamento.ler(Integer.parseInt(this.telaBuscaMedicamento.getjTFFiltro().getText()));
                    tabela.addRow(new Object[]{medicamento.getId(), medicamento.getDescricaoMedicamento(),
                        medicamento.getPrincipioAtivo(), medicamento.getStatus()});

                } else if (this.telaBuscaMedicamento.getjCBFiltro().getSelectedItem().equals("DESCRIÇÃO")) {

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.ServiceMedicamento.ler(this.telaBuscaMedicamento.getjTFFiltro().getText(), "descricaoMedicamento")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getDescricaoMedicamento(),
                            objetoAtualDaLista.getPrincipioAtivo(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaMedicamento.getjCBFiltro().getSelectedItem().equals("PRINCÍPIO ATIVO")) {

                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.ServiceMedicamento.ler(this.telaBuscaMedicamento.getjTFFiltro().getText(), "principioAtivo")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getDescricaoMedicamento(),
                            objetoAtualDaLista.getPrincipioAtivo(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaMedicamento.getjCBFiltro().getSelectedItem().equals("STATUS")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMedicamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Medicamento objetoAtualDaLista : service.ServiceMedicamento.ler(this.telaBuscaMedicamento.getjTFFiltro().getText(), "status")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getDescricaoMedicamento(),
                            objetoAtualDaLista.getPrincipioAtivo(), objetoAtualDaLista.getStatus()});
                    }
                }

            }
        }
    }
}
