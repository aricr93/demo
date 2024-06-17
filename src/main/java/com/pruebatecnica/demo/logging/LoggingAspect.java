package com.pruebatecnica.demo.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.pruebatecnica.demo.service.SpaceshipService.getSpaceshipById(..)) && args(id)")
    public void logNegativeIdRequest(JoinPoint joinPoint, Long id) {
        if (id < 0) {
            logger.warn("Request made for spaceship with negative id: {}", id);
        }
    }
}
