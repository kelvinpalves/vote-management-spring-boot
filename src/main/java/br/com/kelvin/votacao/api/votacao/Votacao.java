/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.api.votacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kelvin
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "votacao")
public class Votacao {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "id_sessao", nullable = false)
    private Integer idSessao;
    
    @Column(name = "cpf_associado", nullable = false)
    private String cpfAssociado;
    
    @Column(name = "voto", nullable = false)
    private Boolean voto;
}
