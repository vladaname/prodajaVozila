package com.example.demo.service.impl;

import com.example.demo.dto.OsobaDTO;
import com.example.demo.model.Osoba;
import com.example.demo.model.Uloga;
import com.example.demo.repository.OsobaRepository;
import com.example.demo.repository.UlogaRepository;
import com.example.demo.service.OsobaService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OsobaServiceImpl implements OsobaService {

    @Autowired
    OsobaRepository osobaRepository;

    @Autowired
    UlogaRepository ulogaRepository;

    @Override
    public boolean createOsoba(OsobaDTO osobaDTO) {
        try {
            Osoba o = new Osoba();
            StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            o.setIme(osobaDTO.getIme());
            o.setPrezime(osobaDTO.getPrezime());
            o.setTel(osobaDTO.getTel());
            o.setEmail(osobaDTO.getEmail());
            o.setUsername(osobaDTO.getUsername());
            o.setPass(passwordEncryptor.encryptPassword(osobaDTO.getPass()));

            Optional<Uloga> getUloga = ulogaRepository.findById(1);
            if(getUloga.isPresent()){
                Uloga u = getUloga.get();
                o.setUloga(u);
            }
            else{
                return  false;
            }
            osobaRepository.saveAndFlush(o);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Osoba login(OsobaDTO osobaDTO) {
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
            Osoba o = osobaRepository.findByUsername(osobaDTO.getUsername());
            String encryptPass = o.getPass();
            if(osobaDTO.getPass().equals(o.getPass()) || passwordEncryptor.checkPassword(osobaDTO.getPass(), encryptPass)){
                return o;
            }
            else{
                return null;
            }
    }
}
