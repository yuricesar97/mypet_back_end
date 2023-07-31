package com.yuri.mypet.repositories;

import java.util.List;
import java.util.Optional;

import com.yuri.mypet.domain.ContratadoAgendaProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContratadoAgendaProviderRepository extends JpaRepository<ContratadoAgendaProvider, Integer> {



   // QUERYS PARA O PETTPROVIDER
    @Query("SELECT u FROM ContratadoAgendaProvider u WHERE u.idPetProvider = :idPetProvider AND u.status = false AND u.cancelado = false")
   List<ContratadoAgendaProvider> findByIdPetProviderAndStatus(@Param ("idPetProvider") Integer idPetProvider);

   @Query("SELECT u FROM ContratadoAgendaProvider u WHERE u.idPetProvider = :idPetProvider AND (u.status = true OR u.cancelado = true)")
   List<ContratadoAgendaProvider> findByHistoricoProvider(@Param ("idPetProvider") Integer idPetProvider);


    // QUERYS PARA O PETCLIENT
   @Query("SELECT u FROM ContratadoAgendaProvider u WHERE u.idPetClient = :idPetClient AND u.cancelado = false AND u.status = false")
   List<ContratadoAgendaProvider> findByIdPetClient(@Param ("idPetClient") Integer idPetClient);

   @Query("SELECT u FROM ContratadoAgendaProvider u WHERE u.idPetClient = :idPetClient AND (u.cancelado = true OR u.status = true)")
   List<ContratadoAgendaProvider> findHistoricoClient(@Param("idPetClient") Integer idPetClient);


   // QUERRYS PARA OUTROS
   @Query("SELECT u FROM ContratadoAgendaProvider u WHERE u.status = :status")
   List<ContratadoAgendaProvider> findByStatus(@Param ("status") boolean status);
}
