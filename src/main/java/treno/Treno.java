package treno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import treno.exception.*;
import java.util.ArrayList;

public class Treno {

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    private ArrayList<Vagone> vagoni = new ArrayList<>();
    String input;

    public Treno(String input) throws TrenoException {
        this.input = input;
        if (input.length() < 1 ) {
            throw new IllegalArgumentException("Input non valido per la creazione del treno.");
        }

        if(input.charAt(0) != 'H' ){
            throw new LocomotivaNonInTestaException(input);
        }
        if(input.indexOf('R') != input.lastIndexOf('R')){
            throw new TroppiRistorantiException(input);
        }

        Locomotiva locomitiva = new Locomotiva();
        vagoni.add(locomitiva);

        for (int i = 1; i < input.length(); i++) {
            char tipoVagone = input.charAt(i);
            Vagone vagone = creaVagone(tipoVagone);
            vagoni.add(vagone);
        }
        if(pesoTotale()>locomitiva.getPesoTrainabile()){
            throw new PesoEccessivoException(input);
        }

        boolean cargo = false;
        boolean passeggeri = false;
        boolean ristorante = false;

        for(int i=0; i<input.length(); i++){

            if(input.charAt(i) == 'C' && ristorante){
                throw new IncompatibilitaCargoException(input);
            }

            if(input.charAt(i) == 'R'){
                ristorante = true;
            }

            if(input.charAt(i) == 'C' && passeggeri){
                throw new IncompatibilitaCargoException(input);
            }

            if(input.charAt(i) == 'C' ){
                cargo = true;
            }

            if(input.charAt(i) == 'P' && cargo){
                throw new IncompatibilitaCargoException(input);
            }

            if(input.charAt(i) == 'P' ){
                passeggeri = true;
            }
        }
    }


    private Vagone creaVagone(char tipoVagone) {
        switch (tipoVagone) {
            case 'P':
                return (Locomotiva)context.getBean("locomotiva");
            case 'C':
                return (Cargo)context.getBean("cargo");
            case 'R':
                return (Ristorante)context.getBean("ristorante");
            default:
                throw new CarattereNonCompatibile(input);
        }
    }

    @Override
    public String toString() {
        return "Treno{" +
                "vagoni=" + vagoni +
                '}';
    }

    public double pesoTotale(){
        double peso=0;
        for(int i=0; i<vagoni.size();i++){
            peso+=vagoni.get(i).getPeso();
        }
        return peso;
    }



    public double lunghezzaTotale(){
        double lunghezza=0;
        for(int i=0; i<vagoni.size();i++){
            lunghezza+=vagoni.get(i).getLunghezza();
        }
        return lunghezza;
    }

    public double velocita(){
        return 300 -(pesoTotale()/200);
    }
}
