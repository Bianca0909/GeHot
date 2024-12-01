package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Acompanhante;
import service.ServiceAcompanhante;
import view.TelaBuscaAcompanhante;

public class ControllerBuscaAcompanhante implements ActionListener {

    TelaBuscaAcompanhante telaBuscaAcompanhante;

    public ControllerBuscaAcompanhante(TelaBuscaAcompanhante telaBuscaAcompanhante) {

        this.telaBuscaAcompanhante = telaBuscaAcompanhante;
        this.telaBuscaAcompanhante.getCarregarButton().addActionListener(this);
        this.telaBuscaAcompanhante.getButtonFechar().addActionListener(this);
        this.telaBuscaAcompanhante.getButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaAcompanhante.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler()) {
                tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(), objetoAtualDaLista.getCpf(),
                    objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
            }
        } else if (evento.getSource() == this.telaBuscaAcompanhante.getButtonFechar()) {
            this.telaBuscaAcompanhante.dispose();
        } else if (evento.getSource() == this.telaBuscaAcompanhante.getButtonFiltrar()) {
            if (this.telaBuscaAcompanhante.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaAcompanhante.getValorField().requestFocus();
            } else {
                if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    Acompanhante acompanhante = ServiceAcompanhante.ler(Integer.parseInt(this.telaBuscaAcompanhante.getValorField().getText()));
                    tabela.addRow(new Object[]{acompanhante.getId(), acompanhante.getNome(), acompanhante.getGrauParentesco(), acompanhante.getCpf(),
                        acompanhante.getFone(), acompanhante.getEmail(), acompanhante.getStatus()});
                } else if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("NOME")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler(this.telaBuscaAcompanhante.getValorField().getText(), "nome")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(),
                            objetoAtualDaLista.getCpf(), objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("GRAU PARENTESCO")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler(this.telaBuscaAcompanhante.getValorField().getText(), "grauParentesco")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(),
                            objetoAtualDaLista.getCpf(), objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("CPF")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler(this.telaBuscaAcompanhante.getValorField().getText(), "cpf")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(),
                            objetoAtualDaLista.getCpf(), objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("TELEFONE")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler(this.telaBuscaAcompanhante.getValorField().getText(), "fone")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(),
                            objetoAtualDaLista.getCpf(), objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("EMAIL")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler(this.telaBuscaAcompanhante.getValorField().getText(), "email")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(),
                            objetoAtualDaLista.getCpf(), objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
                    }
                } else if (this.telaBuscaAcompanhante.getFiltroComboBox().getSelectedItem().equals("STATUS")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAcompanhante.getJTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Acompanhante objetoAtualDaLista : service.ServiceAcompanhante.ler(this.telaBuscaAcompanhante.getValorField().getText(), "status")) {
                        tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNome(), objetoAtualDaLista.getGrauParentesco(),
                            objetoAtualDaLista.getCpf(), objetoAtualDaLista.getFone(), objetoAtualDaLista.getEmail(), objetoAtualDaLista.getStatus()});
                    }
                }
            }
        }
    }
}
