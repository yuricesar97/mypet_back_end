package com.yuri.mypet.repositories;

import com.yuri.mypet.domain.PetProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PetProviderRepository extends JpaRepository<PetProvider, Integer> {

     @Transactional(readOnly = true) // diz que transação não necessita ser envolvida no banco de dados
     PetProvider findByEmail(String email); // cria busca com o campo Email


     @Transactional(readOnly = true)
     @Query("SELECT u FROM PetProvider u WHERE u.cidade =:cidade AND u.estado =:estado")
     List<PetProvider> findByCidadeAndEstado(@Param ("cidade") String cidade,
                                             @Param ("estado") String estado);

     
     @Transactional(readOnly = true)
     @Query("SELECT u FROM PetProvider u WHERE u.cidade =:cidade AND u.razaoSocial =:razaoSocial AND u.bairro =:bairro")
      List<PetProvider> findByCidadeAndEstadoAndBairro(@Param ("cidade") String cidade,
                                                       @Param ("razaoSocial") String razaoSocial,
                                                       @Param ("bairro") String bairro);



     @Transactional(readOnly = true)
     @Query("SELECT u FROM PetProvider u WHERE u.cidade =:cidade AND u.razaoSocial =:razaoSocial")
     List<PetProvider> findByCidadeAndRazaoSocial(@Param ("cidade") String cidade,
                                                           @Param ("razaoSocial") String razaoSocial);

   

   
    
     
}
