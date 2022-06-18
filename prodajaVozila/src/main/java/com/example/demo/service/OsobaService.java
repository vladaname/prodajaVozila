package com.example.demo.service;

import com.example.demo.dto.OsobaDTO;
import com.example.demo.model.Osoba;

public interface OsobaService {
    boolean createOsoba(OsobaDTO osobaDTO);

    Osoba login(OsobaDTO osobaDTO);
}
