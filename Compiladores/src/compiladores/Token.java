package compiladores;

public class Token{
    public String lexema;
    public int token;
    public static final String MAS = "+";
    public static final String MENOS = "-";
    public static final String PROD = "*";
    public static final String DIV = "/";

    public Token(String lexema, int token){
        this.lexema = lexema;
        this.token = token;
    }	
}
