/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kelvin
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/votacao")
@Tag (name = "Votação", description = "Serviços para gerenciar a votação das pautas.")
public class VotacaoController {
    private final VotacaoService service;
    
    @Autowired
    public VotacaoController(final VotacaoService service) {
        this.service = service;
    }
    
    @Operation ( summary = "Votar em determinada pauta.")
    @PostMapping
    VotacaoDto votar(@Valid @RequestBody ReceberVotoDto dto) {
        log.info("Tentativa de voto para a pauta: {}", dto.getPauta());
        return this.service.adicionarVoto(dto);
    }
    
    @Operation ( summary = "Exibir resultado da votação de determinada sessão.")
    @GetMapping("/resultado/sessao/{sessao}")
    ResultadoVotacaoDto buscarResultado(@PathVariable("sessao") Integer sessao) {
        log.info("Buscar resultado da votação para sessão: {}", sessao);
        return this.service.buscarResultadoVotacao(sessao);
    }
    
    
    
}
