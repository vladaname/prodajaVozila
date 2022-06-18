package com.example.demo.repository;

import com.example.demo.dto.OglasDTO;
import com.example.demo.dto.PretragaVozila;
import com.example.demo.model.Oglas;
import com.example.demo.model.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface OglasRepository extends JpaRepository<Oglas, Integer> {

    List<Oglas> findAllByObrisan(int i);

    List<Oglas> findAllByOsoba(Osoba o);

    List<Oglas> findAllByPromovisanOrderByDatumKreiranjaAsc(int i);

    List<Oglas> findAllByvrstaVozila(String automobil);

    List<Oglas> findAllByObrisanAndVrstaVozilaOrderByPromovisanDesc(int obrisan, String vrstaVozila);

    List<Oglas> findAllByCenaGreaterThan(int cenaOd);

    List<Oglas> findAllByCenaLessThan(int cenaDo);

    List<Oglas> findAllByCenaBetween(int cenaOd, int cenaDo);

    List<Oglas> findAllByMarkaContainsOrModelContains(String marka, String model);

    List<Oglas> findAllByMarkaContainsOrModelContainsAndCenaGreaterThan(String marka, String model, int cenaOd);

    List<Oglas> findAllByMarkaContainsOrModelContainsAndCenaBetween(String marka, String model, int cenaOd, int cenaDo);

    List<Oglas> findAllByMarkaContainsOrModelContainsAndCenaLessThan(String marka, String model, int cenaDo);

}
