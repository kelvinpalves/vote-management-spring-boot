/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.pauta;

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
@RequestMapping("/api/v1/pauta")
public class PautaController {
    
    private PautaService service;
    
    public PautaController(PautaService pautaService) {
        this.service = pautaService;
    }
    
    @PostMapping
    PautaDto criarPauta(@RequestBody final PautaDto pautaDto) {
        log.info("Criando pauta: {}", pautaDto.getDescricao());
        return service.criarPauta(pautaDto);
    }
    
}
