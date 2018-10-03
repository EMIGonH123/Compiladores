package calculadora;

public class FlotanteEmi {
    public float v1;
    FlotanteEmi(){
        v1 = 0;
    }
    FlotanteEmi(float v1){
        this.v1 = v1;
    }
    public void setValor(float v1){
        this.v1 += v1;
    }
    
    public float getValor(){
        return this.v1;
    }
}
