package com.marcoarcarisi.demo.entity;

import javax.persistence.*;

@Entity
public class StandardString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String valore;

    @Column
    private String codice_paese;

    public StandardString() {}

    public StandardString(String value) {
        this.valore = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getCodice_paese() {return codice_paese;}

    public void setCodice_paese(String codice_paese) {this.codice_paese = codice_paese;}
}
