package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.bo.Laboratorio;
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

            ControllerCadastroLaboratorio.codigo = (int) this.telaBuscaLaboratorio.getJTableDados().
                    getValueAt(this.telaBuscaLaboratorio.getJTableDados().getSelectedRow(), 0);

            this.telaBuscaLaboratorio.dispose();

        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFiltrar()) {

//           if(this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedIndex() == 0){
//           }else if(this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedIndex() == 1){
//           }else if(this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedIndex() == 2){
//           }else if(this.telaBuscaLaboratorio.getFiltroComboBox().getSelectedIndex() == 3){
//           }
            
               
            DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaLaboratorio.getJTableDados().getModel();
            tabela.setRowCount(0);

            for (Laboratorio objetoAtualDaLista : model.bo.ClasseDadosGravacao.listaLaboratorio) {
                tabela.addRow(new Object[]{objetoAtualDaLista.getId(), objetoAtualDaLista.getNomeFantasia(),
                    objetoAtualDaLista.getContato(), objetoAtualDaLista.getStatus()});
            }

        } else if (evento.getSource() == this.telaBuscaLaboratorio.getButtonFechar()) {
            this.telaBuscaLaboratorio.dispose();
        }
    }
}
