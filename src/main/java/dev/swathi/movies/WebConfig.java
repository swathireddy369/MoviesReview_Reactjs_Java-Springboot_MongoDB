package dev.swathi.movies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
   @Value(("${frontend.Url}"))
   private  String frontendUrl;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Add CORS configuration for all endpoints
        registry.addMapping("/**")  // Apply this configuration to all endpoints
                .allowedOrigins(frontendUrl)  // Allow requests from your React frontend (localhost:3000)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true)  // Allow credentials (cookies, session, etc.)
                .maxAge(3600);  // Cache pre-flight response for 1 hour
    }
}
