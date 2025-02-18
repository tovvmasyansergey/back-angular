package com.example.backangular.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AllowAllCorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")  // Разрешаем Angular
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // Разрешаем все методы
                .allowedHeaders("*") // Разрешаем любые заголовки
                .exposedHeaders("X-Total-Count") // Если нужно, можно указывать заголовки для ответа
                .allowCredentials(true); // Разрешаем куки и аутентификацию
    }
}
