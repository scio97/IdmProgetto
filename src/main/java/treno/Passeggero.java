package treno;

public class Passeggero implements Vagone{
    private int posti;
    private double peso,lunghezza;

    public Passeggero(){
        peso = 600;
        lunghezza = 6;
        posti = 50;
    }

    public double getPeso(){
        return peso;
    }

    public double getLunghezza(){
        return lunghezza;
    }

    public int getPosti(){
        return posti;
    }

    @Override
    public String toString() {
        return "Vagone passeggeri{" +
                "posti= " + getPosti() +
                "peso= "+ getPeso() +
                "lunghezza="+ getLunghezza()+
                '}';
    }
}
