package com.example.demo.repository;

import com.example.demo.model.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository

public interface OsobaRepository extends JpaRepository<Osoba, Integer> {
    Osoba findByUsername(String username);

    Optional<Osoba> findByEmail(String email);
}
