
package compiladores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Lexic {
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
    
    public static Token getToken() throws IOException, FileNotFoundException, ClassNotFoundException{
        
        EstadoSi estadoActual = automata.getEstadoInicial();
        EstadoSi ultimoEstadoDeAceptacion = null;
        boolean bandera = false;
        indiceAnterior = indice;
        
        StringBuilder lexema = new StringBuilder();
        char c[] = cadena.toCharArray();
        
        //Verificamos si es el fin de cadena
        if(indice == cadena.length()){
            return new Token("FIN", 0);
        }
        
        while(indice < c.length){
            bandera = false;
            char caracter = c[indice];
            for(TransicionSi t : estadoActual.getTransiciones()){
                if( (t.getSimboloInicio() == 'D') || (t.getSimboloFin() == 'D') ){
                    if(Character.isDigit(caracter)){
                        estadoActual = t.getEstadoDestino();
                        bandera = true;
                        lexema.append(caracter);
                        break;
                    }
                }else if((t.getSimboloFin() == caracter) || (t.getSimboloInicio() == caracter)){
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
                    return new Token("ERROR",-1);
                }break;
            }indice++;
        }
        
        return new Token(lexema.toString(), ultimoEstadoDeAceptacion.getToken());
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
