package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uloga database table.
 * 
 */
@Entity
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduloga;

	private String naziv;

	//bi-directional many-to-one association to Osoba
	@OneToMany(mappedBy="uloga")
	private List<Osoba> osobas;

	public Uloga() {
	}

	public int getIduloga() {
		return this.iduloga;
	}

	public void setIduloga(int iduloga) {
		this.iduloga = iduloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Osoba> getOsobas() {
		return this.osobas;
	}

	public void setOsobas(List<Osoba> osobas) {
		this.osobas = osobas;
	}

	public Osoba addOsoba(Osoba osoba) {
		getOsobas().add(osoba);
		osoba.setUloga(this);

		return osoba;
	}

	public Osoba removeOsoba(Osoba osoba) {
		getOsobas().remove(osoba);
		osoba.setUloga(null);

		return osoba;
	}

}