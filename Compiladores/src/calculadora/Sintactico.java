package calculadora;

import compiladores.Lexic;
import compiladores.Token;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;

public class Sintactico {
    public static FlotanteEmi f;
    
    public static boolean ASDR( ) throws IOException, FileNotFoundException, ClassNotFoundException{
        if( E(f) ){
            if(Lexic.getToken().token == 0){
                return true;
            }
        }return false;
    }
    public static boolean E( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        if( T(f) ){
            if( Ep(f) ){
                //System.out.println("En E: "+f.getValor());
                return true;
            }
        }
        return false;
    }
    
    public static boolean Ep( FlotanteEmi f )throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t;
        t = Lexic.getToken();
        //FlotanteEmi f2 = new FlotanteEmi(Float.parseFloat(t.lexema.toString()));
        //FlotanteEmi f2 =null;
        if( (t.token == TokenCalculadora.MAS)  || (t.token == TokenCalculadora.MENOS) ){
            Token t2 = Lexic.getToken();
            FlotanteEmi f2 = new FlotanteEmi(Float.parseFloat(t2.lexema.toString()));
            if( T( f2 ) ){
                //f = new FlotanteEmi();
                
                float aux = f.getValor();
                System.out.println("En Ep, antes de operacion: "+aux);
                aux += ( (t.token == TokenCalculadora.MAS)?f2.getValor():(-f2.getValor()) );
                System.out.println("En Ep, despues de operacion: "+aux);
                f.setValor(aux);
                
                if( Ep( f ) ){
                    return true;
                }
            }
        }
        Lexic.regresarToken();
        return true;
    }
    
    public static boolean T( FlotanteEmi f )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( F(f) ){
            if( Tp(f) ){
                //System.out.println("En T: "+f.getValor());
                return true;
            }
        }return false;
    }
    
    public static boolean  Tp( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        Token t = Lexic.getToken();
        //FlotanteEmi f2 = null ;
        if( (t.token == TokenCalculadora.PROD) || ( t.token == TokenCalculadora.DIV ) ){
            Token t2 = Lexic.getToken();
            FlotanteEmi f2 = new FlotanteEmi(Float.parseFloat(t2.lexema.toString()));
            if( F( f2 ) ){
                //f = new FlotanteEmi();
                float aux = f.getValor();
                System.out.println("En Tp, antes de operacion: "+aux);
                aux *= ((t.token == TokenCalculadora.PROD)?f2.getValor():(1.0/f2.getValor())) ;
                System.out.println("En Tp, despues de operacion: "+aux);
                f.setValor(aux); 
                if( Tp( f ) ){
                    return true;
                }
            }
        }
        Lexic.regresarToken();
        return true;
    }
    
    public static boolean F( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t  = Lexic.getToken();
        Float aux;
        switch( t.token ){
            case TokenCalculadora.PIZQ:
                if( E(f) ){
                    Token t2 = Lexic.getToken();
                    if( t2.token == TokenCalculadora.PDER ){
                        return true;
                    }
                }
            case TokenCalculadora.NUM:
                aux = Float.parseFloat(t.lexema);
                System.out.println("En F: "+aux);
                f = new FlotanteEmi(aux);
                //f.setValor(aux);
                return true;
            
            
        }return false;
    }
}
