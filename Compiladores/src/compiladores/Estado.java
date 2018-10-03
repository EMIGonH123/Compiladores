package compiladores;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Estado implements Serializable{
    static int idConcurrent = 0;
    private int token;
    private int idEstado; //Id del estado
    private Set<Transicion> transiciones; //Transiciones asociadas
    private boolean bandera; //Bandera para saber si es edo de aceptacion
    
    public void setToken(int token){
        this.token = token;
    }
    public int getToken(){
        return this.token;
    }
    
    //Constructor para el estado
    public Estado(){
        idEstado = idConcurrent++;
        transiciones = new HashSet<Transicion>();
        transiciones.clear();
        bandera = false;
    }
    
    /***********/
    /* Getters */
    /***********/
    public int getIdentificador(){
        return this.idEstado;
    } 
    
    public Set<Transicion> getTransiciones(){
        return this.transiciones;
    }
    
    public boolean getBandera(){
        return this.bandera;
    }
    
    /***********/
    /* Setters */
    /***********/
    public void setTransicion(Transicion t){
        this.transiciones.add(t);
    }
    
    public void setBandera(boolean bandera){
        this.bandera = bandera;
    }
}
