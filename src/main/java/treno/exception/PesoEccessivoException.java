package treno.exception;

public class PesoEccessivoException extends TrenoException{
    private String sigla;
    private String suggerimento;
    public PesoEccessivoException(String sigla){
        super("Il peso dei vagoni supera la capacita' di traino della locomotiva.",sigla);
        suggerimento = "Rimuovere dei vagoni.";
    }

    public String getSigla() {
        return sigla;
    }

    public String getSuggerimento() {
        return suggerimento;
    }
}