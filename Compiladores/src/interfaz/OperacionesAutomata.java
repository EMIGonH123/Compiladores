package interfaz;

import calculadora.VistaCalculadora;
import compiladores.AFD;
import compiladores.Automata;
import compiladores.Estado;
import compiladores.Transicion;
import generadorDeAutomatas.VistaGeneradorAutomatas;
import java.awt.Color;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperacionesAutomata extends javax.swing.JFrame {
    private Set<Automata> automatas;
    private Hashtable<Integer,Automata> conjuntoAutomatas;
    private Hashtable<Integer,AFD> conjuntoAutomatasAFD;
    private Hashtable<Integer, String> objetosGuardados;
    public static int idAutomata = 0;
    public static int contador = 0;
    
    public void agregarObjeto(String nombre){
        objetosGuardados.put(++contador, nombre);
    }
    
    public Hashtable<Integer, String> getNombreObjetos(){
        return this.objetosGuardados;
    }
    
    public OperacionesAutomata() {
        initComponents();
        this.setLocationRelativeTo(null);
        automatas = new HashSet<Automata>();
        conjuntoAutomatas = new Hashtable<Integer, Automata>();
        conjuntoAutomatasAFD = new Hashtable<Integer, AFD>();
        objetosGuardados = new Hashtable<Integer, String>();
    }
    
    public boolean estaVaciaListaAutomatas(){
        if(this.automatas.isEmpty())
            return true;
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitulo = new javax.swing.JPanel();
        LBLTitulo = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        PanelContenido = new javax.swing.JPanel();
        BTNSallir = new javax.swing.JToggleButton();
        SubtituloCerraduras = new javax.swing.JLabel();
        CerraduraPositiva = new javax.swing.JTextField();
        CerraduraMult = new javax.swing.JTextField();
        CerraduraOpcional = new javax.swing.JTextField();
        SubtituloOperaciones = new javax.swing.JLabel();
        UnionAFN = new javax.swing.JTextField();
        ConcatenacionAFN = new javax.swing.JTextField();
        ConversionAFD = new javax.swing.JTextField();
        CrearAFNBasico = new javax.swing.JTextField();
        AutomataGeneral = new javax.swing.JTextField();
        AnalisisLexico = new javax.swing.JTextField();
        Calculadora = new javax.swing.JTextField();
        GeneradorPorER = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTitulo.setBackground(new java.awt.Color(255, 0, 0));

        LBLTitulo.setBackground(new java.awt.Color(255, 0, 0));
        LBLTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LBLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        LBLTitulo.setText("Operaciones con Automatas");

        Exit.setBackground(new java.awt.Color(255, 0, 0));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Exit.setText("X");
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelTituloLayout = new javax.swing.GroupLayout(PanelTitulo);
        PanelTitulo.setLayout(PanelTituloLayout);
        PanelTituloLayout.setHorizontalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(LBLTitulo)
                .addGap(64, 64, 64)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelTituloLayout.setVerticalGroup(
            PanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBLTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelTituloLayout.createSequentialGroup()
                .addComponent(Exit)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(PanelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 40));

        PanelContenido.setBackground(new java.awt.Color(153, 153, 153));

        BTNSallir.setBackground(new java.awt.Color(255, 0, 0));
        BTNSallir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BTNSallir.setForeground(new java.awt.Color(255, 255, 255));
        BTNSallir.setText("Salir");
        BTNSallir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSallirActionPerformed(evt);
            }
        });

        SubtituloCerraduras.setBackground(new java.awt.Color(153, 153, 153));
        SubtituloCerraduras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SubtituloCerraduras.setForeground(new java.awt.Color(255, 255, 255));
        SubtituloCerraduras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SubtituloCerraduras.setText("Cerraduras");
        SubtituloCerraduras.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        SubtituloCerraduras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        CerraduraPositiva.setEditable(false);
        CerraduraPositiva.setBackground(new java.awt.Color(153, 153, 153));
        CerraduraPositiva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CerraduraPositiva.setForeground(new java.awt.Color(255, 255, 255));
        CerraduraPositiva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CerraduraPositiva.setText("Positiva +");
        CerraduraPositiva.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CerraduraPositivaMouseMoved(evt);
            }
        });
        CerraduraPositiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerraduraPositivaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerraduraPositivaMouseExited(evt);
            }
        });

        CerraduraMult.setEditable(false);
        CerraduraMult.setBackground(new java.awt.Color(153, 153, 153));
        CerraduraMult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CerraduraMult.setForeground(new java.awt.Color(255, 255, 255));
        CerraduraMult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CerraduraMult.setText("Universal *");
        CerraduraMult.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CerraduraMultMouseMoved(evt);
            }
        });
        CerraduraMult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerraduraMultMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerraduraMultMouseExited(evt);
            }
        });

        CerraduraOpcional.setEditable(false);
        CerraduraOpcional.setBackground(new java.awt.Color(153, 153, 153));
        CerraduraOpcional.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CerraduraOpcional.setForeground(new java.awt.Color(255, 255, 255));
        CerraduraOpcional.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CerraduraOpcional.setText("Opcional ?");
        CerraduraOpcional.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CerraduraOpcionalMouseMoved(evt);
            }
        });
        CerraduraOpcional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerraduraOpcionalMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CerraduraOpcionalMouseExited(evt);
            }
        });

        SubtituloOperaciones.setBackground(new java.awt.Color(153, 153, 153));
        SubtituloOperaciones.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SubtituloOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        SubtituloOperaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SubtituloOperaciones.setText("Operaciones AFN");
        SubtituloOperaciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        SubtituloOperaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        UnionAFN.setEditable(false);
        UnionAFN.setBackground(new java.awt.Color(153, 153, 153));
        UnionAFN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UnionAFN.setForeground(new java.awt.Color(255, 255, 255));
        UnionAFN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UnionAFN.setText("Union");
        UnionAFN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                UnionAFNMouseMoved(evt);
            }
        });
        UnionAFN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UnionAFNMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UnionAFNMouseExited(evt);
            }
        });

        ConcatenacionAFN.setEditable(false);
        ConcatenacionAFN.setBackground(new java.awt.Color(153, 153, 153));
        ConcatenacionAFN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConcatenacionAFN.setForeground(new java.awt.Color(255, 255, 255));
        ConcatenacionAFN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ConcatenacionAFN.setText("Concatenacion");
        ConcatenacionAFN.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ConcatenacionAFNMouseMoved(evt);
            }
        });
        ConcatenacionAFN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConcatenacionAFNMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConcatenacionAFNMouseExited(evt);
            }
        });

        ConversionAFD.setEditable(false);
        ConversionAFD.setBackground(new java.awt.Color(153, 153, 153));
        ConversionAFD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ConversionAFD.setForeground(new java.awt.Color(255, 255, 255));
        ConversionAFD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ConversionAFD.setText("Conversión AFD");
        ConversionAFD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ConversionAFDMouseMoved(evt);
            }
        });
        ConversionAFD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConversionAFDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ConversionAFDMouseExited(evt);
            }
        });

        CrearAFNBasico.setEditable(false);
        CrearAFNBasico.setBackground(new java.awt.Color(153, 153, 153));
        CrearAFNBasico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CrearAFNBasico.setForeground(new java.awt.Color(255, 255, 255));
        CrearAFNBasico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CrearAFNBasico.setText("Crear AFN Básico");
        CrearAFNBasico.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CrearAFNBasicoMouseMoved(evt);
            }
        });
        CrearAFNBasico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearAFNBasicoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CrearAFNBasicoMouseExited(evt);
            }
        });

        AutomataGeneral.setEditable(false);
        AutomataGeneral.setBackground(new java.awt.Color(153, 153, 153));
        AutomataGeneral.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AutomataGeneral.setForeground(new java.awt.Color(255, 255, 255));
        AutomataGeneral.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AutomataGeneral.setText("Creación AFN General");
        AutomataGeneral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AutomataGeneralMouseMoved(evt);
            }
        });
        AutomataGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutomataGeneralMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AutomataGeneralMouseExited(evt);
            }
        });

        AnalisisLexico.setEditable(false);
        AnalisisLexico.setBackground(new java.awt.Color(153, 153, 153));
        AnalisisLexico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AnalisisLexico.setForeground(new java.awt.Color(255, 255, 255));
        AnalisisLexico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AnalisisLexico.setText("Análisis Léxico");
        AnalisisLexico.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                AnalisisLexicoMouseMoved(evt);
            }
        });
        AnalisisLexico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnalisisLexicoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AnalisisLexicoMouseExited(evt);
            }
        });

        Calculadora.setEditable(false);
        Calculadora.setBackground(new java.awt.Color(153, 153, 153));
        Calculadora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Calculadora.setForeground(new java.awt.Color(255, 255, 255));
        Calculadora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Calculadora.setText("Calculadora");
        Calculadora.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                CalculadoraMouseMoved(evt);
            }
        });
        Calculadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalculadoraMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalculadoraMouseExited(evt);
            }
        });

        GeneradorPorER.setEditable(false);
        GeneradorPorER.setBackground(new java.awt.Color(153, 153, 153));
        GeneradorPorER.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GeneradorPorER.setForeground(java.awt.Color.white);
        GeneradorPorER.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GeneradorPorER.setText("Generador de automatas por ER");
        GeneradorPorER.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                GeneradorPorERMouseMoved(evt);
            }
        });
        GeneradorPorER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeneradorPorERMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GeneradorPorERMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelContenidoLayout = new javax.swing.GroupLayout(PanelContenido);
        PanelContenido.setLayout(PanelContenidoLayout);
        PanelContenidoLayout.setHorizontalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenidoLayout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(BTNSallir)
                .addGap(174, 174, 174))
            .addGroup(PanelContenidoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelContenidoLayout.createSequentialGroup()
                        .addComponent(Calculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(GeneradorPorER, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                    .addGroup(PanelContenidoLayout.createSequentialGroup()
                        .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CerraduraOpcional, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(CerraduraMult, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(CerraduraPositiva, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(SubtituloCerraduras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubtituloOperaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelContenidoLayout.createSequentialGroup()
                                .addComponent(UnionAFN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CrearAFNBasico, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelContenidoLayout.createSequentialGroup()
                                .addComponent(ConversionAFD, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ConcatenacionAFN, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AnalisisLexico)))
                    .addComponent(AutomataGeneral))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        PanelContenidoLayout.setVerticalGroup(
            PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelContenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubtituloCerraduras, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubtituloOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerraduraPositiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UnionAFN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearAFNBasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerraduraMult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConversionAFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConcatenacionAFN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CerraduraOpcional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnalisisLexico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AutomataGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calculadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GeneradorPorER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNSallir)
                .addContainerGap())
        );

        getContentPane().add(PanelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNSallirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSallirActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTNSallirActionPerformed

   
    public void setColorTF(JTextField j){
        j.setBackground(new Color(102,102,102));
        
    }
    public void resetColorTF(JTextField j){
        j.setBackground(new Color(153,153,153));
    }
    
    private void resetAllColors(){
        resetColorTF(CerraduraPositiva);
        resetColorTF(CerraduraMult);
        resetColorTF(Calculadora);
        resetColorTF(CrearAFNBasico);
        resetColorTF(CerraduraOpcional);
        resetColorTF(UnionAFN);
        resetColorTF(AutomataGeneral);
        resetColorTF(AnalisisLexico);
        resetColorTF(GeneradorPorER);
        resetColorTF(ConcatenacionAFN);
        resetColorTF(ConversionAFD);
    }
    
    private void CerraduraPositivaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraPositivaMouseMoved
        resetAllColors();
        setColorTF(CerraduraPositiva);
    }//GEN-LAST:event_CerraduraPositivaMouseMoved

    private void CerraduraPositivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraPositivaMouseExited
        this.resetAllColors();
    }//GEN-LAST:event_CerraduraPositivaMouseExited

    private void CerraduraPositivaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraPositivaMouseClicked
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            VistaCP vistacp = new VistaCP(this, conjuntoAutomatas);
            vistacp.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_CerraduraPositivaMouseClicked

    private void CerraduraMultMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraMultMouseMoved
        resetAllColors();
        setColorTF(CerraduraMult);
    }//GEN-LAST:event_CerraduraMultMouseMoved

    private void CerraduraMultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraMultMouseClicked
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            VistaCK vck = new VistaCK(this, conjuntoAutomatas);
            vck.setVisible(true);
            //vistack.setAutomatas(this.automatas);
            //vistack.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_CerraduraMultMouseClicked

    private void CerraduraMultMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraMultMouseExited
        this.resetAllColors();
    }//GEN-LAST:event_CerraduraMultMouseExited

    private void CerraduraOpcionalMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraOpcionalMouseMoved
        resetAllColors();
        setColorTF(CerraduraOpcional);
    }//GEN-LAST:event_CerraduraOpcionalMouseMoved

    private void CerraduraOpcionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraOpcionalMouseClicked
        // TODO add your handling code here:
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            VistaInterrogacion vistainterrogacion = new VistaInterrogacion(this, conjuntoAutomatas);
            vistainterrogacion.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_CerraduraOpcionalMouseClicked

    
    
    private void CerraduraOpcionalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerraduraOpcionalMouseExited
        this.resetAllColors();
    }//GEN-LAST:event_CerraduraOpcionalMouseExited

    private void UnionAFNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnionAFNMouseMoved
        resetAllColors();
        setColorTF(UnionAFN);
    }//GEN-LAST:event_UnionAFNMouseMoved

    private void UnionAFNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnionAFNMouseClicked
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            VistaUnion vistaunion = new VistaUnion(this,conjuntoAutomatas);
            vistaunion.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_UnionAFNMouseClicked

    private void UnionAFNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UnionAFNMouseExited
        this.resetAllColors();
    }//GEN-LAST:event_UnionAFNMouseExited

    private void ConcatenacionAFNMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConcatenacionAFNMouseMoved
        resetAllColors();
        setColorTF(ConcatenacionAFN);
    }//GEN-LAST:event_ConcatenacionAFNMouseMoved

    private void ConcatenacionAFNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConcatenacionAFNMouseClicked
        // TODO add your handling code here:
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            VistaConcatenacion vistaconcatenacion = new VistaConcatenacion(this, conjuntoAutomatas);
            vistaconcatenacion.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_ConcatenacionAFNMouseClicked

    private void ConcatenacionAFNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConcatenacionAFNMouseExited
        this.resetAllColors();
    }//GEN-LAST:event_ConcatenacionAFNMouseExited

    private void ConversionAFDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConversionAFDMouseMoved
        resetAllColors();
        setColorTF(ConversionAFD);
    }//GEN-LAST:event_ConversionAFDMouseMoved

    private void ConversionAFDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConversionAFDMouseClicked
        // TODO add your handling code here:
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            VistaConversionAFD vistaconversion = new VistaConversionAFD(this, conjuntoAutomatas);
            vistaconversion.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_ConversionAFDMouseClicked

    private void ConversionAFDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConversionAFDMouseExited
        this.resetAllColors();
    }//GEN-LAST:event_ConversionAFDMouseExited

    private void CrearAFNBasicoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearAFNBasicoMouseMoved
        resetAllColors();
        setColorTF(CrearAFNBasico);
    }//GEN-LAST:event_CrearAFNBasicoMouseMoved

    private void CrearAFNBasicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearAFNBasicoMouseClicked
        String simbolo = JOptionPane.showInputDialog("Ingrese el simbolo");
        if(simbolo.length() != 1){
            JOptionPane.showMessageDialog(null, "La longitud del simbolo no es unitaria", "ERROR EN LA CADENA", JOptionPane.ERROR_MESSAGE);
        }else{
            System.out.println("La cadena fue: "+simbolo);
            char c[] = simbolo.toCharArray();
            Automata automata = new Automata(c[0]);
            this.conjuntoAutomatas.put(++idAutomata, automata);
            this.automatas.add(automata);
            
        }
    }//GEN-LAST:event_CrearAFNBasicoMouseClicked

    private void CrearAFNBasicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearAFNBasicoMouseExited
        resetAllColors();
    }//GEN-LAST:event_CrearAFNBasicoMouseExited

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void AutomataGeneralMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutomataGeneralMouseMoved
        resetAllColors();
        setColorTF(AutomataGeneral);
    }//GEN-LAST:event_AutomataGeneralMouseMoved

    private void AutomataGeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutomataGeneralMouseClicked
        if(estaVaciaListaAutomatas()){
            JOptionPane.showMessageDialog(null,"No existen automatas para llevar acabo la operación","WARNING",JOptionPane.WARNING_MESSAGE);
        }else{
            
            Automata automataGeneral = Automata.crearAutomataGeneral(conjuntoAutomatas);
            conjuntoAutomatas.clear();
            
            conjuntoAutomatas.put(++idAutomata, automataGeneral);
            System.out.println("----------------------------------------");
            System.out.println("--- INFORMACION DEL AUTOMATA GENERAL ---");
            System.out.println("----------------------------------------");
            System.out.println("------------- EDO INICIAL --------------");
            System.out.println("----------------------------------------");
            Estado edoInicial = automataGeneral.getEstadoInicial();
            System.out.println("Ide: "+edoInicial.getIdentificador());
            System.out.println("Trancisiones: ");
            for(Transicion t: edoInicial.getTransiciones()){
                System.out.println("Va hacia: "+t.getEstadoDestino().getIdentificador()+" con simbolo: "+t.getSimboloFin());
            }System.out.println();
            System.out.println("\n----------------------------------------");
            System.out.println("----------- EDOS INTERMEDIOS -----------");
            System.out.println("----------------------------------------");
            Set<Estado> edos = automataGeneral.getEstados();
            for(Estado edoAux: edos){
                System.out.println("Ide: "+edoAux.getIdentificador());
                System.out.println("Trancisiones: ");
                for(Transicion taux: edoAux.getTransiciones()){
                    System.out.println("Va hacia: "+taux.getEstadoDestino().getIdentificador()+" con simbolo: "+taux.getSimboloFin());
                }System.out.println("");
            }
            System.out.println("\n----------------------------------------");
            System.out.println("------------- EDOS FINALES -------------");
            System.out.println("----------------------------------------");
            Set<Estado> edosFinales = automataGeneral.getEstadosFinales();
            for(Estado aux2: edosFinales){
                System.out.println("Ide: "+aux2.getIdentificador());
                System.out.println("Token: "+aux2.getToken());
                System.out.println("Trancisiones: ");
                for(Transicion taux2: aux2.getTransiciones()){
                    System.out.println("Va hacia: "+taux2.getEstadoDestino().getIdentificador()+" con simbolo: "+taux2.getSimboloFin());
                }System.out.println("");
            }
            System.out.println("\n----------------------------------------");
            System.out.println("--------------- ALFABETO ---------------");
            System.out.println("----------------------------------------");
            Set<Character> alfabeto = automataGeneral.getAlfabeto();
            System.out.println("Los simbolos son:");
            for(char c: alfabeto){
                System.out.print(c+", ");
            }System.out.println();
        }
        
    }//GEN-LAST:event_AutomataGeneralMouseClicked

    private void AutomataGeneralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutomataGeneralMouseExited
        resetAllColors();
    }//GEN-LAST:event_AutomataGeneralMouseExited

    private void AnalisisLexicoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalisisLexicoMouseMoved
        resetAllColors();
        setColorTF(AnalisisLexico);
    }//GEN-LAST:event_AnalisisLexicoMouseMoved

    private void AnalisisLexicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalisisLexicoMouseClicked
        
        VistaLexico vistalexico = new VistaLexico(this);
        vistalexico.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_AnalisisLexicoMouseClicked

    private void AnalisisLexicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalisisLexicoMouseExited
        resetAllColors();
    }//GEN-LAST:event_AnalisisLexicoMouseExited

    private void CalculadoraMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalculadoraMouseMoved
        // TODO add your handling code here:
        resetAllColors();
        setColorTF(Calculadora);
    }//GEN-LAST:event_CalculadoraMouseMoved

    private void CalculadoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalculadoraMouseClicked
        // TODO add your handling code here:
        VistaCalculadora vistacalculadora = new VistaCalculadora(this);
        vistacalculadora.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CalculadoraMouseClicked

    private void CalculadoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalculadoraMouseExited
        resetAllColors();
    }//GEN-LAST:event_CalculadoraMouseExited

    private void GeneradorPorERMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeneradorPorERMouseMoved
        resetAllColors();
        setColorTF(GeneradorPorER);
    }//GEN-LAST:event_GeneradorPorERMouseMoved

    private void GeneradorPorERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeneradorPorERMouseClicked
        VistaGeneradorAutomatas vga = new VistaGeneradorAutomatas(this, conjuntoAutomatas);
        vga.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_GeneradorPorERMouseClicked

    private void GeneradorPorERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeneradorPorERMouseExited
        resetAllColors();
    }//GEN-LAST:event_GeneradorPorERMouseExited

    public static void main(String []args){
        OperacionesAutomata m = new OperacionesAutomata();
        m.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnalisisLexico;
    private javax.swing.JTextField AutomataGeneral;
    private javax.swing.JToggleButton BTNSallir;
    private javax.swing.JTextField Calculadora;
    private javax.swing.JTextField CerraduraMult;
    private javax.swing.JTextField CerraduraOpcional;
    private javax.swing.JTextField CerraduraPositiva;
    private javax.swing.JTextField ConcatenacionAFN;
    private javax.swing.JTextField ConversionAFD;
    private javax.swing.JTextField CrearAFNBasico;
    private javax.swing.JLabel Exit;
    private javax.swing.JTextField GeneradorPorER;
    private javax.swing.JLabel LBLTitulo;
    private javax.swing.JPanel PanelContenido;
    private javax.swing.JPanel PanelTitulo;
    private javax.swing.JLabel SubtituloCerraduras;
    private javax.swing.JLabel SubtituloOperaciones;
    private javax.swing.JTextField UnionAFN;
    // End of variables declaration//GEN-END:variables
}
