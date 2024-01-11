package com.marcoarcarisi.demo.entity;
import javax.persistence.*;

@Entity
public class TreniCreati {

    @Id
    @Column
    private String user;

    @Column
    private String inputCreazione;



    @Column
    private String nazionalita;

    public TreniCreati(String inputCreazione, String user,String nazionalita) {
        this.inputCreazione = inputCreazione;
        this.user = user;
        this.nazionalita = nazionalita;
    }

    public String getInputCreazione() {
        return inputCreazione;
    }

    public void setInputCreazione(String inputCreazione) {
        this.inputCreazione = inputCreazione;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }
}