package com.tique.dev.rest.model;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
      
    private String nome;
    private String email;
    private LocalDate dob;

    @Transient
    private int idade;

    public Pessoa(){

    }

    

    public Pessoa(String nome, String email, LocalDate dob) {
        this.nome = nome;
        this.email = email;
        this.dob = dob;
        
    }


 
    public long getId(){

        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){

        return this.email;
    }

    

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getIdade() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa [dob=" + dob + ", email=" + email + ", id=" + id + ", idade=" + idade + ", nome=" + nome + "]";
    }

  
    

}
