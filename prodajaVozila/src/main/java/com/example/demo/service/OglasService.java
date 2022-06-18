package com.example.demo.service;

import com.example.demo.dto.IzmeniOglasDTO;
import com.example.demo.dto.OglasDTO;
import com.example.demo.dto.PretragaVozila;
import com.example.demo.dto.ZaboravljenaLozinkaDTO;
import com.example.demo.model.Oglas;

import java.util.List;

public interface OglasService {

    Oglas createOglas(OglasDTO oglasDTO, int idosoba);

    List<Oglas> getSveOglase();

    boolean kupiVozilo(int idoglas, String email);

    List<Oglas> listaOglasa(int idosoba);

    List<PretragaVozila> pretragaVozila(PretragaVozila pretragaVozila);

    Oglas izmeniOglas(IzmeniOglasDTO izmeniOglasDTO);

    List<Oglas> promovisan();

    List<Oglas> listaAutomobila();

    List<Oglas> listaKamiona();

    List<Oglas> listaMotora();

    List<Oglas> pretraga(int cenaStigloOd, int cenaStigloDo, String kriterijumPretrage);

    Oglas findById(int id);

    boolean pronadjiOsoboPoEmailu(ZaboravljenaLozinkaDTO zaboravljenaLozinkaDTO);

    boolean promeniSifru(int idosoba, String pass1);
}
