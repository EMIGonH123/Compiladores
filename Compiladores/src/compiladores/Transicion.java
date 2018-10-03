package compiladores;

import java.io.Serializable;

public class Transicion implements Serializable{
    //Variables que vamos a necesitar para hacer la transicion
    private char inicio;
    private char fin;
    private Estado destino;
    
    /*Cuando neceditamos solo una transicion 
    con un solo digito:
    Ejemplo:   ---"S"---> */
    public Transicion(char c, Estado destino){
        //El inicion y el fin deben ser los mismos
        inicio = c;
        fin = c;
        this.destino = destino;
    }
    
    /*Cuando neceditamos solo una transicion 
    con un rango de valores:
    Ejemplo:   ---("A-M")---> */
    public Transicion(char inicio, char fin, Estado destino){
        this.inicio = inicio;
        this.fin = fin;
        this.destino = destino;
    }
    
    /***********/
    /* Getters */
    /***********/
    public Estado getEstadoDestino(){
        return this.destino;
    }
    
    public char getSimboloInicio(){
        return this.inicio;
    }
    
    public char getSimboloFin(){
        return this.fin;
    }
    
    /***********/
    /* Setters */
    /***********/
    public void setEstadoDestino(Estado destino){
        this.destino = destino;
    }
    
    public void setSimboloInicio(char inicio){
        this.inicio = inicio;
    }
  
    public void setSimboloFin(char fin){
        this.fin = fin;
    }

}
