package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Quarto;
import utilities.Utilities;
import view.TelaCadastroQuarto;

public class ControllerCadastroQuarto implements ActionListener {

    TelaCadastroQuarto telaCadastroQuarto;
    
    public ControllerCadastroQuarto(TelaCadastroQuarto telaCadastroQuarto) {
        this.telaCadastroQuarto = telaCadastroQuarto;
        
        this.telaCadastroQuarto.getjButtonNovo().addActionListener(this);
        this.telaCadastroQuarto.getjButtonBuscar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonGravar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());
    }
      
    @Override
    public void actionPerformed(ActionEvent evento) {
         if (evento.getSource() == this.telaCadastroQuarto.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroQuarto.getjPanelDados());
            this.telaCadastroQuarto.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonGravar()) {

            Quarto quarto = new Quarto();
            quarto.setId(model.bo.ClasseDadosGravacao.listaQuarto.size() + 1);
            quarto.setDescricao(this.telaCadastroQuarto.getDescricaoField().getText());
            quarto.setStatus(this.telaCadastroQuarto.getStatusComboBox().getSelectedItem() + "");

            model.bo.ClasseDadosGravacao.listaQuarto.add(quarto);

            Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonBuscar()) {
            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaQuarto.toString());
        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonSair()) {
            this.telaCadastroQuarto.dispose();
        }
    }
    
}
