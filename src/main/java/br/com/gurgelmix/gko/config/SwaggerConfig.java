package br.com.gurgelmix.gko.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(apis())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
                .apiInfo(apiInfo());
    }

    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("br.com.gurgelmix.gko.info.controller");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("GurgelMix - GKO").description("Documentação da API Integração GKO").version("v1").build();
    }

    private List<ResponseMessage> responseMessageForGET() {
        return new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = 1L;

            {
                add(new ResponseMessageBuilder().code(401).message("Você não tem autorização para visualizar esse recurso").build());
                add(new ResponseMessageBuilder().code(404).message("O recurso que você está tentando acessar, não foi encontrado").build());
                add(new ResponseMessageBuilder().code(500).message("Foi gerada uma exceção").build());
                add(new ResponseMessageBuilder().code(403).message("Você não tem permissão para acessar este recurso!")
                        .build());
            }
        };
    }
}