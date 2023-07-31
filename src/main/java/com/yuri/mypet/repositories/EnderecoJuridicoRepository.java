package com.yuri.mypet.repositories;

import com.yuri.mypet.domain.EnderecoJuridico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoJuridicoRepository extends JpaRepository<EnderecoJuridico, Integer> {

}
