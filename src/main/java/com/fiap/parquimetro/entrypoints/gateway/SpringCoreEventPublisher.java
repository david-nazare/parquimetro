package com.fiap.parquimetro.entrypoints.gateway;

import org.springframework.context.ApplicationEventPublisher;

import com.fiap.parquimetro.core.use_cases.CoreEventPublisher;

import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SpringCoreEventPublisher implements CoreEventPublisher {
    @NonNull
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(Object event) {
        log.info("Publicando evento {}", event);
        publisher.publishEvent(event);
    }
}
