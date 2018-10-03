package compiladores;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AFD implements Serializable{

    public EstadoSi getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(EstadoSi estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public Set<Character> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Set<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Set<EstadoSi> getEstados() {
        return estados;
    }

    public void setEstados(Set<EstadoSi> estados) {
        this.estados = estados;
    }

    public Set<EstadoSi> getEstadosDeAceptacion() {
        return estadosDeAceptacion;
    }

    public void setEstadosDeAceptacion(Set<EstadoSi> estadosDeAceptacion) {
        this.estadosDeAceptacion = estadosDeAceptacion;
    }
    public void agregarEstadoDeAceptacion(EstadoSi estadoDeAceptacion) {
        this.estadosDeAceptacion.add(estadoDeAceptacion);
    }
    
    public EstadoSi estadoInicial;
    public Set<Character> alfabeto;
    public Set<EstadoSi> estados;
    public Set<EstadoSi> estadosDeAceptacion;

    public AFD(){
        alfabeto = new HashSet<Character>();
        estados = new HashSet<EstadoSi>();
        estadosDeAceptacion = new HashSet<EstadoSi>();
    } 
}
