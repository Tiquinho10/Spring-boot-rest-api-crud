package com.tique.dev.rest.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tique.dev.rest.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    

    //  
    @Query(" select p from Pessoa p where p.email = ?1")
    Optional<Pessoa> findPessoaByEmail(String email);
}
