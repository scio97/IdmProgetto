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
}
