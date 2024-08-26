package view;

import enums.StatusCadastroEnum;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.bo.ClasseDadosGravacao;
import model.bo.Quarto;

public class TelaCadastroLeito extends javax.swing.JDialog {

    public TelaCadastroLeito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadComboBox();
    }

    public JTextField getDescricaoField() {
        return descricaoField;
    }

    public void setDescricaoField(JTextField descricaoField) {
        this.descricaoField = descricaoField;
    }

    public JLabel getDescricaoLabel() {
        return descricaoLabel;
    }

    public void setDescricaoLabel(JLabel descricaoLabel) {
        this.descricaoLabel = descricaoLabel;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
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

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public void setjTextArea1(JTextArea jTextArea1) {
        this.jTextArea1 = jTextArea1;
    }

    public JComboBox<StatusCadastroEnum> getStatusComboBox() {
        return statusComboBox;
    }

    public void setStatusComboBox(JComboBox<StatusCadastroEnum> statusComboBox) {
        this.statusComboBox = statusComboBox;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JComboBox<String> getQuartoComboBox() {
        return quartoComboBox;
    }

    public void setQuartoComboBox(JComboBox<String> quartoComboBox) {
        this.quartoComboBox = quartoComboBox;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPaneltitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        descricaoLabel = new javax.swing.JLabel();
        descricaoField = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        quartoComboBox = new javax.swing.JComboBox<>();
        statusComboBox = new javax.swing.JComboBox<>();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Título do Form");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPaneltitulo.setBackground(new java.awt.Color(51, 153, 255));
        jPaneltitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Leito");
        jLabelTitulo.setToolTipText("");

        javax.swing.GroupLayout jPaneltituloLayout = new javax.swing.GroupLayout(jPaneltitulo);
        jPaneltitulo.setLayout(jPaneltituloLayout);
        jPaneltituloLayout.setHorizontalGroup(
            jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPaneltituloLayout.setVerticalGroup(
            jPaneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        getContentPane().add(jPaneltitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 762, -1));

        jPanelDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelDados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idLabel.setText("Id");
        jPanelDados.add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 8, 37, -1));

        idField.setEditable(false);
        idField.setEnabled(false);
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanelDados.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 28, 49, 28));

        descricaoLabel.setText("Descrição");
        jPanelDados.add(descricaoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 62, 60, -1));
        jPanelDados.add(descricaoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 84, 612, 30));

        statusLabel.setText("Status");
        jPanelDados.add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(638, 62, 37, -1));

        jLabel1.setText("Quarto");
        jPanelDados.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        quartoComboBox.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                quartoComboBoxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        quartoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quartoComboBoxActionPerformed(evt);
            }
        });
        jPanelDados.add(quartoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, 30));

        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });
        jPanelDados.add(statusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(632, 84, 122, 30));

        getContentPane().add(jPanelDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 49, 762, 180));

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Create.png"))); // NOI18N
        jButtonNovo.setText("Novo");
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
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonSair);

        getContentPane().add(jPanelBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 762, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
//        Utilities.ativaDesativa(true, jPanelBotoes);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
//        Utilities.ativaDesativa(false, jPanelBotoes);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
//        Utilities.ativaDesativa(false, jPanelBotoes);
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
//        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void quartoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quartoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quartoComboBoxActionPerformed

    private void quartoComboBoxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_quartoComboBoxAncestorAdded
    }//GEN-LAST:event_quartoComboBoxAncestorAdded

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    
    private void loadComboBox() {
       for (Quarto quarto : ClasseDadosGravacao.listaQuarto) {
               quartoComboBox.addItem(quarto.toString());
        }
       
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
            java.util.logging.Logger.getLogger(TelaCadastroLeito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLeito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLeito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLeito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroLeito dialog = new TelaCadastroLeito(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField descricaoField;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPaneltitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> quartoComboBox;
    private javax.swing.JComboBox<StatusCadastroEnum> statusComboBox;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
