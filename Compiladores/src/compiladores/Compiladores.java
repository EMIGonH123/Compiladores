package compiladores;

import java.util.Scanner;
import java.util.Set;


public class Compiladores {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Automata a = new Automata('+');
        Automata b = new Automata('-');
        a.unionAFN(b);
        a.cerraduraInterrogacion();
        Automata c = new Automata('D');
        c.cerraduraPositiva();
        a.concatenacionAFN(c);
        
        
        Estado edoInicial = a.estadoInicial;
        Set<Transicion> t1 = edoInicial.getTransiciones();
        
        Set<Estado> edosI = a.getEstados();
        
        Set<Estado> edosF = a.getEstadosFinales();
        
        System.out.println("EDO INICIAL");
        System.out.println("El estado inicial es: "+ edoInicial.getIdentificador());
        System.out.println("Es de aceptacion: "+ edoInicial.getBandera());
        
        System.out.println("-------------------------");
        System.out.println("Transiciones del edo: "+ edoInicial.getIdentificador());
        System.out.println("-------------------------");
        for(Transicion t: t1){
            System.out.println("Va hacia edo: "+t.getEstadoDestino().getIdentificador()+" con simbolo: "+ t.getSimboloFin());
        }System.out.println();
        System.out.println("\n\n");
        
        
        System.out.println("EDOS INTERMEDIOS");
        for( Estado e : edosI){
            System.out.println("El estado intermedio es: "+ e.getIdentificador());
            System.out.println("Es de aceptacion: "+ e.getBandera());
            Set<Transicion> t2 = e.getTransiciones();
            System.out.println("-------------------------");
            System.out.println("Transiciones del edo: "+ e.getIdentificador());
            System.out.println("-------------------------");
            for(Transicion t: t2){
                System.out.println("Va hacia edo: "+t.getEstadoDestino().getIdentificador()+" con simbolo: "+ t.getSimboloFin());
            }System.out.println();
        }System.out.println("\n\n");
        
        
        
        System.out.println("EDOS FINALES");
        for( Estado e : edosF){
            System.out.println("El estado final es: "+ e.getIdentificador());
            System.out.println("Es de aceptacion: "+ e.getBandera());
            Set<Transicion> t2 = e.getTransiciones();
            System.out.println("-------------------------");
            System.out.println("Transiciones del edo: "+ e.getIdentificador());
            System.out.println("-------------------------");
            for(Transicion t: t2){
                System.out.println("Va hacia edo: "+t.getEstadoDestino().getIdentificador()+" con simbolo: "+ t.getSimboloFin());
            }System.out.println();
        }
        
        
        
        System.out.println("MOVER");
        Set<Estado> x = a.estados;
        for(Estado i: x){
            if(i.getIdentificador() == 2){
                Set<Estado> xx = a.mover(i,'-');
                if(xx.isEmpty()){
                    System.out.println("No hay estado al cual moverse con ese simbolo");
                }else{
                    for(Estado xxx : xx){
                        System.out.println("Estado: "+ xxx.getIdentificador());
                    }
                }
                
            }
        }
        
    }    
}