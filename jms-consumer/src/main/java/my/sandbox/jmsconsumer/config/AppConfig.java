package my.sandbox.jmsconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class AppConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new SimpleMessageConverter();
    }
}
