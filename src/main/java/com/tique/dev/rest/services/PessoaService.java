package com.tique.dev.rest.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tique.dev.rest.model.Pessoa;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> getPessoas(){
        //List<Pessoa> listPerson = pService.findAll(); 
        return pessoaRepository.findAll();
    }

    public void addPessoa(Pessoa pessoa){ 

          checkEmail(pessoa.getEmail());

        pessoaRepository.save(pessoa);
    }

    @Transactional
    public void updatePessoa(Long id,
     //String nome,
      //String email
      Pessoa p){
       checkUser(id);
       
      Optional<Pessoa> pessoa = pessoaRepository.findById(id);
       if(p.getNome() != null && p.getNome().length() > 0 && !Objects.equals(pessoa.get().getNome(), p.getNome())){
                  pessoa.get().setNome(p.getNome());
       }

       if(p.getEmail() != null && p.getEmail().length() > 0 && !Objects.equals(pessoa.get().getEmail(), p.getEmail())){
         checkEmail(p.getEmail());
         pessoa.get().setEmail(p.getEmail());
}

   
     
    }

    public void delPessoa(Long id){
              checkUser(id);
        pessoaRepository.deleteById(id);
    }

    public void checkUser(Long id){

        boolean exists = pessoaRepository.existsById(id);
 
        if(!exists){
            throw new IllegalStateException("A pessoa com o id: " + id + " nao existe" );
        }
    }

    public void checkEmail(String email){
        Optional<Pessoa> pessoaOptional = 
        pessoaRepository.findPessoaByEmail(email);

  if(pessoaOptional.isPresent()){
     throw new IllegalStateException("email usado");
  }  
    }
}
