package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Enfermeiro;
import service.ServiceEnfermeiro;
import view.TelaBuscaEnfermeiro;

public class ControllerBuscaEnfermeiro implements ActionListener {

    TelaBuscaEnfermeiro telaBuscaEnfermeiro;

    public ControllerBuscaEnfermeiro(TelaBuscaEnfermeiro telaBuscaEnfermeiro) {
        this.telaBuscaEnfermeiro = telaBuscaEnfermeiro;

        this.telaBuscaEnfermeiro.getjButtonCarregar().addActionListener(this);
        this.telaBuscaEnfermeiro.getjButtonSair().addActionListener(this);
        this.telaBuscaEnfermeiro.getjCBFiltro().addActionListener(this);
        this.telaBuscaEnfermeiro.getjButtonFiltar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonCarregar()) {
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getjTableDados().getModel();
        tabela.setRowCount(0); // Limpa a tabela antes de adicionar os novos dados

        for (Enfermeiro objetoAtualDaLista : service.ServiceEnfermeiro.ler()) {
            tabela.addRow(new Object[]{
            objetoAtualDaLista.getId(), 
            objetoAtualDaLista.getNome(), 
            objetoAtualDaLista.getCre(),
            objetoAtualDaLista.getCpfCnpj(), 
            objetoAtualDaLista.getFone1(), 
            objetoAtualDaLista.getEmail(),
            objetoAtualDaLista.getNomeSocial()
        });
        }
    } else if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonSair()) {
            this.telaBuscaEnfermeiro.dispose();

        } else if (evento.getSource() == this.telaBuscaEnfermeiro.getjButtonFiltar()) {
            if (this.telaBuscaEnfermeiro.getjTFFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaEnfermeiro.getjTFFiltro().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaEnfermeiro.getjTableDados().getModel();
                tabela.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

                String filtroSelecionado = this.telaBuscaEnfermeiro.getjCBFiltro().getSelectedItem().toString();
                String valorFiltro = this.telaBuscaEnfermeiro.getjTFFiltro().getText();

                if (filtroSelecionado.equals("ID")) {
                    Enfermeiro enfermeiro = ServiceEnfermeiro.ler(Integer.parseInt(valorFiltro));
                    if (enfermeiro != null) {
                        tabela.addRow(new Object[]{
                            enfermeiro.getId(), enfermeiro.getNome(), enfermeiro.getCre(),
                            enfermeiro.getLogin(), enfermeiro.getNomeSocial(), enfermeiro.getCpfCnpj()
                        });
                    }
                } else {
                    String campoFiltro = "";
                    if (filtroSelecionado.equals("NOME")) {
                        campoFiltro = "nome";
                    } else if (filtroSelecionado.equals("CRE")) {
                        campoFiltro = "cre";
                    } else if (filtroSelecionado.equals("LOGIN")) {
                        campoFiltro = "login";
                    }

                    for (Enfermeiro enfermeiro : ServiceEnfermeiro.ler(valorFiltro, campoFiltro)) {
                        tabela.addRow(new Object[]{
                            enfermeiro.getId(), enfermeiro.getNome(), enfermeiro.getCre(),
                            enfermeiro.getLogin(), enfermeiro.getNomeSocial(), enfermeiro.getCpfCnpj()
                        });
                    }
                }
            }
        }
    }
}
