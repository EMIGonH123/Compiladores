package calculadora;

import compiladores.Lexic;
import compiladores.Token;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Sintactico {
    public static StringBuilder resultadoLexico = new StringBuilder();
    public static void limpiarResultadoLexico(){
        resultadoLexico.replace(0, resultadoLexico.length(),"");
    }
    public static boolean ASDR( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        if( E(f) ){
            System.out.println("Dentro de E en ASDR");
            if(Lexic.getToken().token == 0){
                return true;
            }
        }
        System.out.println("Dentro de ASDR");
        return false;
    }
    public static boolean E( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        if( T(f) ){
            System.out.println("Dentro de T en E");
            if( Ep(f) ){
                System.out.println("Dentro de EP en E");
                return true;
            }
        }
        System.out.println("Dentro de E");
        return false;
    }
    
    public static boolean Ep( FlotanteEmi f )throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t = Lexic.getToken();
        resultadoLexico.append("Lexema: "+t.lexema+"\n"+"Token: "+t.token+"\n\n");
        if( (t.token == TokenCalculadora.MAS)  || (t.token == TokenCalculadora.MENOS) ){
            float aux = f.getValor();
            FlotanteEmi f2 = new FlotanteEmi();
            if( T( f2 ) ){
                System.out.println("Dentro de T en Ep");
                
                System.out.println("En Ep, antes de operacion: "+aux);
                aux += ( (t.token == TokenCalculadora.MAS) ? f2.getValor() : (-f2.getValor()) );
                System.out.println("En Ep, despues de operacion: "+aux);
                f.setValor(aux);
                
                if( Ep( f ) ){
                    System.out.println("Dentro de Ep en Ep");
                    return true;
                }
            }
        }
        Lexic.regresarToken();
        System.out.println("Dentro de Epsilon en Ep");
        return true;
    }
    
    public static boolean T( FlotanteEmi f )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( F(f) ){
            System.out.println("Dentro de F en T");
            if( Tp(f) ){
                System.out.println("Dentro de Tp en T");
                return true;
            }
        }
        System.out.println("Dentro de T");
        return false;
    }
    
    public static boolean  Tp( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        Token t = Lexic.getToken();
        resultadoLexico.append("Lexema: "+t.lexema+"\n"+"Token: "+t.token+"\n\n");
        
        if( (t.token == TokenCalculadora.PROD) || ( t.token == TokenCalculadora.DIV ) ){
            float aux = f.getValor();
            FlotanteEmi f2 = new FlotanteEmi();
            if( F( f2 ) ){
                System.out.println("Dentro de F en Tp");
                System.out.println("En Tp, antes de operacion: "+aux);
                aux *= ((t.token == TokenCalculadora.PROD)?f2.getValor():(1.0/f2.getValor())) ;
                System.out.println("En Tp, despues de operacion: "+aux);
                f.setValor(aux); 
                if( Tp( f ) ){
                    System.out.println("Dentro de Tp en Tp");
                    return true;
                }
            }
        }
        Lexic.regresarToken();
        System.out.println("Dentro de Epsilon en Tp");
        return true;
    }
    
    public static boolean F( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t  = Lexic.getToken();
        resultadoLexico.append("Lexema: "+t.lexema+"\n"+"Token: "+t.token+"\n\n");
        float aux;
        
        switch( t.token ){
            case TokenCalculadora.PIZQ:
                if( E(f) ){
                    System.out.println("Dentro de E en F");
                    Token t2 = Lexic.getToken();
                    resultadoLexico.append("Lexema: "+t2.lexema+"\n"+"Token: "+t2.token+"\n\n");
                    if( t2.token == TokenCalculadora.PDER ){
                        return true;
                    }
                }
            case TokenCalculadora.NUM:
                System.out.println("Dentro de NUM en F");
                aux = Float.parseFloat(t.lexema);
                System.out.println("En F: "+aux);
                f.setValor(aux);
                return true;
            
            
        }
        System.out.println("Dentro de F");
        return false;
    }
}
