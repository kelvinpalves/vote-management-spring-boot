/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import br.com.kelvin.votacao.api.pauta.PautaDto;
import br.com.kelvin.votacao.api.pauta.PautaService;
import br.com.kelvin.votacao.api.sessao.Sessao;
import br.com.kelvin.votacao.api.sessao.SessaoDto;
import br.com.kelvin.votacao.api.sessao.SessaoService;
import br.com.kelvin.votacao.config.exception.SessaoInvalidaException;
import br.com.kelvin.votacao.config.exception.VotoNegadoException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kelvin
 */

@Slf4j
@Service
public class VotacaoServiceImpl implements VotacaoService {

    private final VotacaoRepository repository;
    
    private final SessaoService sessaoService;
   
    private final PautaService pautaService;
    
    @Autowired
    public VotacaoServiceImpl(VotacaoRepository repository, 
            SessaoService sessaoService,
            PautaService pautaService) {
        this.repository = repository;
        this.sessaoService = sessaoService;
        this.pautaService = pautaService;
    }
    
    @Override
    public VotacaoDto adicionarVoto(ReceberVotoDto dto) {
        SessaoDto sessaoDto = this.sessaoService.buscarSessaoAberta(dto.getPauta());
        
        log.info("Votando: membro: {}, voto: {}, pauta: {}.", dto.getMembro(),
                dto.getVoto(), sessaoDto.getPauta());
        
        Optional<Votacao> votacaoOptional = repository.findByIdSessaoAndIdMembro(sessaoDto.getId(), dto.getMembro());
        
        if (votacaoOptional.isPresent()) {
            log.error("Voto negado! membro {} já votou na pauta {}!");
            throw new VotoNegadoException("Voto negado! membro " + dto.getMembro()  +" já votou na pauta " + dto.getPauta() + "!");
        }
        
        Votacao votacao = repository.save(VotacaoConversor.conversorDtoEntidade(dto, sessaoDto));
        return VotacaoConversor.conversorEntidadeDto(votacao);
    }

    @Override
    public ResultadoVotacaoDto buscarResultadoVotacao(Integer sessao) {
        SessaoDto sessaoDto = sessaoService.buscarSessao(sessao);
        
        if (LocalDateTime.now().isBefore(sessaoDto.getFim())) {
            log.error("tentativa de consulta de voto de uma sessão aberta.");
            throw new SessaoInvalidaException("A sessão ainda está aberta, aguarde a finalização para solicitar a contagem dos votos! Data e hora de fechamento: " + sessaoDto.getFim());
        }
        
        List<Votacao> listaDeVotos = repository.findByIdSessao(sessao);
        PautaDto pautaDto = pautaService.buscarPauta(sessaoDto.getPauta());
        
        return VotacaoConversor.conversorListaVotosParaResultadoVotacao(listaDeVotos, pautaDto.getDescricao());
    }
    
}
