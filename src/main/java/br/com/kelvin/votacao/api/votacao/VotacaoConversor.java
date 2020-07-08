/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import br.com.kelvin.votacao.api.sessao.SessaoDto;
import java.util.List;

/**
 *
 * @author kelvin
 */
public class VotacaoConversor {
    public static VotacaoDto conversorEntidadeDto(Votacao entidade) {
        return VotacaoDto.builder()
                .id(entidade.getId())
                .membro(entidade.getIdMembro())
                .sessao(entidade.getIdSessao())
                .voto(entidade.getVoto())
                .build();
    }
    
    public static ResultadoVotacaoDto conversorListaVotosParaResultadoVotacao(List<Votacao> lista, String pauta) {
        Integer sim = 0;
        Integer nao = 0;
        
        sim = lista.stream().filter((votacao) -> (votacao.getVoto().equals(Boolean.TRUE))).map((_item) -> 1).reduce(sim, Integer::sum);
        nao = lista.stream().filter((votacao) -> (votacao.getVoto().equals(Boolean.FALSE))).map((_item) -> 1).reduce(nao, Integer::sum);
        
        return ResultadoVotacaoDto.builder()
                .pauta(pauta)
                .totalSim(sim)
                .totalNao(nao)
                .build();
    }
    
    public static Votacao conversorDtoEntidade(ReceberVotoDto dto, SessaoDto sessaoDto) {
        return Votacao.builder()
                .idMembro(dto.getMembro())
                .idSessao(sessaoDto.getId())
                .voto(dto.getVoto())
                .build();
    }
}
