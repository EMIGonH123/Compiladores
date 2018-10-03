package compiladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;
import javax.swing.JOptionPane;

public class Automata implements Serializable{
    public Estado estadoInicial;
    public Set<Character> alfabeto;
    public Set<Estado> estados;
    public Set<Estado> estadosFinales;
    
    public Automata(){
        alfabeto = new HashSet<>();
        estados = new HashSet<>();
        estadosFinales = new HashSet<>();
    }
    
    public Automata(char c){
        /* Elementos que vamos a necesetar para hacer el
        Automata simple */
        alfabeto = new HashSet<>();
        estados = new HashSet<>();
        estadosFinales = new HashSet<>();
        Estado edoInicial = new Estado();
        Estado edoFinal = new Estado();
        
        edoInicial.setTransicion(new Transicion(c, edoFinal));
        edoFinal.setBandera(true);
        
        this.setEstadoInicial(edoInicial);
        this.agregarEstadoFinal(edoFinal);
        this.agregarEstados(edoInicial);
        this.agregarEstados(edoFinal);
        this.setAlfabeto(c);
        
    }
    
    /**************/
    /* Cerraduras */
    /**************/
    public Automata cerraduraPositiva(){
        //Estado auxiliares
        Estado edoInicial = new Estado();
        Estado edoFinal = new Estado();
        edoInicial.setTransicion(new Transicion('e', this.estadoInicial));
        for(Estado e : this.estadosFinales){
            e.setTransicion(new Transicion('e', edoFinal));
            e.setTransicion(new Transicion('e', this.estadoInicial));
            e.setBandera(false);
        }
        this.estadosFinales.clear();
        edoFinal.setBandera(true);
        this.estadoInicial = edoInicial;
        this.estadosFinales.add(edoFinal);
        this.estados.add(edoInicial);
        this.estados.add(edoFinal);
        return this;
    }
    
    public static Automata crearAutomataGeneral(Hashtable<Integer,Automata> automatas){
        Automata nuevoAutomata = new Automata();
        Estado edoInicial = new Estado();
        nuevoAutomata.setEstadoInicial(edoInicial);
        nuevoAutomata.agregarEstados(edoInicial);
        
        Enumeration<Integer> k = automatas.keys();
        Object clave;
        while(k.hasMoreElements()){
            clave  = k.nextElement();
            Automata automataAux = automatas.get((Integer)clave);
            nuevoAutomata.getEstadoInicial().setTransicion(new Transicion('e',automataAux.getEstadoInicial()));
            for(Estado edoAux: automataAux.getEstados()){
                nuevoAutomata.agregarEstados(edoAux);
                if(edoAux.getBandera()){
                    String cadena = JOptionPane.showInputDialog("Token para Automata "+(Integer)clave);
                    boolean bandera = false;
                    do{
                        if( cadena.equals("") ){
                            JOptionPane.showMessageDialog(null, "Cadena vacia", "WARNING", JOptionPane.WARNING_MESSAGE);
                            bandera = true;
                        }else{
                            try {
                                int token = Integer.parseInt(cadena);
                                edoAux.setToken(token);
                                bandera = false;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "La cadena corresponde a un valor decimal", "ERROR", JOptionPane.ERROR_MESSAGE);
                                bandera = true;
                            }
                        }
                    }while(bandera);
                    
                    nuevoAutomata.agregarEstadoFinal(edoAux);
                }
            }
            nuevoAutomata.setAlfabeto(automataAux.getAlfabeto());
            automataAux = null;
        }
        
        return nuevoAutomata;
    }
    
    public static Set<Estado> cerraduraEpsilon(Estado e){
        Set<Estado> conjunto = new HashSet<Estado>();
        Stack<Estado> pila = new Stack();
        Estado edoAux = new Estado();
        pila.clear();
        conjunto.clear();
        
        pila.push(e);
        while(!pila.empty()){
            edoAux = pila.pop();
            if( !conjunto.contains(edoAux) ){
                conjunto.add(edoAux);
                for(Transicion t : edoAux.getTransiciones()){
                    if( (t.getSimboloInicio() == 'e') && (t.getSimboloFin() == 'e') ){
                        pila.push(t.getEstadoDestino());
                    }
                }
            }
        }
        return conjunto;
    }

    public static Set<Estado> cerraduraEpsilon(Set<Estado> estados){
        Set<Estado> conjunto = new HashSet<Estado>();
        
        conjunto.clear();
        for(Estado edo : estados){
            conjunto.addAll(cerraduraEpsilon(edo));
        }
        return conjunto;
    }
    
    public static Set<Estado> mover(Estado estado, char s){
        Set<Estado> conjunto = new HashSet<Estado>();
        conjunto.clear();
        for(Transicion t: estado.getTransiciones()){
            if( (t.getSimboloInicio() == s) && (t.getSimboloFin() == s) ){
                conjunto.add(t.getEstadoDestino());
            }
        }
        return conjunto;
    }
    
    public static Set<Estado> mover(Set<Estado> estados, char s){
        Set<Estado> conjunto = new HashSet<Estado>();
        conjunto.clear();
        for(Estado e: estados){
            conjunto.addAll(mover(e,s));
        }
        return conjunto;
    }
    
    public static Set<Estado> ir_A(Estado estado, char s){
        return cerraduraEpsilon(mover(estado, s));
    }
    
    public static Set<Estado> ir_A(Set<Estado> estados, char s){
        return cerraduraEpsilon(mover(estados, s));
    }
    
    public  Automata cerraduraUniversal(){
        Estado edoInicial = new Estado();
        Estado edoFinal = new Estado();
        
        edoFinal.setBandera(true);
        edoInicial.setTransicion(new Transicion('e', this.estadoInicial));
        edoInicial.setTransicion(new Transicion('e', edoFinal));
        for(Estado e: this.estadosFinales){
            e.setTransicion(new Transicion('e', edoFinal));
            e.setTransicion(new Transicion('e', this.estadoInicial));
            e.setBandera(false);
        }this.estadosFinales.clear();
        this.estadosFinales.add(edoFinal);
        this.estadoInicial = edoInicial;
        this.estados.add(edoInicial);
        this.estados.add(edoFinal);
        return this;
    }
    public Automata cerraduraInterrogacion(){
        Estado edoInicial = new Estado();
        Estado edoFinal = new  Estado();
        edoFinal.setBandera(true);
        edoInicial.setTransicion(new Transicion('e', this.estadoInicial));
        edoInicial.setTransicion(new Transicion('e',edoFinal));
        for(Estado e: this.estadosFinales){
            e.setTransicion(new Transicion('e', edoFinal));
            e.setBandera(false);
        }
        this.estadosFinales.clear();
        this.estadosFinales.add(edoFinal);
        this.estadoInicial = edoInicial;
        this.estados.add(edoInicial);
        this.estados.add(edoFinal);
        return this;
    }
   
    /***********************/
    /* Operaciones con AFN */
    /***********************/
    public Automata concatenacionAFN(Automata automata){
        for(Estado e: this.estadosFinales){
                for(Transicion t: automata.estadoInicial.getTransiciones())
                        e.setTransicion(t);
                e.setBandera(false);
        }
        automata.estados.remove(automata.estadoInicial);
        this.estadosFinales.clear();
        this.estadosFinales.addAll(automata.estadosFinales);
        this.alfabeto.addAll(automata.getAlfabeto());
        this.estados.addAll(automata.estados);
        automata = null;

        return this; 
    }
    
    public Automata unionAFN(Automata automata){
        Estado edoInicial = new Estado();
        Estado edoFinal = new Estado();
        edoFinal.setBandera(true);
        edoInicial.setTransicion(new Transicion('e', this.estadoInicial));
        edoInicial.setTransicion(new Transicion('e', automata.estadoInicial));
        for(Estado e: this.estadosFinales){
            e.setTransicion(new Transicion('e', edoFinal));
            e.setBandera(false);
        }
        for(Estado e: automata.estados){
            this.agregarEstados(e);
        }

        for(Estado e: automata.estadosFinales){
            e.setTransicion(new Transicion('e', edoFinal));
            e.setBandera(false);
        }
        this.estadosFinales.clear();
        automata.estadosFinales.clear();
        
        
        this.estadoInicial = edoInicial;
        this.agregarEstados(edoInicial);
        
        this.estadosFinales.add(edoFinal);
        this.agregarEstados(edoFinal);
        this.alfabeto.addAll(automata.getAlfabeto());
        //Aqui va la parte del alfabeto
        automata = null;
        return this;
    }
    
    public static void construccionAFD(Automata a, String nombreObjeto) throws IOException{
        AFD automata = new AFD();
        Set<EstadoSi> conjunto = new HashSet<EstadoSi>();
        Stack<EstadoSi> pila = new Stack<EstadoSi>();
        Set<Estado> aux3;
        EstadoSi edoInicial = new EstadoSi();
        EstadoSi aux1, aux2;
        boolean bandera = false, bandera2 = false;
        
        //Limpiamos los arreglos
        pila.clear();
        conjunto.clear();
        
        edoInicial.setEstados(cerraduraEpsilon(a.getEstadoInicial()));
        pila.push(edoInicial);
        conjunto.add(edoInicial);
        
        System.out.println("--------------------------");
        System.out.println("-- INICIO DEL ALGORITMO --");
        System.out.println("--------------------------");
        System.out.print("Conjunto inicial S"+edoInicial.getIdEstado()+": ");
        System.out.print("{");
        for(Estado e: edoInicial.getEstados()){
            System.out.print(e.getIdentificador()+", ");
        }System.out.println("}\n");
        
        while( !pila.empty()){
            aux1 = (EstadoSi)pila.pop();
            Set<Estado> edosAuxIniciales = aux1.getEstados();
            for(Character c: a.getAlfabeto()){
                System.out.println("Analizando con '"+c+"'");
                
                aux3 = (Set<Estado>)ir_A(edosAuxIniciales, c);
                bandera2 = (aux3 == null) || (aux3.isEmpty());
                if( bandera2 != true ){
                    bandera = true;
                    
                    System.out.print("Conjunto para comparar: ");
                    System.out.print("{");
                    for(Estado e: aux3){
                        System.out.print(e.getIdentificador()+", ");
                    }System.out.println("}");
                    
                    for(EstadoSi es : conjunto){
                        System.out.println("Analizando S"+ es.getIdEstado() + " con simbolo "+c);
                        if(es.getEstados().equals(aux3)){
                            System.out.println("El conjunto para comparar es igual al conjunto S"+es.getIdEstado()+"\n");
                            aux1.getTransiciones().add(new TransicionSi(c,es));
                            bandera = false;
                        }
                    }
                    if(bandera == true){

                        aux2 = new EstadoSi();
                        aux2.setEstados(aux3);
                        for(EstadoSi es: conjunto){
                            if( es.getEstados().equals(aux1.getEstados()) ){
                                es.agregarTransiciones(new TransicionSi(c,aux2));
                            }
                        }
                        System.out.println("El conjunto fue diferente, agregando el S"+aux2.getIdEstado()+"\n");
                        
                        conjunto.add(aux2);
                        pila.push(aux2);
                    }
                }

            }
        }
        
        automata.setEstadoInicial(edoInicial);
        automata.setEstados(conjunto);
        for(EstadoSi si: automata.getEstados()){
            for(Estado e: si.getEstados()){
                if(e.getBandera()){
                    si.setBandera(true);
                    automata.agregarEstadoDeAceptacion(si);
                    si.setToken(e.getToken());
                }
            }
        }
        
        //Agregamos el alfabeto
        for(Character ch: a.alfabeto){
            automata.alfabeto.add(ch);
        }
        
        System.out.println("--------------------------------");
        System.out.println("------ CONSTRUCCION AFD  -------");
        imprimirInfo(automata);
        System.out.println("------------------------------");
        System.out.println("-- Guardando el AFD(Objeto) --");
        System.out.println("------------------------------");
        guardarObjeto(automata, nombreObjeto+".txt");
    }
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
    
    
    
    public static void guardarObjeto(AFD automata, String nombre) throws FileNotFoundException, IOException{
        FileOutputStream foi = new FileOutputStream(nombre);
        ObjectOutputStream oos = new ObjectOutputStream(foi);
        oos.writeObject(automata);
        oos.close();
    }
    
    public Estado getEstadoInicial(){
        return this.estadoInicial;
    }
    public Set<Character> getAlfabeto(){
        return this.alfabeto;
    }
    
    public Set<Estado> getEstados(){
        return this.estados;
    }
    
    public Set<Estado> getEstadosFinales(){
        return this.estadosFinales;
    }
    
    public void setEstadoInicial(Estado estadoInicial){
        this.estadoInicial = estadoInicial;
    }
    
    public void setAlfabeto(char c){
        this.alfabeto.add(c);
    }
    public void setAlfabeto(Set<Character> c){
        this.alfabeto.addAll(c);
    }
    
    public void agregarEstados(Estado estado){
        this.estados.add(estado);
    }
    
    public void agregarEstadoFinal(Estado estado){
        this.estadosFinales.add(estado);
    }
    
}
