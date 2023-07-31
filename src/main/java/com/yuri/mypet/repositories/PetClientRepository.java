package com.yuri.mypet.repositories;

import com.yuri.mypet.domain.PetClient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PetClientRepository extends JpaRepository<PetClient, Integer> {

     @Transactional(readOnly = true) // diz que transação não necessita ser envolvida no banco de dados
     PetClient findByUsername(String username); // cria busca com o campo Email

    // @Transactional(readOnly = true)
     PetClient findByEmail(String email);

}
