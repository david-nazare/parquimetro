package com.fiap.parquimetro.entrypoints.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.parquimetro.core.use_cases.CoreEventPublisher;
import com.fiap.parquimetro.entrypoints.gateway.SpringCoreEventPublisher;

@Configuration
public class GatewayConfig {
    @Bean
    CoreEventPublisher coreEventPublisher(final ApplicationEventPublisher applicationEventPublisher) {
        return new SpringCoreEventPublisher(applicationEventPublisher);
    }
}
