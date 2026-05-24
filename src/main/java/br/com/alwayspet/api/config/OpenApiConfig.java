package br.com.alwayspet.api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AlwaysPet API")
                        .version("1.0.0")
                        .description("API para acompanhamento da saúde do pet, com cadastro de responsáveis, pets e alertas preventivos.")
                        .contact(new Contact()
                                .name("Felipe Wiclif Leal da Silva")
                                .email("felipewicliflealdasilva@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositório do projeto AlwaysPet")
                        .url("hhttps://github.com/Wiclif06/challenger-apialwayspet"));
    }
}
