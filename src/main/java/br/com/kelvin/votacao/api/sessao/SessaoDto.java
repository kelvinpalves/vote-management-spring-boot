/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author kelvin
 */

@Data
@Builder
public class SessaoDto {
    
    private Integer id;
    private Integer pauta;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Boolean aberta;
    
}
