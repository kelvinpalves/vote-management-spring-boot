/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author kelvin
 */

@Data
@Builder
public class AberturaSessaoDto {
    @NotNull( message = "Uma pauta deve ser informada")
    private Integer pauta;
    private Integer duracao;
}
