package treno.exception;

public class LocomotivaNonInTestaException extends TrenoException{

    private String sigla;
    private String suggerimento;
    
    public LocomotivaNonInTestaException(String sigla){
        super("Locomotiva non in testa",sigla);
        String temp="";
        for(int i=0; i<sigla.length();i++){
            if(sigla.charAt(i)!= 'H'){
                temp+=sigla.charAt(i);
            }
        }
        suggerimento = "Si consiglia di aggiungere la locomotiva in testa, ad esempio: H" +temp;
    }

    public String getSigla() {
        return sigla;
    }

    public String getSuggerimento() {
        return suggerimento;
    }
}
