package treno;

public class Ristorante implements Vagone{
    
    private double peso,lunghezza;

    public Ristorante(){
        //this.menu = menu;
    }

    public double getPeso(){
        return peso;
    }

    public double getLunghezza(){
        return lunghezza;
    }

    @Override
    public String toString() {
        return "Vagone Ristorante{" +
                //"menu=" + menu +
                "peso= "+ getPeso() +
                "lunghezza="+ getLunghezza()+
                '}';
    }
}
