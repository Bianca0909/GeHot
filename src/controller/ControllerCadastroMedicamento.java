package controller;

import view.TelaCadastroMedicamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Laboratorio;
import model.bo.Medicamento;
import utilities.Utilities;

public class ControllerCadastroMedicamento implements ActionListener {

    TelaCadastroMedicamento telaCadastroMedicamento;

    public ControllerCadastroMedicamento(TelaCadastroMedicamento telaCadastroMedicamento) {
        this.telaCadastroMedicamento = telaCadastroMedicamento;

        this.telaCadastroMedicamento.getjButtonNovo().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonGravar().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMedicamento.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroMedicamento.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroMedicamento.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroMedicamento.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroMedicamento.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroMedicamento.getjPanelDados());
            this.telaCadastroMedicamento.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroMedicamento.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedicamento.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonGravar()) {

            Medicamento medicamento = new Medicamento();
            medicamento.setId(model.bo.ClasseDadosGravacao.listaMedicamento.size() + 1);
            medicamento.setDescricaoMedicamento(this.telaCadastroMedicamento.getDescricaoField().getText());
            medicamento.setPrincipioAtivo(this.telaCadastroMedicamento.getPrincipioAtivoField().getText());
            medicamento.setQtdMinima(Float.parseFloat(this.telaCadastroMedicamento.getQuantidadeMinimaField().getText()));
            medicamento.setStatus(this.telaCadastroMedicamento.getStatusComboBox().getSelectedItem() + "");
            medicamento.setCodigoBarras(this.telaCadastroMedicamento.getCodigoBarrasField().getText());
            medicamento.setLaboratorio((Laboratorio) this.telaCadastroMedicamento.getLaboratorioField().getSelectedItem());
            
            model.bo.ClasseDadosGravacao.listaMedicamento.add(medicamento);

            Utilities.ativaDesativa(false, this.telaCadastroMedicamento.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedicamento.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaMedicamento.toString());
        } else if (evento.getSource() == this.telaCadastroMedicamento.getjButtonSair()) {
            this.telaCadastroMedicamento.dispose();
        }

    }
}
