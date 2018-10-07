
package generadorDeAutomatas;

import compiladores.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicGA {
    public static String cadena;
    public static AFD automata;
    public static int indice = 0;
    public static int indiceAnterior = 0;
    public static int indiceLastAcept = 0;
    public static EstadoSi estadoActual;
    
    public static void reset(){
        cadena = "";
        automata = null;
        indice = 0;
        indiceAnterior = 0;
        indiceLastAcept = 0;
        estadoActual = null;
    }
    
    public static TokensGA getToken() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        EstadoSi estadoActual = automata.getEstadoInicial();
        EstadoSi ultimoEstadoDeAceptacion = null;
        boolean bandera = false;
        indiceAnterior = indice;
        
        StringBuilder lexema = new StringBuilder();
        char c[] = cadena.toCharArray();
        
        //Verificamos si es el fin de cadena
        if(indice == cadena.length()){
            return new TokensGA("FIN", 0);
        }
        
        /*String expresionRegular = "(a|b)*";
        Pattern pat = Pattern.compile( expresionRegular );
        */
        while(indice < c.length){
            bandera = false;
            char caracter = c[indice];
            for(TransicionSi t : estadoActual.getTransiciones()){
                char caracterAuxI = t.getSimboloInicio();
                char caracterAuxF = t.getSimboloFin();
                /*if( (caracterAuxI == 'S') || (caracterAuxF == 'S') ){
                    
                        estadoActual = t.getEstadoDestino();
                        bandera = true;
                        lexema.append(caracter);
                        break;
                    Matcher mat1 = pat.matcher( Character.toString(caracterAuxI) );
                    Matcher mat2 = pat.matcher( Character.toString(caracterAuxF) );
                    if( mat1.matches() || mat2.matches() ){                    
                        estadoActual = t.getEstadoDestino();
                        bandera = true;
                        lexema.append(caracter);
                        break;
                    }
                    
                }else */if( (caracterAuxI == 'D') || (caracterAuxF == 'D') ){
                    if(Character.isDigit(caracter)){
                        estadoActual = t.getEstadoDestino();
                        bandera = true;
                        lexema.append(caracter);
                        break;
                    }
                }else if((caracterAuxI == caracter) || (caracterAuxF == caracter)){
                    estadoActual = t.getEstadoDestino();
                    bandera = true;
                    lexema.append(caracter);
                    break;
                }
            }
            if(bandera){
                if(estadoActual.getBandera()){
                    indiceLastAcept = indice;
                    ultimoEstadoDeAceptacion = estadoActual;
                }
            }else{
                if(ultimoEstadoDeAceptacion  != null){
                    indice = ++indiceLastAcept;
                    
                }else{
                    indice++;
                    return new TokensGA("ERROR",-1);
                }break;
            }indice++;
        }
        
        return new TokensGA(lexema.toString(), ultimoEstadoDeAceptacion.getToken());
    }
    
    public static void regresarToken()throws IOException, FileNotFoundException, ClassNotFoundException{
        indice = indiceAnterior;
    }
    
    public static AFD cargarObjeto(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(ruta);
        ObjectInputStream ois =  new ObjectInputStream(fis);
        AFD automata = (AFD)ois.readObject();
        return automata;
    }
    
    
}
