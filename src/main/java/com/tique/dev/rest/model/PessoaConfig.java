package com.tique.dev.rest.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tique.dev.rest.services.PessoaRepository;

@Configuration
public class PessoaConfig {
    
    // @Bean
    // CommandLineRunner commandLineRunner(PessoaRepository pessoaRepository){

    //     return args -> {
    //       Pessoa p1 =   new Pessoa(
    //             "Luiz Tique", 
    //             "luiztiquejr@gmail.com",
    //              LocalDate.of(1997, Month.NOVEMBER, 23)
    //              );

    //              Pessoa p2 =  new Pessoa(
    //             "karina bernado", 
    //             "kary@gmail.com",
    //              LocalDate.of(2000, Month.SEPTEMBER, 3));


    //              pessoaRepository.saveAll(
    //                 List.of(p1, p2)
    //              );
    //     };
    // }
}
