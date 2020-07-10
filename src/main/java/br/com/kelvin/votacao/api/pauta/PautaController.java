/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.pauta;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/v1/pauta")
@Tag (name = "Pauta", description = "Serviços para gerenciamento de pautas")
public class PautaController {

    private final PautaService service;
    
    @Autowired
    public PautaController(PautaService pautaService) {
        this.service = pautaService;
    }

    @Operation ( summary = "Criação de Pauta")
    @PostMapping
    PautaDto criarPauta(@Valid @RequestBody PautaDto pautaDto) {
        log.info("Criando pauta: {}", pautaDto.getDescricao());
        return service.criarPauta(pautaDto);
    }

}
