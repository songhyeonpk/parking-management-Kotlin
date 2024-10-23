package com.sh.parkingmanagement.api.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import java.util.*

@OpenAPIDefinition(
    info = Info(
        title = "parking management API DOCS",
        description = "주차 관리 API 명세서",
        version = "v1"
    )
)
@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        val securitySchema: SecurityScheme = SecurityScheme()
            .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
            .`in`(SecurityScheme.In.HEADER).name(HttpHeaders.AUTHORIZATION)
        val securityRequirement: SecurityRequirement = SecurityRequirement()
            .addList("bearerAuth")

        return OpenAPI()
            .components(Components().addSecuritySchemes("bearerAuth", securitySchema))
            .security(Collections.singletonList(securityRequirement))
    }
}