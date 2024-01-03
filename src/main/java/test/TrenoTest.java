package test;

import treno.Treno;
import treno.exception.TrenoException;

public class TrenoTest {
    public static void main3(String[] args) {
        Treno choochoo = null;
        try {
            choochoo = new Treno("HPPPRPPPP");
        } catch (TrenoException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuggerimento());
        }

   /*  catch (LocomotivaNonInTestaException e) {
        System.out.println(e.getMessage());
        System.out.println(e.getSuggerimento());
    }

     catch (
    TroppiRistorantiException e) {
        System.out.println(e.getMessage());
        System.out.println(e.getSuggerimento());
    }*/
        System.out.println(choochoo.toString());

        System.out.println("-----------------------------");
        System.out.println("Peso totale treno: "+choochoo.pesoTotale()+"Kg");
        System.out.println("-----------------------------");
        System.out.println("lunghezza totale treno: "+choochoo.lunghezzaTotale()+"m");
        System.out.println("-----------------------------");
        System.out.println("Velocita massima="+choochoo.velocita()+"Km/h");

        //Treno y = new Treno("1232313");
    }
}
