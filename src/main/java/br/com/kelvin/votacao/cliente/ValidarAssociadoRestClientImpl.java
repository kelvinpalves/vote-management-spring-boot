/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.cliente;

import br.com.kelvin.votacao.config.exception.CpfInvalidoException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kelvin
 */
@Slf4j
@Component
public class ValidarAssociadoRestClientImpl implements ValidarAssociadoRestClient {

    private static final String URL = "https://user-info.herokuapp.com/users/{cpf}";
    private final String PODE_VOTAR = "ABLE_TO_VOTE";

    @Autowired
    public ValidarAssociadoRestClientImpl() {
    }

    @Override
    public Boolean validarAssociado(String cpf) throws CpfInvalidoException {
        try {
            RestTemplate rest = new RestTemplate();
            ResponseEntity<String> response = rest.getForEntity(URL, String.class, cpf);

            log.info("Validando se associado pode votar");

            if (response.getStatusCode().equals(HttpStatus.OK)) {
                Gson gson = new Gson();
                ValidarAssociadoDto validarAssociadoDto = gson.fromJson(response.getBody(), ValidarAssociadoDto.class);
                return validarAssociadoDto.getStatus().equals(PODE_VOTAR);
            } else {
                log.error("Ocorreu um erro ao validar a situação do associado.");

                if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                    throw new CpfInvalidoException("CPF Inválido! " + cpf);
                }

                log.error("Retorno: {}", response.getStatusCode());
                return Boolean.FALSE;
            }
        } catch (CpfInvalidoException cpfex) {
            throw cpfex;
        } catch (JsonSyntaxException | RestClientException ex) {
            log.error("Ocorre um erro ao realizar a consulta de associado.");
            return Boolean.FALSE;
        }
    }

}
