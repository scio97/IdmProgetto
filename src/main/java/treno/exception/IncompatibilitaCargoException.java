package treno.exception;

public class IncompatibilitaCargoException extends TrenoException{
    private String sigla;
    private String suggerimento;
    public IncompatibilitaCargoException(String sigla){
        super("Il treno non puo'ospitare sia Cargo che Persone.",sigla);
        String temp1 = "H";
        String temp2 = "H";
        for(int i=1; i<sigla.length(); i++){
            if(sigla.charAt(i) == 'C'){
                temp1+=sigla.charAt(i);
            }
            if(sigla.charAt(i)=='P' || sigla.charAt(i)=='R'){
                temp2+=sigla.charAt(i);
            }
        }
        suggerimento = "Prova ad utilizzare: "+ temp1 + " Oppure: "+ temp2;
    }

    public String getSigla() {
        return sigla;
    }

    public String getSuggerimento() {
        return suggerimento;
    }
}
