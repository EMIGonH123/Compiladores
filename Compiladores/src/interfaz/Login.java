package interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGeneral = new javax.swing.JPanel();
        PanelTitulo = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        BTNSalir = new javax.swing.JToggleButton();
        LBLUsuario = new javax.swing.JLabel();
        LBLPass = new javax.swing.JLabel();
        TXTUsuario = new javax.swing.JTextField();
        TXTPass = new javax.swing.JPasswordField();
        BTNEntrar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelGeneral.setBackground(new java.awt.Color(153, 153, 153));

        PanelTitulo.setBackground(new java.awt.Color(255, 0, 0));

        Titulo.setBackground(new java.awt.Color(255, 0, 0));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("BIENVENIDO AL SISTEMA");

        BTNSalir.setBackground(new java.awt.Color(255, 0, 0));
        BTNSalir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BTNSalir.setForeground(new java.awt.Color(255, 255, 255));
        BTNSalir.setText("X");
        BTNSalir.setBorder(null);
        BTNSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addComponent(BTNSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addGroup(PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNSalir)
                    .addComponent(Titulo))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        LBLUsuario.setBackground(new java.awt.Color(255, 0, 0));
        LBLUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LBLUsuario.setText("Email");

        LBLPass.setBackground(new java.awt.Color(255, 0, 0));
        LBLPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLPass.setForeground(new java.awt.Color(255, 255, 255));
        LBLPass.setText("Contraseña");

        TXTUsuario.setBackground(new java.awt.Color(153, 153, 153));
        TXTUsuario.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        TXTUsuario.setForeground(new java.awt.Color(255, 255, 255));
        TXTUsuario.setText("jose@gmail.com");
        TXTUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        TXTUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        TXTUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TXTUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXTUsuarioMouseClicked(evt);
            }
        });

        TXTPass.setBackground(new java.awt.Color(153, 153, 153));
        TXTPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TXTPass.setForeground(new java.awt.Color(255, 255, 255));
        TXTPass.setText("jPasswordField1");
        TXTPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        TXTPass.setCaretColor(new java.awt.Color(255, 255, 255));
        TXTPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TXTPassMouseClicked(evt);
            }
        });

        BTNEntrar.setBackground(new java.awt.Color(255, 0, 0));
        BTNEntrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BTNEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BTNEntrar.setText("Entrar");
        BTNEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGeneralLayout = new javax.swing.GroupLayout(PanelGeneral);
        PanelGeneral.setLayout(PanelGeneralLayout);
        PanelGeneralLayout.setHorizontalGroup(
            PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralLayout.createSequentialGroup()
                .addGroup(PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelGeneralLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelGeneralLayout.createSequentialGroup()
                                .addComponent(LBLPass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXTPass, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelGeneralLayout.createSequentialGroup()
                                .addComponent(LBLUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXTUsuario))))
                    .addGroup(PanelGeneralLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(BTNEntrar))
                    .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelGeneralLayout.setVerticalGroup(
            PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGeneralLayout.createSequentialGroup()
                .addComponent(PanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LBLUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(PanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBLPass)
                    .addComponent(TXTPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(BTNEntrar)
                .addContainerGap())
        );

        getContentPane().add(PanelGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BTNSalirActionPerformed

    private void BTNEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEntrarActionPerformed
        String email = TXTUsuario.getText();
        String pass = new String(TXTPass.getPassword());
        
        if(!(email.equals("") || pass.equals("")) && (email.equals("metalica.el.01@gmail.com") && pass.equals("emigonh1997$"))){        
            JOptionPane.showMessageDialog(null, "Los Campos Fueron Correctos", "Validación correcta",JOptionPane.INFORMATION_MESSAGE );
            OperacionesAutomata op = new OperacionesAutomata();
            op.setVisible(true);
            this.setVisible(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "Campos Incorrectos", "-_____-",JOptionPane.WARNING_MESSAGE );
        }
    }//GEN-LAST:event_BTNEntrarActionPerformed

    private void TXTPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXTPassMouseClicked
        TXTPass.setBackground(Color.GRAY);
        TXTPass.setText("");
    }//GEN-LAST:event_TXTPassMouseClicked

    private void TXTUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TXTUsuarioMouseClicked
        TXTUsuario.setBackground(Color.GRAY);
        TXTUsuario.setText("");
        TXTUsuario.setFont(new Font("Tahoma", 14, 14));
    }//GEN-LAST:event_TXTUsuarioMouseClicked

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BTNEntrar;
    private javax.swing.JToggleButton BTNSalir;
    private javax.swing.JLabel LBLPass;
    private javax.swing.JLabel LBLUsuario;
    private javax.swing.JPanel PanelGeneral;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JPasswordField TXTPass;
    private javax.swing.JTextField TXTUsuario;
    private javax.swing.JLabel Titulo;
    // End of variables declaration//GEN-END:variables
}
