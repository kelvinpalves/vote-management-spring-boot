/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author kelvin
 */

@Data
@Builder
public class ReceberVotoDto {
    private Integer id;
    
    @NotNull(message = "Uma pauta deve ser informada")
    private Integer pauta;
    
    @NotNull(message = "Um membro deve ser informado")
    private String cpfAssociado;
    
    @NotNull(message = "A opção de voto deve ser informada")
    private Boolean voto;
}
