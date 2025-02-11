package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Ala;
import model.bo.Quarto;
import utilities.Utilities;
import view.TelaBuscaQuarto;
import view.TelaCadastroQuarto;

public class ControllerCadastroQuarto implements ActionListener {

    TelaCadastroQuarto telaCadastroQuarto;
    public static int codigo;
    
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
            
            Ala alaSelecionada = (Ala) this.telaCadastroQuarto.getAlaComboBox().getSelectedItem();
            quarto.setAla_id(alaSelecionada.getId());
            
            if (this.telaCadastroQuarto.getIdField().getText().equals("")) {
                service.ServiceQuarto.adicionar(quarto);
            } else {
                quarto.setId(Integer.parseInt(this.telaCadastroQuarto.getIdField().getText()));
                service.ServiceQuarto.atualizar(quarto);
            }

            Utilities.ativaDesativa(false, this.telaCadastroQuarto.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroQuarto.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaQuarto telaBuscaQuarto = new TelaBuscaQuarto(null, true);
            ControllerBuscaQuarto controllerBuscaQuarto = new ControllerBuscaQuarto(telaBuscaQuarto);
            telaBuscaQuarto.setVisible(true);

            if (codigo != 0) {

                Quarto quarto = new Quarto();
                quarto = service.ServiceQuarto.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaCadastroQuarto.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroQuarto.getjPanelDados());

                this.telaCadastroQuarto.getIdField().setText(quarto.getId() + "");
                this.telaCadastroQuarto.getDescricaoField().setText(quarto.getDescricao());
                this.telaCadastroQuarto.getStatusComboBox().setSelectedItem(quarto.getStatus());
                
                this.telaCadastroQuarto.getIdField().setEnabled(false);
                this.telaCadastroQuarto.getDescricaoField().requestFocus();

            }

        } else if (evento.getSource() == this.telaCadastroQuarto.getjButtonSair()) {
            this.telaCadastroQuarto.dispose();

        }
    }
    
}
