package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Fornecedor;
import utilities.Utilities;
import view.TelaCadastroFornecedor;

public class ControllerCadastroFornecedor implements ActionListener {

    TelaCadastroFornecedor telaCadastroFornecedor;
    
    public ControllerCadastroFornecedor(TelaCadastroFornecedor telaCadastroFornecedor) {
        this.telaCadastroFornecedor = telaCadastroFornecedor;

        this.telaCadastroFornecedor.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedor.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanelDados());
    }
      
    @Override
    public void actionPerformed(ActionEvent evento) {
         if (evento.getSource() == this.telaCadastroFornecedor.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroFornecedor.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroFornecedor.getjPanelDados());
            this.telaCadastroFornecedor.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonGravar()) {

            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(model.bo.ClasseDadosGravacao.listaFornecedor.size() + 1);
            fornecedor.setNome(this.telaCadastroFornecedor.getNomeField().getText());
            fornecedor.setNomeFantasia(this.telaCadastroFornecedor.getNomeFantasiaField().getText());
            fornecedor.setDataCadastro(this.telaCadastroFornecedor.getDataCadastroField().getText());
            fornecedor.setCpfCnpj(this.telaCadastroFornecedor.getCpfCnpjField().getText());
            fornecedor.setRgInscricaoEstadual(this.telaCadastroFornecedor.getRgInscricaoEstadualField().getText());
            fornecedor.setFone1(this.telaCadastroFornecedor.getFone1Field().getText());
            fornecedor.setFone2(this.telaCadastroFornecedor.getFone2Field().getText());
            fornecedor.setEmail(this.telaCadastroFornecedor.getEmailField().getText());
            fornecedor.setCep(this.telaCadastroFornecedor.getCepField().getText());
            fornecedor.setCidade(this.telaCadastroFornecedor.getCidadeField().getText());
            fornecedor.setBairro(this.telaCadastroFornecedor.getBairroField().getText());
            fornecedor.setLogradouro(this.telaCadastroFornecedor.getLogradouroField().getText());
            fornecedor.setComplemento(this.telaCadastroFornecedor.getComplementoField().getText());
            
            model.bo.ClasseDadosGravacao.listaFornecedor.add(fornecedor);

            Utilities.ativaDesativa(false, this.telaCadastroFornecedor.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroFornecedor.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonBuscar()) {

            JOptionPane.showMessageDialog(null, model.bo.ClasseDadosGravacao.listaFornecedor.toString());
        } else if (evento.getSource() == this.telaCadastroFornecedor.getjButtonSair()) {
            this.telaCadastroFornecedor.dispose();
        }
    }
    
}
