/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.sessao;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Entity
public class Sessao {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "id_pauta", nullable = false)
    private Integer idPauta;
    
    @Column(name = "inicio", nullable = false)
    private LocalDateTime inicio;
    
    @Column(name = "fim", nullable = false)
    private LocalDateTime fim;
    
}
