package com.example.demo.dto;


public class OglasDTO {

    private int cena;
    private String datumKreiranja;
    private String marka;
    private String model;
    private String tekst;
    private int obrisan;
    private int promovisan;
    private String vrstaVozila;

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(String datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
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

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getObrisan() {
        return obrisan;
    }

    public void setObrisan(int obrisan) {
        this.obrisan = obrisan;
    }

    public int getPromovisan() {
        return promovisan;
    }

    public void setPromovisan(int promovisan) {
        this.promovisan = promovisan;
    }

    public String getVrstaVozila() {
        return vrstaVozila;
    }

    public void setVrstaVozila(String vrstaVozila) {
        this.vrstaVozila = vrstaVozila;
    }
}
