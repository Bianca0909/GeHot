
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bo.Usuario;
import view.TelaBuscaUsuario;

public class ControllerBuscaUsuario implements ActionListener {

    TelaBuscaUsuario telaBuscaUsuario;

    public ControllerBuscaUsuario(TelaBuscaUsuario telaBuscaUsuario) {
        this.telaBuscaUsuario = telaBuscaUsuario;

        this.telaBuscaUsuario.getCarregarButton().addActionListener(this);
        this.telaBuscaUsuario.getFecharButton().addActionListener(this);
        this.telaBuscaUsuario.getButtonFiltrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaBuscaUsuario.getCarregarButton()) {
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Usuario objetoAtualDaLista : service.ServiceUsuario.ler()) {
                tabela.addRow(new Object[]{
                    objetoAtualDaLista.getId(),
                    objetoAtualDaLista.getNome(),
                    objetoAtualDaLista.getCpfCnpj(),
                    objetoAtualDaLista.getEmail(),
                    objetoAtualDaLista.getLogin()
                });
            }

        } else if (evento.getSource() == this.telaBuscaUsuario.getFecharButton()) {
            this.telaBuscaUsuario.dispose();

        } else if (evento.getSource() == this.telaBuscaUsuario.getButtonFiltrar()) {
            if (this.telaBuscaUsuario.getValorField().getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "É obrigatório o preenchimento de algum caracter...");
                this.telaBuscaUsuario.getValorField().requestFocus();
            } else {
                DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaUsuario.getJTableDados().getModel();
                tabela.setRowCount(0);

                if (this.telaBuscaUsuario.getFiltroComboBox().getSelectedItem().equals("ID")) {
                    Usuario usuario = service.ServiceUsuario.ler(Integer.parseInt(this.telaBuscaUsuario.getValorField().getText()));
                    tabela.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getCpfCnpj(),
                        usuario.getEmail(),
                        usuario.getLogin()
                    });

                } else if (this.telaBuscaUsuario.getFiltroComboBox().getSelectedItem().equals("NOME")) {
                    for (Usuario objetoAtualDaLista : service.ServiceUsuario.ler(this.telaBuscaUsuario.getValorField().getText(), "nome")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(),
                            objetoAtualDaLista.getEmail(),
                            objetoAtualDaLista.getLogin()
                        });
                    }

                } else if (this.telaBuscaUsuario.getFiltroComboBox().getSelectedItem().equals("CPF/CNPJ")) {
                    for (Usuario objetoAtualDaLista : service.ServiceUsuario.ler(this.telaBuscaUsuario.getValorField().getText(), "cpfCnpj")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(),
                            objetoAtualDaLista.getEmail(),
                            objetoAtualDaLista.getLogin()
                        });
                    }

                } else if (this.telaBuscaUsuario.getFiltroComboBox().getSelectedItem().equals("EMAIL")) {
                    for (Usuario objetoAtualDaLista : service.ServiceUsuario.ler(this.telaBuscaUsuario.getValorField().getText(), "email")) {
                        tabela.addRow(new Object[]{
                            objetoAtualDaLista.getId(),
                            objetoAtualDaLista.getNome(),
                            objetoAtualDaLista.getCpfCnpj(),
                            objetoAtualDaLista.getEmail(),
                            objetoAtualDaLista.getLogin()
                        });
                    }
                }
            }
        }
    }
}
