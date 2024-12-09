
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Quarto;
import view.TelaBuscaQuarto;

public class ControllerBuscaQuarto implements ActionListener {

    TelaBuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(TelaBuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;

        this.telaBuscaQuarto.getCarregarButton().addActionListener(this);
        this.telaBuscaQuarto.getFecharButton().addActionListener(this);
        this.telaBuscaQuarto.getButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaBuscaQuarto.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Quarto objetoAtualDaLista : service.ServiceQuarto.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getDescricao(),
                    objetoAtualDaLista.getStatus(),
                    objetoAtualDaLista.getAla().getDescricao()
                });
            }
        } else if (evento.getSource() == this.telaBuscaQuarto.getFecharButton()) {
            this.telaBuscaQuarto.dispose();

        } else if (evento.getSource() == this.telaBuscaQuarto.getButtonFiltrar()) {
            if (this.telaBuscaQuarto.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter....");
                this.telaBuscaQuarto.getValorField().requestFocus();

            } else {
                if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                    tabela.setRowCount(0);

                    Quarto quarto = service.ServiceQuarto.ler(Integer.parseInt(this.telaBuscaQuarto.getValorField().getText()));
                    tabela.addRow(new Object[]{quarto.getId(), quarto.getDescricao(), quarto.getStatus(), quarto.getAla().getDescricao()});

                } else if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("DESCRIÇÃO")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Quarto objetoAtualDaLista : service.ServiceQuarto.ler(this.telaBuscaQuarto.getValorField().getText(), "descricao")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getDescricao(),
                            objetoAtualDaLista.getStatus(),
                            objetoAtualDaLista.getAla().getDescricao()
                        });
                    }

                } else if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("STATUS")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Quarto objetoAtualDaLista : service.ServiceQuarto.ler(this.telaBuscaQuarto.getValorField().getText(), "status")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getDescricao(),
                            objetoAtualDaLista.getStatus(),
                            objetoAtualDaLista.getAla().getDescricao()
                        });
                    }

                } else if (this.telaBuscaQuarto.getFiltroComboBox().getSelectedItem().equals("ALA")) {
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getJTableDados().getModel();
                    tabela.setRowCount(0);

                    for (Quarto objetoAtualDaLista : service.ServiceQuarto.ler(this.telaBuscaQuarto.getValorField().getText(), "ala")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getDescricao(),
                            objetoAtualDaLista.getStatus(),
                            objetoAtualDaLista.getAla().getDescricao()
                        });
                    }
                }
            }
        }
    }
}

