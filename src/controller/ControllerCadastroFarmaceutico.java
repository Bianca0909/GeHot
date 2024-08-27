package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Farmaceutico;
import utilities.Utilities;
import view.TelaCadastroFarmaceutico;

public class ControllerCadastroFarmaceutico implements ActionListener {

    TelaCadastroFarmaceutico telaCadastroFarmaceutico;
    
    public ControllerCadastroFarmaceutico(TelaCadastroFarmaceutico telaCadastroFarmaceutico) {
        this.telaCadastroFarmaceutico = telaCadastroFarmaceutico;

        this.telaCadastroFarmaceutico.getjButtonNovo().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonGravar().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFarmaceutico.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroFarmaceutico.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroFarmaceutico.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
         if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroFarmaceutico.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroFarmaceutico.getjPanelDados());
            this.telaCadastroFarmaceutico.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroFarmaceutico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFarmaceutico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonGravar()) {

            Farmaceutico farmaceutico = new Farmaceutico();
            farmaceutico.setId(model.bo.ClasseDadosGravacao.listaFarmaceutico.size() + 1);
            farmaceutico.setNome(this.telaCadastroFarmaceutico.getNomeField().getText());
            farmaceutico.setDataCadastro(this.telaCadastroFarmaceutico.getDataCadastroField().getText());
            farmaceutico.setNomeSocial(this.telaCadastroFarmaceutico.getNomeSocialField().getText());
            farmaceutico.setCpfCnpj(this.telaCadastroFarmaceutico.getCpfField().getText());
            farmaceutico.setRgInscricaoEstadual(this.telaCadastroFarmaceutico.getRgField().getText());
            farmaceutico.setFone1(this.telaCadastroFarmaceutico.getFone1Field().getText());
            farmaceutico.setFone2(this.telaCadastroFarmaceutico.getFone2Field().getText());
            farmaceutico.setEmail(this.telaCadastroFarmaceutico.getEmailField().getText());
            farmaceutico.setCep(this.telaCadastroFarmaceutico.getCepField().getText());
            farmaceutico.setCidade(this.telaCadastroFarmaceutico.getCidadeField().getText());
            farmaceutico.setBairro(this.telaCadastroFarmaceutico.getBairroField().getText());
            farmaceutico.setLogradouro(this.telaCadastroFarmaceutico.getLogradouroField().getText());
            farmaceutico.setComplemento(this.telaCadastroFarmaceutico.getComplementoField().getText());
            
            model.bo.ClasseDadosGravacao.listaFarmaceutico.add(farmaceutico);

            Utilities.ativaDesativa(false, this.telaCadastroFarmaceutico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFarmaceutico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaFarmaceutico.toString());
        } else if (evento.getSource() == this.telaCadastroFarmaceutico.getjButtonSair()) {
            this.telaCadastroFarmaceutico.dispose();
        }
    }

}
