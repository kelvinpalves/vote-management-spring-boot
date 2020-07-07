/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.pauta;

/**
 *
 * @author kelvin
 */
public class PautaConversor {
    
    public static PautaDto conversorEntidadeDto(Pauta entidade) {
        return PautaDto.builder()
                .id(entidade.getId())
                .descricao(entidade.getDescricao())
                .build();
    }
    
    public static Pauta conversorDtoEntidade(PautaDto dto) {
        return Pauta.builder()
                .id(dto.getId())
                .descricao(dto.getDescricao())
                .build();
    }
    
}
