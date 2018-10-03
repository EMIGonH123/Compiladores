package interfaz;

import compiladores.Automata;
import compiladores.Estado;
import compiladores.Transicion;
import java.awt.Color;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaInterrogacion extends javax.swing.JFrame {
    
    private OperacionesAutomata ventanaOperaciones;
    private Hashtable<Integer,Automata> automatas;
    
    public VistaInterrogacion(OperacionesAutomata ventanaOperaciones, Hashtable<Integer,Automata> automatas) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaOperaciones = ventanaOperaciones;
        this.automatas = automatas;
        Enumeration e = this.automatas.keys();
        Object clave;
        while( e.hasMoreElements() ){
            clave = e.nextElement();
            Lista.addItem(clave.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBaseCuerpo = new javax.swing.JPanel();
        Lista = new javax.swing.JComboBox<>();
        Aceptar = new javax.swing.JButton();
        PanelBaseTitulo = new javax.swing.JPanel();
        Titulo = new javax.swing.JTextField();
        Salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBaseCuerpo.setBackground(new java.awt.Color(153, 153, 153));

        Aceptar.setBackground(new java.awt.Color(153, 153, 153));
        Aceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aplicar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBaseCuerpoLayout = new javax.swing.GroupLayout(PanelBaseCuerpo);
        PanelBaseCuerpo.setLayout(PanelBaseCuerpoLayout);
        PanelBaseCuerpoLayout.setHorizontalGroup(
            PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaseCuerpoLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createSequentialGroup()
                        .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createSequentialGroup()
                        .addComponent(Aceptar)
                        .addGap(87, 87, 87))))
        );
        PanelBaseCuerpoLayout.setVerticalGroup(
            PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaseCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Aceptar)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBaseCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 260, 80));

        PanelBaseTitulo.setBackground(new java.awt.Color(102, 102, 102));

        Titulo.setEditable(false);
        Titulo.setBackground(new java.awt.Color(102, 102, 102));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Cerradura Interrogativa");
        Titulo.setBorder(null);

        Salir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setText("X");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelBaseTituloLayout = new javax.swing.GroupLayout(PanelBaseTitulo);
        PanelBaseTitulo.setLayout(PanelBaseTituloLayout);
        PanelBaseTituloLayout.setHorizontalGroup(
            PanelBaseTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaseTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        PanelBaseTituloLayout.setVerticalGroup(
            PanelBaseTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaseTituloLayout.createSequentialGroup()
                .addGroup(PanelBaseTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBaseTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        ventanaOperaciones.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SalirMouseClicked

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        Integer key = Integer.parseInt((String)Lista.getSelectedItem());
        Automata automataSelecionado = (Automata)automatas.get(key);
        automataSelecionado.cerraduraInterrogacion();
        System.out.println("--------------------------------");
        System.out.println("-------- INTERROGACION  --------");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("--- INFORMACION DEL AUTOMATA ---");
        System.out.println("--------------------------------");
        System.out.println("--------- EDO INICIAL ----------");
        System.out.println("--------------------------------");
        Estado edoInicial = automataSelecionado.getEstadoInicial();
        System.out.println("Ide: "+edoInicial.getIdentificador());
        System.out.println("Trancisiones: ");
        for(Transicion t: edoInicial.getTransiciones()){
            System.out.println("Va hacia: "+t.getEstadoDestino().getIdentificador()+" con simbolo: "+t.getSimboloFin());
        }
        System.out.println("--------------------------------");
        System.out.println("------- EDOS INTERMEDIOS -------");
        System.out.println("--------------------------------");
        Set<Estado> edos = automataSelecionado.getEstados();
        for(Estado aux: edos){
            System.out.println("Ide: "+aux.getIdentificador());
            System.out.println("Trancisiones: ");
            for(Transicion taux: aux.getTransiciones()){
                System.out.println("Va hacia: "+taux.getEstadoDestino().getIdentificador()+" con simbolo: "+taux.getSimboloFin());
            }
        }
        System.out.println("--------------------------------");
        System.out.println("--------- EDOS FINALES ---------");
        System.out.println("--------------------------------");
        Set<Estado> edosFinales = automataSelecionado.getEstadosFinales();
        for(Estado aux2: edosFinales){
            System.out.println("Ide: "+aux2.getIdentificador());
            System.out.println("Trancisiones: ");
            for(Transicion taux2: aux2.getTransiciones()){
                System.out.println("Va hacia: "+taux2.getEstadoDestino().getIdentificador()+" con simbolo: "+taux2.getSimboloFin());
            }
        }
        System.out.println("--------------------------------");
        System.out.println("----------- ALFABETO -----------");
        System.out.println("--------------------------------");
        Set<Character> alfabeto = automataSelecionado.getAlfabeto();
        System.out.println("Los simbolos son:");
        for(char c: alfabeto){
            System.out.print(c+", ");
        }System.out.println();
        
        automatas.replace(key, automataSelecionado);
        ventanaOperaciones.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JComboBox<String> Lista;
    private javax.swing.JPanel PanelBaseCuerpo;
    private javax.swing.JPanel PanelBaseTitulo;
    private javax.swing.JLabel Salir;
    private javax.swing.JTextField Titulo;
    // End of variables declaration//GEN-END:variables
}
