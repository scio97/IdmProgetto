package com.marcoarcarisi.demo.entity;
import javax.persistence.*;

@Entity
public class TreniCreati {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String user;

    @Column
    private String inputCreazione;

    @Column
    private String nazionalita;

    public TreniCreati() {}

    public TreniCreati(String user, String inputCreazione, String nazionalita) {
        this.user = user;
        this.inputCreazione = inputCreazione;
        this.nazionalita = nazionalita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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