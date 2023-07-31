package com.yuri.mypet.repositories;

import com.yuri.mypet.domain.AgendaProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaProviderRepository extends JpaRepository<AgendaProvider, Integer> {

    @Query("SELECT u FROM AgendaProvider u WHERE u.idPetProvider = :idPetProvider AND escolhido = false")
    List<AgendaProvider> findByIdPetProvider(@Param ("idPetProvider") Integer idPetProvider);


   // @Transactional
    @Query(value  = "SELECT u FROM AgendaProvider u WHERE\n" +
            "u.idPetProvider = :idPetProvider AND u.segundaCheck =:segundaCheck  AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND \n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao =:tempoFimCorrecao \n" +
            
            "OR u.tercaCheck =:tercaCheck AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND u.idPetProvider =:idPetProvider AND\n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao = :tempoFimCorrecao \n" +

            "OR u.quartaCheck =:quartaCheck AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND u.idPetProvider =:idPetProvider AND\n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao =:tempoFimCorrecao \n" +
            
            "OR u.quintaCheck =:quintaCheck AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND u.idPetProvider =:idPetProvider AND\n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao =:tempoFimCorrecao \n" +
            
            "OR u.sextaCheck =:sextaCheck AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND u.idPetProvider =:idPetProvider AND\n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao =:tempoFimCorrecao \n" +

            "OR u.sabadoCheck =:sabadoCheck AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND u.idPetProvider =:idPetProvider AND\n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao =:tempoFimCorrecao \n" +
             
            "OR u.domingoCheck =:domingoCheck AND u.dataCalendarioCorrecao\n" +
            " =:dataCalendarioCorrecao AND u.idPetProvider =:idPetProvider AND\n" +
            "u.servicoEscolhido =:servicoEscolhido AND u.siglaDia =:siglaDia AND\n" +
            "u.tempoInicioCorrecao =:tempoInicioCorrecao AND u.tempoFimCorrecao =:tempoFimCorrecao "


        
            )
            

    List<AgendaProvider> findDiasSelecionados( @Param("idPetProvider") Integer idPetProvider,
                                              @Param ("segundaCheck") boolean segundaCheck,
                                              @Param ("tercaCheck") boolean tercaCheck,
                                              @Param ("quartaCheck") boolean quartaCheck,
                                              @Param ("quintaCheck") boolean quintaCheck,
                                              @Param ("sextaCheck") boolean sextaCheck,
                                              @Param ("sabadoCheck") boolean sabadoCheck,
                                              @Param ("domingoCheck") boolean domingoCheck,
                                              @Param ("dataCalendarioCorrecao") String dataCalendarioCorrecao,
                                              @Param ("servicoEscolhido") String servicoEscolhido,
                                              @Param ("tempoInicioCorrecao") String tempoInicioCorrecao,
                                              @Param ("tempoFimCorrecao") String tempoFimCorrecao,
                                              @Param ("siglaDia") String siglaDia);

}
