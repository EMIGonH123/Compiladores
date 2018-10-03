package generadorDeAutomatas;

import compiladores.Automata;
import compiladores.Lexic;
import compiladores.Token;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GeneradorDeAutomatas {
    
    public static boolean GeneradorAutomata( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( E(a) ){
            return true;
        }return false;
    }
    
    public static boolean E( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( T(a) ){
            if( Ep(a) ){
                return true;
            }
        }
        return false;
    }
    
    public static boolean Ep( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t = Lexic.getToken();
        Automata b = new Automata( t.lexema.charAt(0) );
        if( t.token == Tokens.OR ){
            if( T(b) ){
                a.unionAFN(b);
                if( Ep(a) ){
                    return true;
                }
            }
        }return true;
    }
    
    public static boolean T( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( C(a) ){
            if( Tp(a) ){
                return true;
            }
        }return false;
    }
    
    public static boolean Tp( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t = Lexic.getToken();
        Automata b = new Automata( t.lexema.charAt(0) );
        if( t.token == Tokens.AMPERSAN ){
            if( C(b) ){
                a.concatenacionAFN(b);
                if( Tp(a) ){
                    return true;
                }
            }
        }return true;
    }
    
    public static boolean C( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        if( F(a) ){
            if( Cp(a) ){
                return true;
            }
        }return false;
    }
    
    public static boolean Cp( Automata a ) throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t = Lexic.getToken();
        switch( t.token ){
            case Tokens.CPOSITIVA:
                a.cerraduraPositiva();
                break;
            case Tokens.CKLEEN:
                a.cerraduraUniversal();
                break;
            case Tokens.CINTERROGATIVA:
                a.cerraduraInterrogacion();
                break;
            default:
                //Falta el codigo
                return true;
            
        }
        if( Cp(a) ){
            return true;
        }return false;
    }
    
    public static boolean F( Automata a )throws IOException, FileNotFoundException, ClassNotFoundException{
        Token t = Lexic.getToken();
        switch( t.token ){
            case Tokens.PARIZQ:
                if( E(a) ){
                    Token t2 = Lexic.getToken();
                    if( t2.token == Tokens.PARDER ){
                        return true;
                    }
                }
            case Tokens.SIMBOLO:
                a = new Automata( t.lexema.charAt(0) );
                return true;
        }
        return false;
    
    }
    
}
