package com.example.demo.service.impl;

import com.example.demo.controllers.Test;
import com.example.demo.dto.IzmeniOglasDTO;
import com.example.demo.dto.OglasDTO;
import com.example.demo.dto.PretragaVozila;
import com.example.demo.dto.ZaboravljenaLozinkaDTO;
import com.example.demo.model.Oglas;
import com.example.demo.model.Osoba;
import com.example.demo.repository.OglasRepository;
import com.example.demo.repository.OsobaRepository;
import com.example.demo.service.OglasService;
import com.example.demo.util.ConfigureMessage;
import com.example.demo.util.ConfigureTemplate;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import java.util.*;

@Service
public class OglasServiceImpl implements OglasService {
    @Autowired
    OsobaRepository osobaRepository;
    @Autowired
    OglasRepository oglasRepository;


    private static final String AUTOMOBIL = "automobil";
    private static final String KAMION = "kamion";
    private static final String MOTOR = "motor";

    @Override
    public Oglas createOglas(OglasDTO oglasDTO, int idosoba) {

        Oglas g = new Oglas();
        g.setMarka(oglasDTO.getMarka());
        g.setModel(oglasDTO.getModel());
        g.setCena(oglasDTO.getCena());
        g.setTekst(oglasDTO.getTekst());
        g.setPromovisan(0);

        Date date = new Date();
        g.setDatumKreiranja(date);
        g.setObrisan(0);
        g.setVrstaVozila(oglasDTO.getVrstaVozila());

        Optional<Osoba> getOsoba = osobaRepository.findById(idosoba);
        if (getOsoba.isPresent()) {
            Osoba o = getOsoba.get();
            g.setOsoba(o);
        } else {
            return null;
        }
        oglasRepository.saveAndFlush(g);
        return g;
    }

    @Override
    public List<Oglas> getSveOglase() {
        return oglasRepository.findAllByObrisan(0);
    }

    @Override
    public boolean kupiVozilo(int idoglas, String email) {
        Optional<Oglas> getOglas = oglasRepository.findById(idoglas);
        if(getOglas.isPresent()){
            Oglas g = getOglas.get();
            g.setObrisan(1);
            oglasRepository.saveAndFlush(g);
            try {
                Message message = ConfigureMessage.message(email,"", "", "Uspesna kupovina");

                Map paramMap = new HashMap();
                //paramMap.put("baseUrl", Constants.baseUrl+"changePassword/?userHash="+u.getUserHash());
                paramMap.put("marka", g.getMarka());
                paramMap.put("model", g.getModel());
                paramMap.put("cena", g.getCena());

                boolean b = ConfigureTemplate.template(message, Test.class, "kupovina.ftl", paramMap);

                if(b){
                    System.out.print("Success");
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return false;
        }

        return false;
    }

    @Override
    public List<Oglas> listaOglasa(int idosoba) {
        Optional<Osoba> getOsoba = osobaRepository.findById(idosoba);
        if(getOsoba.isPresent()){
            Osoba o = getOsoba.get();
            return oglasRepository.findAllByOsoba(o);
        }
        return null;
    }

    @Override
    public List<PretragaVozila> pretragaVozila(PretragaVozila pretragaVozila) {

        return null;
    }

    @Override
    public Oglas izmeniOglas(IzmeniOglasDTO izmeniOglasDTO) {
        Optional<Oglas> getOglas = oglasRepository.findById(Integer.parseInt(izmeniOglasDTO.getIdoglas()));
        if(getOglas.isPresent()){
            Oglas g = getOglas.get();
            g.setModel(izmeniOglasDTO.getModel());
            g.setMarka(izmeniOglasDTO.getMarka());
            g.setVrstaVozila(izmeniOglasDTO.getVrstaVozila());
            g.setTekst(izmeniOglasDTO.getTekst());
            g.setCena(Integer.parseInt(izmeniOglasDTO.getCena()));

            oglasRepository.saveAndFlush(g);
            return g;
        }
        return null;
    }
    @Override
    public List<Oglas> promovisan() {
        List<Oglas> promovisan = oglasRepository.findAllByPromovisanOrderByDatumKreiranjaAsc(1);
        return promovisan;
    }
    @Override
    public List<Oglas> listaAutomobila() {
        List<Oglas> getAutomobil = oglasRepository.findAllByObrisanAndVrstaVozilaOrderByPromovisanDesc(0, AUTOMOBIL);
        return getAutomobil;
    }
    @Override
    public List<Oglas> listaKamiona() {
        List<Oglas> getKamioni = oglasRepository.findAllByObrisanAndVrstaVozilaOrderByPromovisanDesc(0, KAMION);
        return getKamioni;
    }

    @Override
    public List<Oglas> listaMotora() {
        List<Oglas> getMotori = oglasRepository.findAllByObrisanAndVrstaVozilaOrderByPromovisanDesc(0, MOTOR);
        return getMotori;
    }

    @Override
    public List<Oglas> pretraga(int cenaStigloOd, int cenaStigloDo, String kriterijumPretrage) {

        if(cenaStigloOd > 0 && cenaStigloDo == 0 && kriterijumPretrage.equals("") ){
            return oglasRepository.findAllByCenaGreaterThan(cenaStigloOd);
        }
        if(cenaStigloOd == 0 && cenaStigloDo > 0 && kriterijumPretrage.equals("")){
            return oglasRepository.findAllByCenaLessThan(cenaStigloDo);
        }
        if(cenaStigloOd > 0 && cenaStigloDo > 0 && kriterijumPretrage.equals("")){
            return oglasRepository.findAllByCenaBetween(cenaStigloOd, cenaStigloDo);
        }
        if(cenaStigloOd == 0 && cenaStigloDo == 0 && !kriterijumPretrage.equals("")){
            return oglasRepository.findAllByMarkaContainsOrModelContains(kriterijumPretrage, kriterijumPretrage);
        }
        if(cenaStigloOd > 0 && cenaStigloDo == 0 && !kriterijumPretrage.equals("")){
            return oglasRepository.findAllByMarkaContainsOrModelContainsAndCenaGreaterThan(kriterijumPretrage, kriterijumPretrage, cenaStigloOd);
        }
        if(cenaStigloOd > 0 && cenaStigloDo > 0 && !kriterijumPretrage.equals("")){
            return oglasRepository.findAllByMarkaContainsOrModelContainsAndCenaBetween(kriterijumPretrage, kriterijumPretrage, cenaStigloOd, cenaStigloDo);
        }
        if(cenaStigloOd == 0 && cenaStigloDo > 0 && !kriterijumPretrage.equals("")){
            return oglasRepository.findAllByMarkaContainsOrModelContainsAndCenaLessThan(kriterijumPretrage, kriterijumPretrage, cenaStigloDo);
        }

        return oglasRepository.findAll();

    }

    @Override
    public Oglas findById(int id) {
        Optional<Oglas> findOglas = oglasRepository.findById(id);
        if (findOglas.isPresent()) {
            Oglas o = findOglas.get();
            return o;
        }
        return null;
    }

    @Override
    public boolean pronadjiOsoboPoEmailu(ZaboravljenaLozinkaDTO zaboravljenaLozinkaDTO) {
        Optional<Osoba> getOsoba = osobaRepository.findByEmail(zaboravljenaLozinkaDTO.getEmail());

        if(getOsoba.isPresent()) {
            Osoba o = getOsoba.get();

            //sta se ovde desava? zasto pretvaramo u bytes? pa onda u string?
            int idosoba = o.getIdosoba();
            byte[] idBytes = Integer.toString(idosoba).getBytes();
            String idBytesStr = new String(idBytes);
            String url = "http://localhost:8080/resetSifre/" + idBytesStr;
            try {
                Message message = ConfigureMessage.message(zaboravljenaLozinkaDTO.getEmail(), "", "", "Reset sifre");

                Map paramMap = new HashMap();
                //paramMap.put("baseUrl", Constants.baseUrl+"changePassword/?userHash="+u.getUserHash());
                paramMap.put("link", url);

                boolean b = ConfigureTemplate.template(message, Test.class, "resetSifre.ftl", paramMap);

                if (b) {
                    System.out.print("Success");
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
}

    @Override
    public boolean promeniSifru(int idosoba, String pass1) {
        Optional<Osoba> getOsoba = osobaRepository.findById(idosoba);
        if(getOsoba.isPresent()){
            Osoba o = getOsoba.get();
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            o.setPass(passwordEncryptor.encryptPassword(pass1));
            osobaRepository.saveAndFlush(o);
            return true;
        }
        return false;
    }


//    @Override
//    public Oglas izmeniOglas(Oglas oglas) {
//        Optional<Oglas> getOglas = oglasRepository.findById(oglas.getIdoglas());
//        if(getOglas.isPresent()){
//            Oglas g = getOglas.get();
//            g.setModel(oglas.getModel());
//            g.setMarka(oglas.getMarka());
//            g.setVrstaVozila(oglas.getVrstaVozila());
//
//            oglasRepository.saveAndFlush(g);
//            return g;
//        }
//        return null;
//    }


//    @Override
//    public List<Oglas> searchByMarka(OglasDTO oglasDTO) {
//        return oglasRepository.findAllByMarkaByModel(oglasDTO);
//    }


}
