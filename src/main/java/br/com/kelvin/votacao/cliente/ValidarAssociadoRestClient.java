/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.cliente;

import br.com.kelvin.votacao.config.exception.CpfInvalidoException;

/**
 *
 * @author kelvin
 */
public interface ValidarAssociadoRestClient {
    
    public Boolean validarAssociado(String cpf) throws CpfInvalidoException;
    
}
