package com.sh.parkingmanagement.core.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueryDslConfig(private val em: EntityManager) {

    @Bean
    fun query(): JPAQueryFactory = JPAQueryFactory(em)
}