package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    private static final Logger logger = LoggerFactory.getLogger(CorsConfig.class);

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.info("✅ CORS настройки применяются...");

                registry.addMapping("/**")
                        .allowedOrigins("*") // Разрешаем запросы от всех доменов
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Все методы
                        .allowedHeaders("*") // Все заголовки
                        .allowCredentials(false); // Без авторизации

                logger.info("✅ CORS настроен: все пути разрешены для всех источников");
            }
        };
    }
}
