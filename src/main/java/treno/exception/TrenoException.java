package treno.exception;

public abstract class TrenoException extends RuntimeException{
    private String sigla;
    public TrenoException(String message,String sigla){
        super(message);
    }

    public String getSigla() {
        return sigla;
    }

    public abstract String getSuggerimento();

}