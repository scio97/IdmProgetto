package treno;

public class Locomotiva implements Vagone{
    private double peso,pesoTrainabile,lunghezza;

    public Locomotiva(){
        peso = 900;
        lunghezza = 4;
        pesoTrainabile = 10000;
    }


    public double getPeso(){
        return peso;
    }

    public double getPesoTrainabile(){
        return pesoTrainabile;
    }

    public double getLunghezza(){
        return lunghezza;
    }

    @Override
    public String toString() {
        return "Locomotiva{" +
                "pesoTrainabile: "+getPesoTrainabile()+
                "peso= "+ getPeso() +
                "lunghezza="+ getLunghezza()+
                '}';
    }
}
