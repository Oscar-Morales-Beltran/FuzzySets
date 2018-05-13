/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserView;
import fuzzysets.FuzzyOperations;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayot
 */
public class InputData extends javax.swing.JFrame {
    //número de elementos de los conjuntos A y B
    FuzzyOperations fuzz = new FuzzyOperations();

    /**
     * Creates new form InputData
     */
    public InputData() {
        initComponents();
        getContentPane().setBackground(new Color(42,27,48));
        setLocationRelativeTo(this);
        fuzz.establishCheckBoxes();
        btnAceptar.setEnabled(false);
        radioCampana.setVisible(false);
    }
    
    /*Abre el JFrame donde mostramos las operaciones de los conjuntos*/
    private void opeNewFrame(){
        fuzz.showUI();
        this.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        functionsGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFA = new javax.swing.JTextField();
        jTFB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonGetElements = new javax.swing.JButton();
        radioTrapezoidal = new javax.swing.JRadioButton();
        radioPiramidal = new javax.swing.JRadioButton();
        radioCampana = new javax.swing.JRadioButton();
        btnAceptar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        CustomLabelExit = new javax.swing.JLabel();
        CustomLavelExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 153));
        setUndecorated(true);

        jLabel1.setBackground(new java.awt.Color(42, 27, 48));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Conjuntos");

        jLabel2.setBackground(new java.awt.Color(42, 27, 48));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Número de elementos de A");

        jLabel3.setBackground(new java.awt.Color(42, 27, 48));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Número de elementos de B");

        jTFA.setBackground(new java.awt.Color(42, 27, 48));
        jTFA.setForeground(new java.awt.Color(255, 255, 255));
        jTFA.setBorder(null);

        jTFB.setBackground(new java.awt.Color(42, 27, 48));
        jTFB.setForeground(new java.awt.Color(255, 255, 255));
        jTFB.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("2");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        buttonGetElements.setBackground(new java.awt.Color(236, 97, 102));
        buttonGetElements.setText("Ingresar elementos");
        buttonGetElements.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buttonGetElements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGetElementsActionPerformed(evt);
            }
        });

        radioTrapezoidal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        radioTrapezoidal.setForeground(new java.awt.Color(255, 255, 255));
        radioTrapezoidal.setText("Trapezoidal");

        radioPiramidal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        radioPiramidal.setForeground(new java.awt.Color(255, 255, 255));
        radioPiramidal.setText("Piramidal");

        radioCampana.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        radioCampana.setForeground(new java.awt.Color(255, 255, 255));
        radioCampana.setText("Campana");

        btnAceptar.setBackground(new java.awt.Color(236, 97, 102));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        CustomLabelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CustomLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomLabelExitMouseClicked(evt);
            }
        });

        CustomLavelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconmonstr-x-mark-3-32.png"))); // NOI18N
        CustomLavelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CustomLavelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomLavelExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 495, Short.MAX_VALUE)
                .addComponent(CustomLabelExit)
                .addGap(19, 19, 19)
                .addComponent(CustomLavelExit)
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(141, 141, 141)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(37, 37, 37)
                            .addComponent(jTFA, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(buttonGetElements, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jTFB, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radioTrapezoidal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioPiramidal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CustomLavelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustomLabelExit)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jTFB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioTrapezoidal)
                        .addGap(32, 32, 32)
                        .addComponent(radioPiramidal)
                        .addGap(25, 25, 25)
                        .addComponent(radioCampana)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGetElements, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGetElementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGetElementsActionPerformed
        // TODO add your handling code here:
        fuzz.verifyFunction();
    }//GEN-LAST:event_buttonGetElementsActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        opeNewFrame();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void CustomLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomLabelExitMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomLabelExitMouseClicked

    private void CustomLavelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomLavelExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CustomLavelExitMouseClicked

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
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CustomLabelExit;
    private javax.swing.JLabel CustomLavelExit;
    public static javax.swing.JButton btnAceptar;
    private javax.swing.JButton buttonGetElements;
    public static javax.swing.ButtonGroup functionsGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTextField jTFA;
    public static javax.swing.JTextField jTFB;
    public static javax.swing.JRadioButton radioCampana;
    public static javax.swing.JRadioButton radioPiramidal;
    public static javax.swing.JRadioButton radioTrapezoidal;
    // End of variables declaration//GEN-END:variables
}