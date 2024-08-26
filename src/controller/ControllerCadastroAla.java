package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Ala;
import utilities.Utilities;
import view.TelaCadastroAla;

public class ControllerCadastroAla implements ActionListener {

    TelaCadastroAla telaCadastroAla;
    
    public ControllerCadastroAla(TelaCadastroAla telaCadastroAla) {
        this.telaCadastroAla = telaCadastroAla;
        
        this.telaCadastroAla.getjButtonNovo().addActionListener(this);
        this.telaCadastroAla.getjButtonBuscar().addActionListener(this);
        this.telaCadastroAla.getjButtonGravar().addActionListener(this);
        this.telaCadastroAla.getjButtonCancelar().addActionListener(this);
        this.telaCadastroAla.getjButtonSair().addActionListener(this);

        utilities.Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
        utilities.Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroAla.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroAla.getjPanelDados());
            this.telaCadastroAla.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroAla.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroAla.getjButtonGravar()) {

            Ala ala = new Ala();
            ala.setId(model.bo.ClasseDadosGravacao.listaAla.size() + 1);
            ala.setDescricao(this.telaCadastroAla.getDescricaoField().getText());
            ala.setStatus(this.telaCadastroAla.getStatusComboBox().getSelectedItem() + "");

            model.bo.ClasseDadosGravacao.listaAla.add(ala);

            Utilities.ativaDesativa(false, this.telaCadastroAla.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroAla.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroAla.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaAla.toString());
        } else if (evento.getSource() == this.telaCadastroAla.getjButtonSair()) {
            this.telaCadastroAla.dispose();
        }
    }
    
}
