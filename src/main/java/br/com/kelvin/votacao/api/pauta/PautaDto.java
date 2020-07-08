/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.pauta;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kelvin
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PautaDto {
    private Integer id;
    
    @NotBlank(message = "Uma pauta deve ser informada")
    private String descricao;
}
