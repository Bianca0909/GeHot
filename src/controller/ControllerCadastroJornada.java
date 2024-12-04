/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFormattedTextField;
import model.bo.Acompanhante;
import model.bo.Jornada;
import utilities.Utilities;
import view.TelaCadastroJornadaTrabalho;

public class ControllerCadastroJornada implements ActionListener {

    TelaCadastroJornadaTrabalho telaCadastroJornadaTrabalho;
    public static int codigo;

    public ControllerCadastroJornada(TelaCadastroJornadaTrabalho telaCadastroJornadaTrabalho) {
        this.telaCadastroJornadaTrabalho = telaCadastroJornadaTrabalho;

        this.telaCadastroJornadaTrabalho.getjButtonNovo().addActionListener(this);
        this.telaCadastroJornadaTrabalho.getjButtonBuscar().addActionListener(this);
        this.telaCadastroJornadaTrabalho.getjButtonGravar().addActionListener(this);
        this.telaCadastroJornadaTrabalho.getjButtonCancelar().addActionListener(this);
        this.telaCadastroJornadaTrabalho.getjButtonSair().addActionListener(this);

        Utilities.ativaDesativa(false, this.telaCadastroJornadaTrabalho.getjPanelBotoes());
        Utilities.limpaComponentes(false, this.telaCadastroJornadaTrabalho.getjPanelDados());
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == this.telaCadastroJornadaTrabalho.getjButtonNovo()) {
            Utilities.ativaDesativa(true, this.telaCadastroJornadaTrabalho.getjPanelBotoes());
            Utilities.limpaComponentes(true, this.telaCadastroJornadaTrabalho.getjPanelDados());
            this.telaCadastroJornadaTrabalho.getIdField().setEnabled(false);

        } else if (evento.getSource() == this.telaCadastroJornadaTrabalho.getjButtonCancelar()) {
            Utilities.ativaDesativa(false, this.telaCadastroJornadaTrabalho.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroJornadaTrabalho.getjPanelDados());

        } else if (evento.getSource() == this.telaCadastroJornadaTrabalho.getjButtonGravar()) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            JFormattedTextField formattedTextField = new JFormattedTextField();

//            Jornada jornada = new Jornada();
//            jornada.setDataInicial(LocalDate.parse(this.telaCadastroJornadaTrabalho.getDataInicialField(), formatter));
//            jornada.setDataFinal(this.telaCadastroJornadaTrabalho.getDataFinalField());
//            jornada.setCargaHoraria(this.telaCadastroJornadaTrabalho.getCargaHorariaField());
//            jornada.setProfissionalId(null);

//            if (this.telaCadastroJornadaTrabalho.getIdField().getText().equals("")) {
//                service.ServiceJornada.adicionar(jornada);
//            } else {
//                jornada.setId(Integer.parseInt(this.telaCadastroJornadaTrabalho.getIdField().getText()));
//                service.ServiceJornada.atualizar(jornada);
//            }

            Utilities.ativaDesativa(false, this.telaCadastroJornadaTrabalho.getjPanelBotoes());
            Utilities.limpaComponentes(false, this.telaCadastroJornadaTrabalho.getjPanelDados());

        }

    }

}
