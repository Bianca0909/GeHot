package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.bo.Leito;
import model.bo.Quarto;
import utilities.Utilities;
import view.TelaBuscaLeito;
import view.TelaCadastroLeito;

public class ControllerTelaCadastroLeito implements ActionListener {
    
    public static int codigo;

    TelaCadastroLeito telaCadastroLeito;
    
    public ControllerTelaCadastroLeito(TelaCadastroLeito telaCadastroLeito) {
        this.telaCadastroLeito = telaCadastroLeito;
        
        this.telaCadastroLeito.getjButtonNovo().addActionListener(this);
        this.telaCadastroLeito.getjButtonBuscar().addActionListener(this);
        this.telaCadastroLeito.getjButtonGravar().addActionListener(this);
        this.telaCadastroLeito.getjButtonCancelar().addActionListener(this);
        this.telaCadastroLeito.getjButtonSair().addActionListener(this);
        
        Utilities.ativaDesativa(false, this.telaCadastroLeito.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroLeito.getjPanelDados());
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroLeito.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroLeito.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroLeito.getjPanelDados());
            this.telaCadastroLeito.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroLeito.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroLeito.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonGravar()) {

            Leito leito = new Leito();
            leito.setId(model.bo.ClasseDadosGravacao.listaLeito.size() + 1);
            
            leito.setDescricao(this.telaCadastroLeito.getDescricaoField().getText());
            leito.setStatus(this.telaCadastroLeito.getStatusComboBox().getSelectedItem() + "");
            
            if (this.telaCadastroLeito.getIdField().getText().equals("")){
                service.ServiceLeito.adicionar(leito);
            } else {
                leito.setId(Integer.parseInt(this.telaCadastroLeito.getIdField().getText()));
                service.ServiceLeito.atualizar(leito);
            }
            
            Utilities.ativaDesativa(false, this.telaCadastroLeito.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroLeito.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonBuscar()) {
            codigo = 0;
            TelaBuscaLeito telaBuscaLeito = new TelaBuscaLeito(null, true);
            ControllerBuscaLeito controllerBuscaLeito = new ControllerBuscaLeito(telaBuscaLeito);
            telaBuscaLeito.setVisible(true);
            
            if (codigo != 0) {
                
                Leito leito = new Leito();
                leito = service.ServiceLeito.ler(codigo);
                
                utilities.Utilities.ativaDesativa(true, this.telaCadastroLeito.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroLeito.getjPanelDados());
                
                this.telaCadastroLeito.getIdField().setText(leito.getId() + "");
                this.telaCadastroLeito.getDescricaoField().setText(leito.getDescricao());
                this.telaCadastroLeito.getStatusComboBox().setSelectedItem(leito.getStatus());
                
                this.telaCadastroLeito.getIdField().setEnabled(false);
                this.telaCadastroLeito.getDescricaoField().requestFocus();
                


            }
               
        } else if (evento.getSource() == this.telaCadastroLeito.getjButtonSair()) {
                this.telaCadastroLeito.dispose();

        }
    }
    
 }
