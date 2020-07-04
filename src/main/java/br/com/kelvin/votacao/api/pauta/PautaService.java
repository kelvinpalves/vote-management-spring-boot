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
public interface PautaService {
    
    public PautaDto criarPauta(PautaDto pautaDto);
    
    public PautaDto buscarPauta(Integer id);
    
}
