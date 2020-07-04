/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import lombok.extern.slf4j.Slf4j;
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
public class SessaoController {
    
    private final SessaoService service;
    
    public SessaoController(final SessaoService service) {
        this.service = service;
    }
    
    @PostMapping
    SessaoDto abrirSessao(@RequestBody final AberturaSessaoDto dto) {
        log.info("Tentativa de abertura de sessão para a pauta: {}", dto.getPauta());
        return this.service.abrirSessao(dto);
    }
}
