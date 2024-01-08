package entity;

import javax.persistence.*;

@Entity
public class AlgoritmoUtilizzato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String input;
    @Column
    private String output;
    @Column
    private String algoritmo;

    public AlgoritmoUtilizzato() {}

    public AlgoritmoUtilizzato(String input, String output, String algoritmo) {
        this.input = input;
        this.output = output;
        this.algoritmo = algoritmo;
    }

    public int getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(String algoritmo) {
        this.algoritmo = algoritmo;
    }

    @Override
    public String toString() {
        return "AlgoritmoUtilizzato{" +
                "id=" + id +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", algoritmo='" + algoritmo + '\'' +
                '}';
    }
}