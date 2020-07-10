/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kelvin.votacao.config.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author kelvin
 */
@Configuration
public class OpenApiConfig {
 
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Votação API")
                        .description("Serviços que serão utilizados para gerenciar votações de assembleias do cooperativismo.")
                        .contact(
                            new Contact()
                                    .name("Kelvin Pereira Alves")
                                    .email("kelvinpalves@gmail.com")
                                    .url("https://github.com/kelvinpalves"))
                        .version("1.0.0")
                );
    }
}