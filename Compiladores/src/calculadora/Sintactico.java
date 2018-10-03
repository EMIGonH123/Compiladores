package calculadora;

import compiladores.Lexic;
import compiladores.Token;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;

public class Sintactico {
    public static float f = 0;
    public static boolean ASDR(FlotanteEmi f) throws IOException, FileNotFoundException, ClassNotFoundException{
        if( E(f) ){
            if(Lexic.getToken().token == 0){
                return true;
            }
        }return false;
    }
    public static boolean E(FlotanteEmi f) throws IOException, FileNotFoundException, ClassNotFoundException{
        if( T(f) ){
            if( Ep(f) ){
                return true;
            }
        }
        return false;
    }
    
    public static boolean Ep(FlotanteEmi f)throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t;
        t = Lexic.getToken();
        FlotanteEmi f2 = new FlotanteEmi(Float.parseFloat(t.lexema.toString()));
        if( (t.token == TokenCalculadora.MAS)  || (t.token == TokenCalculadora.MENOS) ){
            if( T( f2 ) ){
                f = new FlotanteEmi();
                float aux = f.getValor();
                aux += ( (t.token == TokenCalculadora.MAS)?f2.getValor():(-f2.getValor()) );
                f.setValor(aux);
                
                if( Ep( f ) ){
                    return true;
                }
            }
        }return false;
    }
    
    public static boolean T( FlotanteEmi f )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( F(f) ){
            if( Tp(f) ){
                return true;
            }
        }return false;
    }
    
    public static boolean  Tp( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        Token t = Lexic.getToken();
        FlotanteEmi f2 = new FlotanteEmi(Float.parseFloat(t.lexema));
        if( (t.token == TokenCalculadora.PROD) || ( t.token == TokenCalculadora.DIV ) ){
            if( F( f2 ) ){
                f = new FlotanteEmi();
                float aux = f.getValor();
                aux *= ((t.token == TokenCalculadora.PROD)?f2.getValor():(1.0/f2.getValor())) ;
                f.setValor(aux); 
                if( Tp( f ) ){
                    return true;
                }
            }
        }return false;
    }
    
    public static boolean F( FlotanteEmi f ) throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t  = Lexic.getToken();
        switch( t.token ){
            case TokenCalculadora.PIZQ:
                if( E(f) ){
                    Token t2 = Lexic.getToken();
                    if( t2.token == TokenCalculadora.PDER ){
                        return true;
                    }
                }
            case TokenCalculadora.NUM:
                //f = Float.parseFloat(t.lexema);
                return true;
            /*case TokenCalculadora.SIN:
                return true;
            case TokenCalculadora.COS:
                return true;
            case TokenCalculadora.TAN:
                return true;
            case TokenCalculadora.COT:
                return true;
            case TokenCalculadora.SEC:
                return true;
            case TokenCalculadora.CSC:
                return true;
            case TokenCalculadora.ARCSIN:
                return true;
            case TokenCalculadora.ARCCOS:
                return true;
            case TokenCalculadora.ARCTAN:
                return true;
            case TokenCalculadora.ARCCOT:
                return true;
            case TokenCalculadora.ARCSEC:
                return true;
            case TokenCalculadora.ARCCSC:
                return true;
            case TokenCalculadora.SINH:
                return true;
            case TokenCalculadora.COSH:
                return true;
            case TokenCalculadora.TANH:
                return true;
            case TokenCalculadora.COTH:
                return true;
            case TokenCalculadora.SECH:
                return true;
            case TokenCalculadora.CSCH:
                return true;
            case TokenCalculadora.LOG:
                return true;
            case TokenCalculadora.EXP:
                return true;
            */
            
        }return true;
    }
}
