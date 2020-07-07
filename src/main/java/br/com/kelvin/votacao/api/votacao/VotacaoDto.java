/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author kelvin
 */

@Builder
@Data
public class VotacaoDto {
    private Integer id;
    private Integer sessao;
    private Integer membro;
    private Boolean voto;
}
