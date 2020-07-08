/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kelvin
 */

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {
 
    Optional<Sessao> findByIdPauta(Integer id);
    
    @Query("select s from Sessao s where s.idPauta = :pauta and s.fim > :agora")
    Optional<Sessao> findBySessaoAberta(@Param("pauta") Integer pauta, @Param("agora") LocalDateTime agora);
    
}
