package generadorDeAutomatas;

import compiladores.AFD;
import compiladores.Automata;
import compiladores.Estado;
import compiladores.EstadoSi;
import compiladores.Transicion;
import compiladores.TransicionSi;
import interfaz.OperacionesAutomata;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaGeneradorAutomatas extends javax.swing.JFrame {
    
    private OperacionesAutomata ventanaOperaciones;
    private Hashtable<Integer, Automata> conjunto;
    private static int contador = 0;
    
    public VistaGeneradorAutomatas(OperacionesAutomata ventanaOperaciones, Hashtable<Integer, Automata> conjunto) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaOperaciones = ventanaOperaciones;
        this.conjunto = conjunto;
        String ruta = "/home/emigonh/Escritorio/SextoSemestre/Compiladores/Compiladores";
        String expresionRegular = "(\\w)+.txt";
        File f = new File(ruta);
        if( (f.exists()) && (f.length()>0) ){
            for(File aux : f.listFiles()){
                if( aux.isFile() ){
                    String nombreObjeto = aux.getName();
                    Pattern pat = Pattern.compile( expresionRegular );
                    Matcher mat = pat.matcher( nombreObjeto );
                    if( mat.matches() ){
                        ListaNombreObjetos.addItem( nombreObjeto );                    
                    }
                }
            }
        }else{
            ListaNombreObjetos.addItem("Carpeta vacia");
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBaseCuerpo = new javax.swing.JPanel();
        Aceptar = new javax.swing.JButton();
        CadenaEntrada = new javax.swing.JTextField();
        TituloCadenaDeEntrada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultadoInfoAutomata = new javax.swing.JTextArea();
        TituloResultadoLexico = new javax.swing.JLabel();
        TituloNombreObjeto = new javax.swing.JLabel();
        ListaNombreObjetos = new javax.swing.JComboBox<>();
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

        CadenaEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CadenaEntradaMouseClicked(evt);
            }
        });

        TituloCadenaDeEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloCadenaDeEntrada.setForeground(new java.awt.Color(255, 255, 255));
        TituloCadenaDeEntrada.setText("Ingresa la ER");

        ResultadoInfoAutomata.setEditable(false);
        ResultadoInfoAutomata.setColumns(20);
        ResultadoInfoAutomata.setRows(5);
        jScrollPane1.setViewportView(ResultadoInfoAutomata);

        TituloResultadoLexico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloResultadoLexico.setForeground(new java.awt.Color(255, 255, 255));
        TituloResultadoLexico.setText("Autómata Generado");

        TituloNombreObjeto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloNombreObjeto.setForeground(new java.awt.Color(255, 255, 255));
        TituloNombreObjeto.setText("Objeto de análisis");

        ListaNombreObjetos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout PanelBaseCuerpoLayout = new javax.swing.GroupLayout(PanelBaseCuerpo);
        PanelBaseCuerpo.setLayout(PanelBaseCuerpoLayout);
        PanelBaseCuerpoLayout.setHorizontalGroup(
            PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaseCuerpoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TituloNombreObjeto)
                    .addComponent(TituloCadenaDeEntrada)
                    .addComponent(TituloResultadoLexico)
                    .addComponent(ListaNombreObjetos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CadenaEntrada)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Aceptar)
                .addGap(106, 106, 106))
        );
        PanelBaseCuerpoLayout.setVerticalGroup(
            PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloNombreObjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListaNombreObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloCadenaDeEntrada)
                .addGap(4, 4, 4)
                .addComponent(CadenaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TituloResultadoLexico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Aceptar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBaseCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 290, 300));

        PanelBaseTitulo.setBackground(new java.awt.Color(102, 102, 102));

        Titulo.setEditable(false);
        Titulo.setBackground(new java.awt.Color(102, 102, 102));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Generador Automatas");
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
                .addGap(18, 18, 18)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        PanelBaseTituloLayout.setVerticalGroup(
            PanelBaseTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBaseTituloLayout.createSequentialGroup()
                .addGroup(PanelBaseTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBaseTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        ventanaOperaciones.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SalirMouseClicked

    public static void imprimirInfo(AFD automata){
        System.out.println("--------------------------------");
        System.out.println("--- INFORMACION DEL AUTOMATA ---");
        System.out.println("--------------------------------");
        System.out.println("--------- EDO INICIAL ----------");
        System.out.println("--------------------------------");
        EstadoSi edoInicial2 = automata.getEstadoInicial();
        System.out.println("Ide: "+edoInicial2.getIdEstado());
        System.out.println("Trancisiones: ");
        for(TransicionSi t: edoInicial2.getTransiciones()){
            System.out.println("Va hacia: "+t.getEstadoDestino().getIdEstado()+" con simbolo: "+t.getSimboloFin());
        }
        System.out.println("--------------------------------");
        System.out.println("------- EDOS INTERMEDIOS -------");
        System.out.println("--------------------------------");
        Set<EstadoSi> edos = automata.getEstados();
        for(EstadoSi aux: edos){
            System.out.println("Ide: "+aux.getIdEstado());
            System.out.println("Trancisiones: ");
            for(TransicionSi taux: aux.getTransiciones()){
                System.out.println("Va hacia: "+taux.getEstadoDestino().getIdEstado()+" con simbolo: "+taux.getSimboloFin());
            }
        }
        System.out.println("--------------------------------");
        System.out.println("--------- EDOS FINALES ---------");
        System.out.println("--------------------------------");
        Set<EstadoSi> edosFinales = automata.getEstadosDeAceptacion();
        for(EstadoSi aux22: edosFinales){
            System.out.println("Ide: "+aux22.getIdEstado());
            System.out.println("Token: "+aux22.getToken());
            System.out.println("Trancisiones: ");
            for(TransicionSi taux2: aux22.getTransiciones()){
                System.out.println("Va hacia: "+taux2.getEstadoDestino().getIdEstado()+" con simbolo: "+taux2.getSimboloFin());
            }
        }
        System.out.println("--------------------------------");
        System.out.println("----------- ALFABETO -----------");
        System.out.println("--------------------------------");
        Set<Character> alfabeto = automata.getAlfabeto();
        System.out.println("Los simbolos son:");
        for(char c: alfabeto){
            System.out.print(c+", ");
        }System.out.println();
    }
    
    public static void imprimirInfo(Automata automata){
        System.out.println("---------------------------------------");
        System.out.println("------ INFORMACION DEL AUTOMATA -------");
        System.out.println("---------------------------------------");
        System.out.println("------------- EDO INICIAL -------------");
        System.out.println("---------------------------------------");
        Estado edoInicial = automata.getEstadoInicial();
        System.out.println("Ide: "+edoInicial.getIdentificador());
        System.out.println("Trancisiones: ");
        for(Transicion t: edoInicial.getTransiciones()){
            System.out.println("Va hacia: "+t.getEstadoDestino().getIdentificador()+" con simbolo: "+t.getSimboloFin());
        }
        System.out.println("---------------------------------------");
        System.out.println("---------- EDOS INTERMEDIOS -----------");
        System.out.println("---------------------------------------");
        Set<Estado> edos = automata.getEstados();
        for(Estado aux: edos){
            System.out.println("Ide: "+aux.getIdentificador());
            System.out.println("Trancisiones: ");
            for(Transicion taux: aux.getTransiciones()){
                System.out.println("Va hacia: "+taux.getEstadoDestino().getIdentificador()+" con simbolo: "+taux.getSimboloFin());
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("------------ EDOS FINALES -------------");
        System.out.println("---------------------------------------");
        Set<Estado> edosFinales = automata.getEstadosFinales();
        for(Estado aux: edosFinales){
            System.out.println("Ide: "+aux.getIdentificador());
            System.out.println("Token: "+aux.getToken());
            System.out.println("Trancisiones: ");
            for(Transicion taux: aux.getTransiciones()){
                System.out.println("Va hacia: "+taux.getEstadoDestino().getIdentificador()+" con simbolo: "+taux.getSimboloFin());
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("-------------- ALFABETO ---------------");
        System.out.println("---------------------------------------");
        Set<Character> alfabeto = automata.getAlfabeto();
        System.out.println("Los simbolos son:");
        for(char c: alfabeto){
            System.out.print(c+", ");
        }System.out.println("\n");
    }
    
    
    public void resetAllData(){
        CadenaEntrada.setText("");
        ResultadoInfoAutomata.setText("");
    }
    
    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        System.out.println("\n------------------------------------------------");
        System.out.println("--- Creación de Automata por medio de una ER ---");
        System.out.println("------------------------------------------------");
        
        try {
            LexicGA.reset();
            System.out.println("------------ Cargando AFD(Objeto) --------------");
            String nombreObjeto = ListaNombreObjetos.getSelectedItem().toString();
            String cadena = CadenaEntrada.getText(); //Obtenemos la cadena ER    
            LexicGA.cadena = cadena; //Mandamos la cadena a Lexic
            LexicGA.automata = (AFD)LexicGA.cargarObjeto(nombreObjeto); //Mandamos el AFN
            imprimirInfo(LexicGA.automata); //Imprimimos el Automata con el cual vamos a analizar la cadena
            System.out.println("------------------------------------------------");
            System.out.println("------- Analizar la cadena: '"+cadena+"' -------");
            System.out.println("------------------------------------------------");
            Automata a = new Automata();
            if(GeneradorDeAutomatas.GeneradorAutomata(a)){
                imprimirInfo(a);
            }
            conjunto.put(++contador, a);
            a = null;
            
        } catch (IOException ex) {
            Logger.getLogger(VistaGeneradorAutomatas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaGeneradorAutomatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void CadenaEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadenaEntradaMouseClicked
        resetAllData();
    }//GEN-LAST:event_CadenaEntradaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField CadenaEntrada;
    private javax.swing.JComboBox<String> ListaNombreObjetos;
    private javax.swing.JPanel PanelBaseCuerpo;
    private javax.swing.JPanel PanelBaseTitulo;
    private javax.swing.JTextArea ResultadoInfoAutomata;
    private javax.swing.JLabel Salir;
    private javax.swing.JTextField Titulo;
    private javax.swing.JLabel TituloCadenaDeEntrada;
    private javax.swing.JLabel TituloNombreObjeto;
    private javax.swing.JLabel TituloResultadoLexico;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
