package generadorDeAutomatas;

import compiladores.Automata;
import compiladores.Estado;
import compiladores.Lexic;
import compiladores.Transicion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class GeneradorDeAutomatas {
    
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
    
    public static boolean GeneradorAutomata( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( E( a ) ){
            System.out.println("Dentro de E en Generador Automata");
            return true;
        }
        System.out.println("Dentro de Generador Automata");
        return false;
    }
    
    public static boolean E( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( T( a ) ){
            System.out.println("Dentro de T en E");
            if( Ep( a ) ){
                System.out.println("Dentro de Ep en E");
                return true;
            }
        }
        System.out.println("Dentro de E");
        return false;
    }
    
    public static boolean Ep( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        TokensGA t = LexicGA.getToken();
        Automata b = new Automata();
        if( t.token == Tokens.OR ){
            if( T( b ) ){
                System.out.println("Dentro de T en Ep");
                
                //System.out.println("ANTES\n\n");
                //imprimirInfo(a);
                a.unionAFN(b);
                //System.out.println("DESPUES\n\n");
                //imprimirInfo(a);
                if( Ep( a ) ){
                    System.out.println("Dentro de Ep en Ep");
                    return true;
                }
            }
        }
        LexicGA.regresarToken();
        System.out.println("Dentro de Epsilon en Ep");
        return true;
    }
    
    public static boolean T( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( C( a ) ){
            System.out.println("Dentro de C en T");
            if( Tp( a ) ){
                System.out.println("Dentro de Tp en T");
                return true;
            }
        }
        System.out.println("Dentro de T");
        return false;
    }
    
    public static boolean Tp( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        TokensGA t = LexicGA.getToken();
        Automata b = new Automata();
        if( t.token == Tokens.AMPERSAN ){
            if( C( b ) ){
                System.out.println("Dentro de C en Tp");
                //System.out.println("ANTES\n\n");
                //imprimirInfo(a);
                a.concatenacionAFN(b);
                //System.out.println("DESPUES\n\n");
                //imprimirInfo(a);
                if( Tp( a ) ){
                    System.out.println("Dentro de Tp en Tp");
                    return true;
                }
            }
        }
        LexicGA.regresarToken();
        System.out.println("Dentro de Epsilon en Tp");
        return true;
    }
    
    public static boolean C( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( F( a ) ){
            System.out.println("Dentro de F en C");
            if( Cp( a ) ){
                System.out.println("Dentro de Cp en C");
                return true;
            }
        }
        System.out.println("Dentro de C");
        return false;
    }
    
    public static boolean Cp( Automata a ) throws IOException, FileNotFoundException, ClassNotFoundException{
        TokensGA t = LexicGA.getToken();
        switch( t.token ){
            case Tokens.CPOSITIVA:
                //System.out.println("ANTES\n\n");
                //imprimirInfo(a);
                a.cerraduraPositiva();
                //System.out.println("DESPUES\n\n");
                //imprimirInfo(a);
                break;
                
            case Tokens.CKLEEN:
                //System.out.println("ANTES\n\n");
                //imprimirInfo(a);
                a.cerraduraUniversal();
                //System.out.println("DESPUES\n\n");
                //imprimirInfo(a);
                break;
                
            case Tokens.CINTERROGATIVA:
                //System.out.println("ANTES\n\n");
                //imprimirInfo(a);
                a.cerraduraInterrogacion();
                //System.out.println("DESPUES\n\n");
                //imprimirInfo(a);
                break;
                
            default:
                //Falta el codigo
                LexicGA.regresarToken();
                System.out.println("Dentro de Epsilon en Cp");
                return true;
            
        }
        if( Cp( a ) ){
            System.out.println("Dentro de Cp en Cp");
            return true;
        }
        System.out.println("Dentro de Cp");
        return false;
    }
    
    public static boolean F( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        TokensGA t = LexicGA.getToken();
        switch( t.token ){
            case Tokens.PARIZQ:
                if( E( a ) ){
                    TokensGA t2 = LexicGA.getToken();
                    if( t2.token == Tokens.PARDER ){
                        System.out.println("Dentro de E en F");
                        return true;
                    }
                }
            case Tokens.SIMBOLO:
                System.out.println("Dentro de Simbolo en F");
                a.crearBasico((char)t.lexema.charAt(0));
                //System.out.println("DESPUES\n\n");
                //imprimirInfo(a);
                return true;
        }
        System.out.println("Dentro de F");
        return false;
    
    }
    
}
