package my.sandbox.jmsproducer.config;

import my.sandbox.jmsproducer.service.jms.ConvertAndSendService;
import my.sandbox.jmsproducer.service.jms.DefaultDestinationService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import javax.jms.Destination;

@Configuration
public class AppConfig {
    private final String jmsCustomDestination;

    public AppConfig(@Value("${app.jms.custom-destination}") String jmsCustomDestination) {
        this.jmsCustomDestination = jmsCustomDestination;
    }

    /**
     * used in
     * @see DefaultDestinationService
     */
    @Bean
    public Destination customDestination() {
        return new ActiveMQQueue(jmsCustomDestination);
    }

    /**
     * used in
     * @see ConvertAndSendService
     * @see my.sandbox.jmsproducer.service.jms.PostProcessingService
     */
    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        return new MappingJackson2MessageConverter();
    }
}