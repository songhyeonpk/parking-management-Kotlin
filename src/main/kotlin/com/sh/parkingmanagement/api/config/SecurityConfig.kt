package com.sh.parkingmanagement.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig {

    companion object {
        private val PERMIT_URLS = arrayOf(
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resource/**"
        )

        private const val LOCAL_SERVER_URL = "http://localhost:8080"

        private val ALLOWED_METHODS = arrayOf(
            HttpMethod.GET,
            HttpMethod.POST,
            HttpMethod.PUT,
            HttpMethod.PATCH,
            HttpMethod.DELETE,
            HttpMethod.OPTIONS
        )
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            // csrf 비활성화
            .csrf { it.disable() }
            // http basic 비활성화
            .httpBasic { it.disable() }
            // 로그아웃 비활성화
            .logout { it.disable() }
            // cors 설정
            .cors { it.configurationSource(corsConfigurationSource()) }
            // 경로별 인증, 인가 작업 설정
            .authorizeHttpRequests {
                it.apply {
                    // 접근 허용
                    PERMIT_URLS.forEach { url -> requestMatchers(url).permitAll() }

                    // 그 외 요청은 인증된 회원만 접근 가능
                    anyRequest().authenticated()
                }
            }
            // form login 비활성화
            .formLogin { it.disable() }
            // 세션 설정
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        return http.build()
    }

    // CORS 설정
    @Bean
    fun corsConfigurationSource(): UrlBasedCorsConfigurationSource {
        val config = CorsConfiguration().apply {
            allowCredentials = true // 자격 증명 허용
            addAllowedOriginPattern(LOCAL_SERVER_URL)   // 접근 허용 특정 출처
            addAllowedHeader("*")   // 모든 HTTP 헤더 허용
            ALLOWED_METHODS.forEach { addAllowedMethod(it) }    // 허용 HTTP 메서드
        }

        return UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", config)
        }
    }
}