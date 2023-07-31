package com.yuri.mypet.repositories;

import java.util.Optional;

import com.yuri.mypet.domain.LoginConjunto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LoginConjuntoRepository extends JpaRepository<LoginConjunto, Integer> {

    @Transactional(readOnly = true)
    LoginConjunto findByEmail(String email);

    
    @Transactional(readOnly = true) // diz que transação não necessita ser envolvida no banco de dados
    @Query("SELECT u.id FROM LoginConjunto u WHERE u.email =:email ")
    Optional<LoginConjunto> findByEmailId(@Param("email") String email); // cria busca com o campo Email

    Optional<LoginConjunto> findById(Integer id);

}
