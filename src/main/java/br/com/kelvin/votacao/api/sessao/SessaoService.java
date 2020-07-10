/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import java.util.List;

/**
 *
 * @author kelvin
 */

public interface SessaoService {
    
    public SessaoDto abrirSessao(AberturaSessaoDto dto);
    
    public SessaoDto buscarSessaoAberta(Integer pauta);
    
    public SessaoDto buscarSessao(Integer sessao);
    
}
