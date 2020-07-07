/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.pauta;

import br.com.kelvin.votacao.config.exception.RegistroNaoEncontradoException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kelvin
 */

@Service
public class PautaServiceImpl implements PautaService {
    
    private final PautaRepository repository;
    
    @Autowired
    public PautaServiceImpl(final PautaRepository pautaRepository) {
        this.repository = pautaRepository;
    }
  
    @Override
    public PautaDto criarPauta(PautaDto pautaDto) {
        Pauta pauta = PautaConversor.conversorDtoEntidade(pautaDto);
        pauta = repository.save(pauta);
        return PautaConversor.conversorEntidadeDto(pauta);
    }

    @Override
    public PautaDto buscarPauta(Integer id) {
        Optional<Pauta> pautaOptional = repository.findById(id);
        
        if (!pautaOptional.isPresent()) {
            throw new RegistroNaoEncontradoException("A pauta " +id + " não foi encontrada.");
        }
        
        return PautaConversor.conversorEntidadeDto(pautaOptional.get());
    }
    
}
