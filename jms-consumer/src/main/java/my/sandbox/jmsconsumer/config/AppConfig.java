package my.sandbox.jmsconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@Configuration
public class AppConfig {
    @Bean
    public MappingJackson2MessageConverter jacksonMessageConverter() {
        return new MappingJackson2MessageConverter();
    }
}
