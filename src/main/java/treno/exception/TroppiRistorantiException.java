package treno.exception;

public class TroppiRistorantiException extends TrenoException{
    private String sigla;
    private String suggerimento;
    public TroppiRistorantiException(String sigla){
        super("Ristoranti in eccesso",sigla);
        String temp="";
        boolean trovata=false;
        for(int i=0; i<sigla.length();i++){
            if(sigla.charAt(i) == 'R' && !trovata ){
                trovata=true;
                temp+=sigla.charAt(i);
            }
            else if(sigla.charAt(i) != 'R'){
                temp+=sigla.charAt(i);
            }
        }
        suggerimento = "Si consiglia di rimuovere i vagoni ristorante in eccesso, esempio: "+temp;
    }

    public String getSigla() {
        return sigla;
    }

    public String getSuggerimento() {
        return suggerimento;
    }
}