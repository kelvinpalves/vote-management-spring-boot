/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

/**
 *
 * @author kelvin
 */
public class SessaoConversor {
    
    public static SessaoDto conversorEntidadeDto(Sessao entidade) {
        return SessaoDto.builder()
                .id(entidade.getId())
                .pauta(entidade.getIdPauta())
                .inicio(entidade.getInicio())
                .fim(entidade.getFim())
                .aberta(entidade.getAberta())
                .build();
    }
            
    
}

