package controller;

import static controller.ControllerCadastroAcompanhante.codigo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Acompanhante;
import model.bo.Medico;
import utilities.Utilities;
import view.TelaBuscaAcompanhante;
import view.TelaBuscaMedico;
import view.TelaCadastroMedico;

public class ControllerCadastroMedico implements ActionListener {

    TelaCadastroMedico telaCadastroMedico;

    public ControllerCadastroMedico(TelaCadastroMedico telaCadastroMedico) {
        this.telaCadastroMedico = telaCadastroMedico;

        this.telaCadastroMedico.getjButtonNovo().addActionListener(this);
        this.telaCadastroMedico.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMedico.getjButtonGravar().addActionListener(this);
        this.telaCadastroMedico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMedico.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroMedico.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroMedico.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == this.telaCadastroMedico.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroMedico.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroMedico.getjPanelDados());
            this.telaCadastroMedico.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroMedico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonGravar()) {

            Medico medico = new Medico();
            medico.setNome(this.telaCadastroMedico.getNomeField().getText());
            medico.setFone1(this.telaCadastroMedico.getFone1Field().getText());
            medico.setFone2(this.telaCadastroMedico.getFone2Field().getText());
            medico.setDataCadastro(this.telaCadastroMedico.getDataCadastroField().getText());
            medico.setNomeSocial(this.telaCadastroMedico.getNomeSocialField().getText());
            medico.setCpfCnpj(this.telaCadastroMedico.getCpfCnpjField().getText());
            medico.setRgInscricaoEstadual(this.telaCadastroMedico.getRgField().getText());
            medico.setEmail(this.telaCadastroMedico.getEmailField().getText());
            medico.setCep(this.telaCadastroMedico.getCepField().getText());
            medico.setCidade(this.telaCadastroMedico.getCidadeField().getText());
            medico.setBairro(this.telaCadastroMedico.getBairroField().getText());
            medico.setLogradouro(this.telaCadastroMedico.getLogradouroField().getText());
            medico.setComplemento(this.telaCadastroMedico.getComplementoField().getText());
            medico.setCrm(this.telaCadastroMedico.getCrmField().getText());
            medico.setSenha(this.telaCadastroMedico.getSenhaField().getText());
            medico.setLogin(this.telaCadastroMedico.getLoginField().getText());
            medico.setNomeSocial(this.telaCadastroMedico.getNomeSocialField().getText());

            if (this.telaCadastroMedico.getIdField().getText().equals("")) {
                service.ServiceMedico.adicionar(medico);
            } else {
                medico.setId(Integer.parseInt(this.telaCadastroMedico.getIdField().getText()));
                service.ServiceMedico.atualizar(medico);
            }

            Utilities.ativaDesativa(false, this.telaCadastroMedico.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroMedico.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonBuscar()) {
            codigo = 0;

            TelaBuscaMedico telaBuscaMedico = new TelaBuscaMedico(null, true);
            ControllerBuscaMedico controllerBuscaMedico = new ControllerBuscaMedico(telaBuscaMedico);
            telaBuscaMedico.setVisible(true);

            if (codigo != 0) {
                Medico medico = new Medico();
                medico = service.ServiceMedico.ler(codigo);

                utilities.Utilities.ativaDesativa(true, this.telaCadastroMedico.getjPanelBotoes());
                utilities.Utilities.limpaComponentes(true, this.telaCadastroMedico.getjPanelDados());

                this.telaCadastroMedico.getIdField().setText(medico.getId() + "");
                this.telaCadastroMedico.getNomeField().setText(medico.getNome());
                this.telaCadastroMedico.getNomeSocialField().setText(medico.getNomeSocial());
                this.telaCadastroMedico.getFone1Field().setText(medico.getFone1());
                this.telaCadastroMedico.getFone2Field().setText(medico.getFone2());
                this.telaCadastroMedico.getEmailField().setText(medico.getEmail());
                this.telaCadastroMedico.getCpfCnpjField().setText(medico.getCpfCnpj());
                this.telaCadastroMedico.getRgField().setText(medico.getRgInscricaoEstadual());
                this.telaCadastroMedico.getDataCadastroField().setText(medico.getDataCadastro());
                this.telaCadastroMedico.getCepField().setText(medico.getCep());
                this.telaCadastroMedico.getCidadeField().setText(medico.getCidade());
                this.telaCadastroMedico.getBairroField().setText(medico.getBairro());
                this.telaCadastroMedico.getLogradouroField().setText(medico.getLogradouro());
                this.telaCadastroMedico.getComplementoField().setText(medico.getComplemento());
                this.telaCadastroMedico.getCrmField().setText(medico.getCrm());
                this.telaCadastroMedico.getLoginField().setText(medico.getLogin());
                this.telaCadastroMedico.getSenhaField().setText(medico.getSenha());

                this.telaCadastroMedico.getIdField().setEnabled(false);
                this.telaCadastroMedico.getNomeField().requestFocus();
            }
        } else if (evento.getSource() == this.telaCadastroMedico.getjButtonSair()) {
            this.telaCadastroMedico.dispose();
        }
    }

}
