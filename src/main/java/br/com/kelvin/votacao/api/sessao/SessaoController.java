/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/v1/sessao")
@Tag (name = "Sessão", description = "Serviços para gerenciamento de sessões de votação")
public class SessaoController {
    
    private final SessaoService service;
    
    @Autowired
    public SessaoController(final SessaoService service) {
        this.service = service;
    }
    
    @Operation ( summary = "Criar sessão para determinada pauta.")
    @PostMapping
    SessaoDto abrirSessao(@Valid @RequestBody AberturaSessaoDto dto) {
        log.info("Tentativa de abertura de sessão para a pauta: {}", dto.getPauta());
        return this.service.abrirSessao(dto);
    }
}
