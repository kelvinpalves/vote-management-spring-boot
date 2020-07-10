/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.votacao;

import br.com.kelvin.votacao.api.pauta.PautaService;
import br.com.kelvin.votacao.api.sessao.SessaoDto;
import br.com.kelvin.votacao.api.sessao.SessaoService;
import br.com.kelvin.votacao.api.votacao.ReceberVotoDto;
import br.com.kelvin.votacao.api.votacao.ResultadoVotacaoDto;
import br.com.kelvin.votacao.api.votacao.Votacao;
import br.com.kelvin.votacao.api.votacao.VotacaoRepository;
import br.com.kelvin.votacao.api.votacao.VotacaoServiceImpl;
import br.com.kelvin.votacao.cliente.ValidarAssociadoRestClient;
import br.com.kelvin.votacao.config.exception.SessaoInvalidaException;
import br.com.kelvin.votacao.config.exception.VotoNegadoException;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author kelvin
 */

@SpringBootTest
public class VotacaoServiceImplTest {
   
    @Mock
    VotacaoRepository repository;
    
    @Mock
    SessaoService sessaoService;
   
    @Mock
    PautaService pautaService;
    
    @Mock 
    ValidarAssociadoRestClient validarAssociadoRestClient;
    
    VotacaoServiceImpl votacaoServiceImpl;
    
    ReceberVotoDto receberVotoDto;
    
    @BeforeEach
    void beforeAll() {
        receberVotoDto = ReceberVotoDto.builder()
                .id(1)
                .cpfAssociado("76462400013")
                .pauta(1)
                .voto(Boolean.TRUE)
                .build();
        
        votacaoServiceImpl = new VotacaoServiceImpl(repository, sessaoService, pautaService, validarAssociadoRestClient);
    }
    
    @Test
    public void deveBloquearDuplicacaoDeVotoPorMembroParaMesmaPauta() {        
        when(sessaoService.buscarSessaoAberta(any(Integer.class)))
                .thenReturn(SessaoDto.builder().id(1).build());
        
        when(repository.findByIdSessaoAndCpfAssociado(any(Integer.class), any(String.class)))
                .thenReturn(Optional.of(Votacao.builder().id(1).build()));
        
        assertThrows(VotoNegadoException.class, 
                () -> votacaoServiceImpl.adicionarVoto(receberVotoDto));
        
    }
    
    @Test
    public void deveBloquearConsultaDeVotosParaSessaoAberta() {        
        SessaoDto sessaoDto = SessaoDto.builder()
                .id(1)
                .fim(LocalDateTime.now().plusMinutes(50))
                .build();
        
        when(sessaoService.buscarSessao(any(Integer.class)))
                .thenReturn(sessaoDto);
          
        assertThrows(SessaoInvalidaException.class, 
                () -> votacaoServiceImpl.buscarResultadoVotacao(any(Integer.class)));
        
    }
    
}
