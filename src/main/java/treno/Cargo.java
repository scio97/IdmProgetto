package treno;

public class Cargo implements Vagone{

    private double peso,lunghezza;
    
    public Cargo(){
        peso = 1600;
        lunghezza=10;
    }

    public double getPeso(){
        return peso;
    }

    public double getLunghezza(){
        return lunghezza;
    }

    @Override
    public String toString() {
        return "Vagone cargo{" +
                "peso= "+ getPeso() +
                "lunghezza="+ getLunghezza()+
                '}';
    }
}
