package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Fornecedor;
import service.ServiceFornecedor;
import view.TelaBuscaFornecedor;

public class ControllerBuscaFornecedor implements ActionListener {

    TelaBuscaFornecedor telaBuscaFornecedor;

    public ControllerBuscaFornecedor(TelaBuscaFornecedor telaBuscaFornecedor) {
        this.telaBuscaFornecedor = telaBuscaFornecedor;

        this.telaBuscaFornecedor.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonSair().addActionListener(this);
        this.telaBuscaFornecedor.getjCBFiltro().addActionListener(this);
        this.telaBuscaFornecedor.getjButtonFiltar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaFornecedor.getjButtonCarregar()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
            tabela.setRowCount(0); // Limpa a tabela antes de adicionar os novos dados

            for (Fornecedor objetoAtualDaLista : ServiceFornecedor.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getNome(),
                    objetoAtualDaLista.getCpfCnpj(),
                    objetoAtualDaLista.getFone1(),
                    objetoAtualDaLista.getEmail(),
                    objetoAtualDaLista.getCidade(),
                    objetoAtualDaLista.getNomeFantasia()
                });
            }

        } else if (evento.getSource() == this.telaBuscaFornecedor.getjButtonSair()) {
            this.telaBuscaFornecedor.dispose();

        } else if (evento.getSource() == this.telaBuscaFornecedor.getjButtonFiltar()) {
            if (this.telaBuscaFornecedor.getjTFFiltro().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaFornecedor.getjTFFiltro().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFornecedor.getjTableDados().getModel();
                tabela.setRowCount(0); // Limpa a tabela antes de adicionar novos dados

                String filtroSelecionado = this.telaBuscaFornecedor.getjCBFiltro().getSelectedItem().toString();
                String valorFiltro = this.telaBuscaFornecedor.getjTFFiltro().getText();

                if (filtroSelecionado.equals("ID")) {
                    Fornecedor fornecedor = ServiceFornecedor.ler(Integer.parseInt(valorFiltro));
                    if (fornecedor != null) {
                        tabela.addRow(new Object[]{
                            fornecedor.getId(),
                            fornecedor.getNome(),
                            fornecedor.getCpfCnpj(),
                            fornecedor.getFone1(),
                            fornecedor.getEmail(),
                            fornecedor.getCidade(),
                            fornecedor.getNomeFantasia()
                        });
                    }
                } else {
                    String campoFiltro = "";
                    if (filtroSelecionado.equals("NOME")) {
                        campoFiltro = "nome";
                    } else if (filtroSelecionado.equals("CIDADE")) {
                        campoFiltro = "cidade";
                    } else if (filtroSelecionado.equals("NOME FANTASIA")) {
                        campoFiltro = "nomeFantasia";
                    }

                    for (Fornecedor fornecedor : ServiceFornecedor.ler(valorFiltro, campoFiltro)) {
                        tabela.addRow(new Object[]{
                            fornecedor.getId(),
                            fornecedor.getNome(),
                            fornecedor.getCpfCnpj(),
                            fornecedor.getFone1(),
                            fornecedor.getEmail(),
                            fornecedor.getCidade(),
                            fornecedor.getNomeFantasia()
                        });
                    }
                }
            }
        }
    }
}
