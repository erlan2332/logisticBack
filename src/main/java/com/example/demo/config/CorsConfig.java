package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("https://logistic-4y5n.onrender.com") // Разрешаем фронтенд
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешенные методы
                        .allowedHeaders("*") // Разрешаем все заголовки
                        .allowCredentials(true); // Позволяем куки и заголовки авторизации
            }
        };
    }
}
