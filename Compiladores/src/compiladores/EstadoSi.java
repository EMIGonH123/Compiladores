package compiladores;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

public class EstadoSi implements Serializable{
    private static int idEstadoActual = 0;
    private int idEstado;
    private Set<Estado> estados;
    private Set<TransicionSi> transiciones;
    private boolean bandera;
    private int token;
    
    public int getToken(){
        return this.token;
    }
    
    public void setToken(int token){
        this.token = token;
    }
    
    public EstadoSi(){
        idEstado = idEstadoActual++;
        estados = new HashSet<Estado>();
        transiciones = new HashSet<TransicionSi>();
        bandera = false;
        token = 0;
    }
    public EstadoSi(int idEstado){
        this.idEstado = idEstado;
        estados = new HashSet<Estado>();
        transiciones = new HashSet<TransicionSi>();
        bandera = false;
        token = 0;
    }
    public void setEstados(Set<Estado> estados){
        this.estados = estados;
    }
    
    public void setTransiciones(Set<TransicionSi> transiciones){
        this.transiciones = transiciones;
    }
    public void agregarTransiciones(TransicionSi transicion){
        this.transiciones.add(transicion);
    }
    public Set<Estado> getEstados(){
        return this.estados;
    }
    public Set<TransicionSi> getTransiciones(){
        return this.transiciones;
    }
    public void setBandera(boolean bandera){
        this.bandera = bandera;
    }
    public boolean getBandera(){
        return this.bandera;
    }
    
    public int getIdEstado(){
        return this.idEstado;
    }
       
}
