package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Ala;
import service.ServiceAla;
import view.TelaBuscaAla;

public class ControllerBuscaAla implements ActionListener {

    TelaBuscaAla telaBuscaAla;

    public ControllerBuscaAla(TelaBuscaAla telaBuscaAla) {
        this.telaBuscaAla = telaBuscaAla;

        this.telaBuscaAla.getjButtonCarregar().addActionListener(this);
        this.telaBuscaAla.getjButtonSair().addActionListener(this);
        this.telaBuscaAla.getjCBFiltro().addActionListener(this);
        this.telaBuscaAla.getjButtonFiltar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaAla.getjButtonCarregar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela antes de adicionar os novos dados

            for (Ala objetoAtualDaLista : ServiceAla.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getDescricao(),
                    objetoAtualDaLista.getStatus()
                });
            }
        } else if (evento.getSource() == this.telaBuscaAla.getjButtonSair()) {
            this.telaBuscaAla.dispose();

        } else if (evento.getSource() == this.telaBuscaAla.getjButtonFiltar()) {
            if (this.telaBuscaAla.getjTFFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaAla.getjTFFiltro().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaAla.getjTableDados().getModel();
                tabela.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

                String filtroSelecionado = this.telaBuscaAla.getjCBFiltro().getSelectedItem().toString();
                String valorFiltro = this.telaBuscaAla.getjTFFiltro().getText();

                if (filtroSelecionado.equals("ID")) {
                    Ala ala = ServiceAla.ler(Integer.parseInt(valorFiltro));
                    if (ala != null) {
                        tabela.addRow(new Object[]{
                            ala.getId(),
                            ala.getDescricao(),
                            ala.getStatus()
                        });
                    }
                } else {
                    String campoFiltro = "";
                    if (filtroSelecionado.equals("DESCRIÇÃO")) {
                        campoFiltro = "descricao";
                    } else if (filtroSelecionado.equals("STATUS")) {
                        campoFiltro = "status";
                    }

                    for (Ala ala : ServiceAla.ler(valorFiltro, campoFiltro)) {
                        tabela.addRow(new Object[]{
                            ala.getId(),
                            ala.getDescricao(),
                            ala.getStatus()
                        });
                    }
                }
            }
        }
    }
}
