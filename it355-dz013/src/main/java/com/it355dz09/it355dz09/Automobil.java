package com.it355dz09.it355dz09;

import javax.persistence.*;

@Entity
@Table(name = "automobili")
public class Automobil {

@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marka")
    private String marka;

    @Column(name = "model")
    private String model;

    @Column(name = "cena")
    private String cena;

    @Column(name = "zemlja_porekla")
    private String poreklo;

    @Column(name = "kilometraza")
    private String kilometraza;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getPoreklo() {
        return poreklo;
    }

    public void setPoreklo(String poreklo) {
        this.poreklo = poreklo;
    }

    public String getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(String kilometraza) {
        this.kilometraza = kilometraza;
    }

    @Override
    public String toString() {
        return "Automobil{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", cena='" + cena + '\'' +
                ", poreklo='" + poreklo + '\'' +
                ", kilometraza='" + kilometraza + '\'' +
                '}';
    }
}
