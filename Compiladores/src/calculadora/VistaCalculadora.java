package calculadora;

import interfaz.*;
import static calculadora.Sintactico.*;
import calculadora.FlotanteEmi.*;
import compiladores.AFD;
import compiladores.EstadoSi;
import compiladores.Lexic;
import compiladores.Token;
import compiladores.TransicionSi;
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

public class VistaCalculadora extends javax.swing.JFrame {
    
    private OperacionesAutomata ventanaOperaciones;
    private Hashtable<Integer,AFD> automatas;
    
    public VistaCalculadora(OperacionesAutomata ventanaOperaciones) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaOperaciones = ventanaOperaciones;
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
        BanderaSintactica = new javax.swing.JTextField();
        ResultadoSintactico = new javax.swing.JTextField();
        TituloResultadoSintactico = new javax.swing.JLabel();
        TituloCadenaDeEntrada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultadoLexico = new javax.swing.JTextArea();
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

        BanderaSintactica.setEditable(false);
        BanderaSintactica.setBackground(new java.awt.Color(204, 204, 204));

        ResultadoSintactico.setEditable(false);

        TituloResultadoSintactico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloResultadoSintactico.setForeground(new java.awt.Color(255, 255, 255));
        TituloResultadoSintactico.setText("Resultado Sintáctico");

        TituloCadenaDeEntrada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloCadenaDeEntrada.setForeground(new java.awt.Color(255, 255, 255));
        TituloCadenaDeEntrada.setText("Ingresa la cadena");

        ResultadoLexico.setEditable(false);
        ResultadoLexico.setColumns(20);
        ResultadoLexico.setRows(5);
        jScrollPane1.setViewportView(ResultadoLexico);

        TituloResultadoLexico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TituloResultadoLexico.setForeground(new java.awt.Color(255, 255, 255));
        TituloResultadoLexico.setText("Resultado Análisis Léxico");

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
                .addGroup(PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createSequentialGroup()
                        .addComponent(Aceptar)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TituloNombreObjeto)
                        .addComponent(TituloResultadoSintactico)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBaseCuerpoLayout.createSequentialGroup()
                            .addComponent(ResultadoSintactico)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BanderaSintactica, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(CadenaEntrada)
                        .addComponent(TituloCadenaDeEntrada)
                        .addComponent(TituloResultadoLexico)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addComponent(ListaNombreObjetos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
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
                .addComponent(TituloResultadoSintactico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelBaseCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BanderaSintactica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResultadoSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(Aceptar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(PanelBaseCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 260, 410));

        PanelBaseTitulo.setBackground(new java.awt.Color(102, 102, 102));

        Titulo.setEditable(false);
        Titulo.setBackground(new java.awt.Color(102, 102, 102));
        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Calculadora");
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
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    public static void imprimirInfo(AFD automata){
        System.out.println("---------------------------------------");
        System.out.println("------ INFORMACION DEL AUTOMATA -------");
        System.out.println("---------------------------------------");
        System.out.println("------------- EDO INICIAL -------------");
        System.out.println("---------------------------------------");
        EstadoSi edoInicial2 = automata.getEstadoInicial();
        System.out.println("Ide: "+edoInicial2.getIdEstado());
        System.out.println("Trancisiones: ");
        for(TransicionSi t: edoInicial2.getTransiciones()){
            System.out.println("Va hacia: "+t.getEstadoDestino().getIdEstado()+" con simbolo: "+t.getSimboloFin());
        }
        System.out.println("---------------------------------------");
        System.out.println("---------- EDOS INTERMEDIOS -----------");
        System.out.println("---------------------------------------");
        Set<EstadoSi> edos = automata.getEstados();
        for(EstadoSi aux: edos){
            System.out.println("Ide: "+aux.getIdEstado());
            System.out.println("Trancisiones: ");
            for(TransicionSi taux: aux.getTransiciones()){
                System.out.println("Va hacia: "+taux.getEstadoDestino().getIdEstado()+" con simbolo: "+taux.getSimboloFin());
            }
        }
        System.out.println("---------------------------------------");
        System.out.println("------------ EDOS FINALES -------------");
        System.out.println("---------------------------------------");
        Set<EstadoSi> edosFinales = automata.getEstadosDeAceptacion();
        for(EstadoSi aux22: edosFinales){
            System.out.println("Ide: "+aux22.getIdEstado());
            System.out.println("Token: "+aux22.getToken());
            System.out.println("Trancisiones: ");
            for(TransicionSi taux2: aux22.getTransiciones()){
                System.out.println("Va hacia: "+taux2.getEstadoDestino().getIdEstado()+" con simbolo: "+taux2.getSimboloFin());
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
    
    public void resetAllColors(){
        BanderaSintactica.setBackground(new Color(204,204,204));
    }
    public void resetAllData(){
        CadenaEntrada.setText("");
        ResultadoLexico.setText("");
        ResultadoSintactico.setText("");
        
        
    }
    
    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        System.out.println("\n---------------------------------------");
        System.out.println("----------- ANALISIS LEXICO -----------");
        System.out.println("---------------------------------------");
        String cadena = CadenaEntrada.getText();
        
        Lexic.cadena = cadena; //Mandamos la cadena a Lexic
        try {
            System.out.println("-------- Cargando AFD(Objeto) ---------");
            String nombreObjeto = ListaNombreObjetos.getSelectedItem().toString();
            Lexic.automata = (AFD)Lexic.cargarObjeto(nombreObjeto);
            imprimirInfo(Lexic.automata);
            System.out.println("---------------------------------------");
            System.out.println("---- Analizar la cadena: '"+cadena+"' ---");
            System.out.println("---------------------------------------");
            
            Token t;
            StringBuilder resultadoLexico = new StringBuilder();
            
            /*while( (t= Lexic.getToken()).token != 0 ){
                resultadoLexico.append("Lexema: "+t.lexema+"\n"+"Token: "+t.token+"\n\n");
                System.out.println("Lexema: "+t.lexema);
                System.out.println("Token: "+ t.token+"\n");
            }
            ResultadoLexico.setText(resultadoLexico.toString());
            */
            
            
            FlotanteEmi f = new FlotanteEmi();
            if( Sintactico.ASDR( f ) ){
                ResultadoSintactico.setText("CORRECTO");
                System.out.println("El resultado es: "+f.getValor());
                BanderaSintactica.setBackground(new Color(0,255,0) );
            }else{
                ResultadoSintactico.setText("INCORRECTO");
                BanderaSintactica.setBackground(new Color(255,0,0) );
            }
        } catch (IOException ex) {
            Logger.getLogger(VistaCalculadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaCalculadora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void CadenaEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadenaEntradaMouseClicked
        resetAllData();
        resetAllColors();
    }//GEN-LAST:event_CadenaEntradaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField BanderaSintactica;
    private javax.swing.JTextField CadenaEntrada;
    private javax.swing.JComboBox<String> ListaNombreObjetos;
    private javax.swing.JPanel PanelBaseCuerpo;
    private javax.swing.JPanel PanelBaseTitulo;
    private javax.swing.JTextArea ResultadoLexico;
    private javax.swing.JTextField ResultadoSintactico;
    private javax.swing.JLabel Salir;
    private javax.swing.JTextField Titulo;
    private javax.swing.JLabel TituloCadenaDeEntrada;
    private javax.swing.JLabel TituloNombreObjeto;
    private javax.swing.JLabel TituloResultadoLexico;
    private javax.swing.JLabel TituloResultadoSintactico;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
