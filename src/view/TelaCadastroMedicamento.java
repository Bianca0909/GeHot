/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ControllerCadastroLaboratorio;
import enums.StatusCadastroEnum;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Bianca
 */
public class TelaCadastroMedicamento extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastroMedicamento1
     */
    public TelaCadastroMedicamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadComboBox();
    }

    public JTextField getCodigoBarrasField() {
        return codigoBarrasField;
    }

    public void setCodigoBarrasField(JTextField codigoBarrasField) {
        this.codigoBarrasField = codigoBarrasField;
    }

    public JTextField getDescricaoField() {
        return descricaoField;
    }

    public void setDescricaoField(JTextField descricaoField) {
        this.descricaoField = descricaoField;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public void setjButtonBuscar(JButton jButtonBuscar) {
        this.jButtonBuscar = jButtonBuscar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public void setjButtonCancelar(JButton jButtonCancelar) {
        this.jButtonCancelar = jButtonCancelar;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public void setjButtonGravar(JButton jButtonGravar) {
        this.jButtonGravar = jButtonGravar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public void setjButtonNovo(JButton jButtonNovo) {
        this.jButtonNovo = jButtonNovo;
    }

    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(JButton jButtonSair) {
        this.jButtonSair = jButtonSair;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return jLabel9;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.jLabel9 = jLabel9;
    }

    public JLabel getjLabelTitulo() {
        return jLabelTitulo;
    }

    public void setjLabelTitulo(JLabel jLabelTitulo) {
        this.jLabelTitulo = jLabelTitulo;
    }

    public JPanel getjPanelBotoes() {
        return jPanelBotoes;
    }

    public void setjPanelBotoes(JPanel jPanelBotoes) {
        this.jPanelBotoes = jPanelBotoes;
    }

    public JPanel getjPanelDados() {
        return jPanelDados;
    }

    public void setjPanelDados(JPanel jPanelDados) {
        this.jPanelDados = jPanelDados;
    }

    public JPanel getjPaneltitulo() {
        return jPaneltitulo;
    }

    public void setjPaneltitulo(JPanel jPaneltitulo) {
        this.jPaneltitulo = jPaneltitulo;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JButton getJbuttonAddLaboratorio() {
        return jbuttonAddLaboratorio;
    }

    public void setJbuttonAddLaboratorio(JButton jbuttonAddLaboratorio) {
        this.jbuttonAddLaboratorio = jbuttonAddLaboratorio;
    }

    public JComboBox<String> getLaboratorioField() {
        return laboratorioField;
    }

    public void setLaboratorioField(JComboBox<String> laboratorioField) {
        this.laboratorioField = laboratorioField;
    }

    public JTextArea getObservacaoField() {
        return observacaoField;
    }

    public void setObservacaoField(JTextArea observacaoField) {
        this.observacaoField = observacaoField;
    }

    public JTextField getPrincipioAtivoField() {
        return principioAtivoField;
    }

    public void setPrincipioAtivoField(JTextField principioAtivoField) {
        this.principioAtivoField = principioAtivoField;
    }

    public JTextField getQuantidadeMinimaField() {
        return quantidadeMinimaField;
    }

    public void setQuantidadeMinimaField(JTextField quantidadeMinimaField) {
        this.quantidadeMinimaField = quantidadeMinimaField;
    }

    public JComboBox<StatusCadastroEnum> getStatusComboBox() {
        return statusComboBox;
    }

    public void setStatusComboBox(JComboBox<StatusCadastroEnum> statusComboBox) {
        this.statusComboBox = statusComboBox;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaneltitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        descricaoField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        principioAtivoField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        laboratorioField = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        codigoBarrasField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        observacaoField = new javax.swing.JTextArea();
        jbuttonAddLaboratorio = new javax.swing.JButton();
        quantidadeMinimaField = new javax.swing.JTextField();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPaneltitulo.setBackground(new java.awt.Color(51, 153, 255));
        jPaneltitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Medicamento");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPaneltituloLayout = new javax.swing.GroupLayout(jPaneltitulo);
        jPaneltitulo.setLayout(jPaneltituloLayout);
        jPaneltituloLayout.setHorizontalGroup(
            jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneltituloLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPaneltituloLayout.setVerticalGroup(
            jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneltituloLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPaneltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 890, 40));

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Id");

        idField.setEditable(false);
        idField.setEnabled(false);

        jLabel3.setText("Status");

        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição");

        jLabel8.setText("Princípio ativo");

        jLabel9.setText("Quantidade mínima");

        jLabel2.setText("Laboratório");

        laboratorioField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laboratorioFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Código de barras");

        jLabel6.setText("Observação");

        observacaoField.setColumns(20);
        observacaoField.setRows(5);
        jScrollPane1.setViewportView(observacaoField);

        jbuttonAddLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Create.png"))); // NOI18N
        jbuttonAddLaboratorio.setActionCommand("1");
        jbuttonAddLaboratorio.setPreferredSize(new java.awt.Dimension(100, 30));
        jbuttonAddLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonAddLaboratorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descricaoField, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(codigoBarrasField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(388, 388, 388)
                            .addComponent(jLabel9))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(laboratorioField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jbuttonAddLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(principioAtivoField, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(quantidadeMinimaField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoBarrasField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(descricaoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(2, 2, 2)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(principioAtivoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidadeMinimaField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(laboratorioField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonAddLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 890, 380));

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Create.png"))); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.setToolTipText("");
        jButtonNovo.setActionCommand("1");
        jButtonNovo.setEnabled(false);
        jButtonNovo.setMinimumSize(new java.awt.Dimension(67, 25));
        jButtonNovo.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonNovo);

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancel.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("0");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonCancelar);

        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Download.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setActionCommand("0");
        jButtonGravar.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonGravar);

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("1");
        jButtonBuscar.setEnabled(false);
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanelBotoes.add(jButtonBuscar);

        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("1");
        jButtonSair.setPreferredSize(new java.awt.Dimension(100, 30));
        jButtonSair.setVerifyInputWhenFocusTarget(false);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonSair);

        getContentPane().add(jPanelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 890, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonAddLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonAddLaboratorioActionPerformed
       TelaCadastroLaboratorio telaCadastroLaboratorio = new TelaCadastroLaboratorio(null, true);
       ControllerCadastroLaboratorio controllerCadastroLaboratorio = new ControllerCadastroLaboratorio(telaCadastroLaboratorio);
       telaCadastroLaboratorio.setVisible(true);
    }//GEN-LAST:event_jbuttonAddLaboratorioActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
//        utilities.Utilities.ativaDesativa(true, jPanelBotoes);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
//        utilities.Utilities.ativaDesativa(false, jPanelBotoes);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
//        utilities.Utilities.ativaDesativa(false, jPanelBotoes);
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
//        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void laboratorioFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laboratorioFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laboratorioFieldActionPerformed

    private void loadComboBox() {
        statusComboBox.setModel(new DefaultComboBoxModel<>(StatusCadastroEnum.values()));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroMedicamento dialog = new TelaCadastroMedicamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoBarrasField;
    private javax.swing.JTextField descricaoField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPaneltitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbuttonAddLaboratorio;
    private javax.swing.JComboBox<String> laboratorioField;
    private javax.swing.JTextArea observacaoField;
    private javax.swing.JTextField principioAtivoField;
    private javax.swing.JTextField quantidadeMinimaField;
    private javax.swing.JComboBox<StatusCadastroEnum> statusComboBox;
    // End of variables declaration//GEN-END:variables
}
