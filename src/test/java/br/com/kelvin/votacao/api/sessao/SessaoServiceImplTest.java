/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import br.com.kelvin.votacao.api.pauta.PautaDto;
import br.com.kelvin.votacao.api.pauta.PautaService;
import br.com.kelvin.votacao.config.exception.SessaoAbertaExistenteException;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 *
 * @author kelvin
 */

@SpringBootTest
public class SessaoServiceImplTest {
    
    @Mock
    SessaoRepository repository;
    
    @Mock
    PautaService pautaService;
    
    LocalDateTime localDateTime;
    
    SessaoServiceImpl sessaoServiceImpl;
    
    Sessao sessao;    
    
    AberturaSessaoDto aberturaSessaoDto;
    
    @BeforeEach
    void beforeAll() {
        localDateTime = LocalDateTime.of(2020, 5, 10, 10, 10, 15);
        sessao = new Sessao(1, 1, localDateTime, localDateTime.plusMinutes(1));
        
        aberturaSessaoDto = AberturaSessaoDto.builder()
                .pauta(1)
                .duracao(1)
                .build();
        
        sessaoServiceImpl = new SessaoServiceImpl(repository, pautaService);
    }
    
    @Test
    void deveBloquearCadastroDeSessaoAbertaParaMesmaPauta() {
        when(pautaService.buscarPauta(any(Integer.class)))
                .thenReturn(PautaDto.builder().id(1).descricao("Pauta Teste").build());
        
        when(repository.findBySessaoAberta(any(Integer.class), any(LocalDateTime.class)))
                .thenReturn(Optional.of(sessao));
        
        assertThrows(SessaoAbertaExistenteException.class, 
                () -> sessaoServiceImpl.abrirSessao(aberturaSessaoDto));
    }
    
}
