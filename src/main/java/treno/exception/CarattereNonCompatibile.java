package treno.exception;

public class CarattereNonCompatibile extends  TrenoException{

    private String sigla;
    private String suggerimento;
    
    public CarattereNonCompatibile(String sigla){
        super("Utilizzo di caratteri diversi da (H,C,P,R)",sigla);

        String temp = "";
        for(int i=0; i<sigla.length();i++){
            if(sigla.charAt(i) == 'C' || sigla.charAt(i) == 'P' || sigla.charAt(i) == 'R'){
                temp+=sigla.charAt(i);
            }
        }
        suggerimento = "Rimuovere i caratteri non consenstiti, esempio: " +temp;
    }

    public String getSigla() {
        return sigla;
    }

    public String getSuggerimento() {
        return suggerimento;
    }
}
