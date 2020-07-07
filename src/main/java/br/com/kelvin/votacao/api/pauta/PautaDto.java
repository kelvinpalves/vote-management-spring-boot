/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.pauta;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author kelvin
 */

@Data
@Builder
public class PautaDto {
    private final Integer id;
    
    @NotBlank(message = "Uma pauta deve ser informada")
    private final String descricao;
}
