package controller;

import view.TelaCadastroLaboratorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.ClasseDadosGravacao;
import model.bo.Laboratorio;
import utilities.Utilities;
import view.TelaBuscaLaboratorio;

public class ControllerCadastroLaboratorio implements ActionListener {

    TelaCadastroLaboratorio telaCadastroLaboratorio;
    public static int codigo;

    public ControllerCadastroLaboratorio(TelaCadastroLaboratorio telaCadastroLaboratorio) {
        this.telaCadastroLaboratorio = telaCadastroLaboratorio;

        this.telaCadastroLaboratorio.getjButtonNovo().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonBuscar().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonGravar().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonCancelar().addActionListener(this);
        this.telaCadastroLaboratorio.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroLaboratorio.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroLaboratorio.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaCadastroLaboratorio.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroLaboratorio.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroLaboratorio.getjPanelDados());
            this.telaCadastroLaboratorio.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroLaboratorio.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroLaboratorio.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroLaboratorio.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroLaboratorio.getjButtonGravar()) {

            Laboratorio laboratorio = new Laboratorio();
            laboratorio.setNomeFantasia(this.telaCadastroLaboratorio.getNomeField().getText());
            laboratorio.setContato(this.telaCadastroLaboratorio.getContatoField().getText());
            laboratorio.setStatus(this.telaCadastroLaboratorio.getjComboStatus().getSelectedItem() + "");

            if (this.telaCadastroLaboratorio.getIdField().getText().equals("")) {
                laboratorio.setId(model.bo.ClasseDadosGravacao.listaLaboratorio.size() + 1);
                model.bo.ClasseDadosGravacao.listaLaboratorio.add(laboratorio);
            } else {
                laboratorio.setId(Integer.parseInt(this.telaCadastroLaboratorio.getIdField().getText()));
                ClasseDadosGravacao.listaLaboratorio.set(codigo - 1, laboratorio);
            }

            Utilities.ativaDesativa(false, this.telaCadastroLaboratorio.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroLaboratorio.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroLaboratorio.getjButtonBuscar()) {
            codigo = 0;

            TelaBuscaLaboratorio telaBuscaLaboratorio = new TelaBuscaLaboratorio(null, true);
            ControllerBuscaLaboratorio controllerBuscaLaboratorio = new ControllerBuscaLaboratorio(telaBuscaLaboratorio);
            telaBuscaLaboratorio.setVisible(true);

            if (codigo != 0) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio = model.bo.ClasseDadosGravacao.listaLaboratorio.get(codigo - 1);

                utilities.Utilities.ativaDesativa(true, this.telaCadastroLaboratorio.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroLaboratorio.getjPanelDados());

                this.telaCadastroLaboratorio.getIdField().setText(laboratorio.getId() + "");
                this.telaCadastroLaboratorio.getNomeField().setText(laboratorio.getNomeFantasia());
                this.telaCadastroLaboratorio.getContatoField().setText(laboratorio.getContato());
                this.telaCadastroLaboratorio.getjComboStatus().setSelectedItem(laboratorio.getStatus());

                this.telaCadastroLaboratorio.getIdField().setEnabled(false);
                this.telaCadastroLaboratorio.getNomeField().requestFocus();

            }

        } else if (evento.getSource() == this.telaCadastroLaboratorio.getjButtonSair()) {
            this.telaCadastroLaboratorio.dispose();
        }
    }

}
