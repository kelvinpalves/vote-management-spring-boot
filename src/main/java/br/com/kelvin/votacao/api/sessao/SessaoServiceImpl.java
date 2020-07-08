/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import br.com.kelvin.votacao.api.pauta.PautaDto;
import br.com.kelvin.votacao.api.pauta.PautaService;
import br.com.kelvin.votacao.config.exception.RegistroNaoEncontradoException;
import br.com.kelvin.votacao.config.exception.SessaoAbertaExistenteException;
import java.time.LocalDateTime;
import java.util.Objects;
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
public class SessaoServiceImpl implements SessaoService {

    private final Integer DURACAO_DEFAULT = 1;
    
    private final SessaoRepository repository;
    
    private final PautaService pautaService;
    
    @Autowired
    public SessaoServiceImpl(final SessaoRepository sessaoRepository, final PautaService pautaService) {
        this.repository = sessaoRepository;
        this.pautaService = pautaService;
    }
    
    @Override
    public SessaoDto abrirSessao(AberturaSessaoDto dto) {
        PautaDto pauta = pautaService.buscarPauta(dto.getPauta());
        
        log.info("Pauta: {}, encontrada na base de dados, abrindo sessão de votação.", pauta.getDescricao());
        
        LocalDateTime inicio = LocalDateTime.now();
        
        Optional<Sessao> sessaoOptional = repository.findBySessaoAberta(dto.getPauta(), inicio);
        
        if (sessaoOptional.isPresent()) {
            log.error("Já existe uma sessão de votação aberta para a pauta: {}", dto.getPauta());
            throw new SessaoAbertaExistenteException("Já existe uma sessão de votação aberta para a pauta: " + dto.getPauta());
        }
        
        Sessao sessao = Sessao.builder()
                .idPauta(pauta.getId())
                .inicio(inicio)
                .fim(getHoraFinalSessao(inicio, dto.getDuracao()))
                .build();
        
        sessao = repository.save(sessao);
        
        return SessaoConversor.conversorEntidadeDto(sessao);
    }
    
    private LocalDateTime getHoraFinalSessao(LocalDateTime inicio, Integer duracao) {
        duracao = Objects.isNull(duracao) ? DURACAO_DEFAULT : duracao;
        return inicio.plusMinutes(duracao);
    }
    
    @Override
    public SessaoDto buscarSessaoAberta(Integer pauta) {
        Optional<Sessao> sessaoOptional = repository.findBySessaoAberta(pauta, LocalDateTime.now());
        
        if (!sessaoOptional.isPresent()) {
            throw new RegistroNaoEncontradoException("Não foi encontrado sessão aberta para pauta: " + pauta);
        }
        
        return SessaoConversor.conversorEntidadeDto(sessaoOptional.get());
    }

    @Override
    public SessaoDto buscarSessao(Integer sessao) {
        Optional<Sessao> sessaoOptional = repository.findById(sessao);
        
        if (!sessaoOptional.isPresent()) {
            throw new RegistroNaoEncontradoException("Não foi encontrado sessão: " + sessao);
        }
        
        return SessaoConversor.conversorEntidadeDto(sessaoOptional.get());
    }
}
