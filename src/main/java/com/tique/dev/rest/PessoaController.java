package com.tique.dev.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tique.dev.rest.model.Pessoa;
import com.tique.dev.rest.services.PessoaService;

@RestController
@RequestMapping("/")
public class PessoaController {
    
 
    
@Autowired
PessoaService pService;


@GetMapping("/hello")
public String hello(){

    return "Hello world";
}

@GetMapping("/")
public List getPessoas(){
   
    return pService.getPessoas();
}

@PostMapping("/")
public void insert(@RequestBody Pessoa pessoa){
    pService.addPessoa(pessoa);
}

@PutMapping("/{id}")
public void updatePessoa(
    @PathVariable Long id,
    @RequestParam(required = false) String nome,
    @RequestParam(required = false) String email
){
       pService.updatePessoa(id, nome, email);
}

@DeleteMapping("/{id}")
public void removerPessoa(@PathVariable Long id){
   pService.delPessoa(id);
}
}
