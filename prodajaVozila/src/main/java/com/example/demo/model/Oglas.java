package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the oglas database table.
 * 
 */
@Entity
@NamedQuery(name="Oglas.findAll", query="SELECT o FROM Oglas o")
public class Oglas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idoglas;

	private int cena;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="datum_kreiranja")
	private Date datumKreiranja;

	private String marka;

	private String model;

	private int obrisan;

	private int promovisan;

	private String tekst;

	@Column(name="vrsta_vozila")
	private String vrstaVozila;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	public Oglas() {
	}

	public int getIdoglas() {
		return this.idoglas;
	}

	public void setIdoglas(int idoglas) {
		this.idoglas = idoglas;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public Date getDatumKreiranja() {
		return this.datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getObrisan() {
		return this.obrisan;
	}

	public void setObrisan(int obrisan) {
		this.obrisan = obrisan;
	}

	public int getPromovisan() {
		return this.promovisan;
	}

	public void setPromovisan(int promovisan) {
		this.promovisan = promovisan;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public String getVrstaVozila() {
		return this.vrstaVozila;
	}

	public void setVrstaVozila(String vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}