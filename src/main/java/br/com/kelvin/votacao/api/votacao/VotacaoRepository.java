/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kelvin
 */

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer>{
    
    Optional<Votacao> findByIdSessaoAndCpfAssociado(Integer sessao, String membro);
    
    List<Votacao> findByIdSessao(Integer sessao);
    
}
