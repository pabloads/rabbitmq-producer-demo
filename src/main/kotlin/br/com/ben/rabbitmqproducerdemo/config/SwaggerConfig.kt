package br.com.ben.rabbitmqproducerdemo.config

import io.swagger.v3.oas.models.OpenAPI
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.ServletContext


@Controller
@Configuration
class SwaggerConfig {

    @Bean
    fun swaggerSettings(servletContext: ServletContext): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("rabbitmq-demo-public")
            .pathsToMatch("/**")
            .build();
    }

    @Bean
    fun rabbitmqDemoOpenAPI(): OpenAPI? {
        return OpenAPI()
    }

    @GetMapping("/")
    fun index(): String {
        return "redirect:swagger-ui.html"
    }
}