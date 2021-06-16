package my.sandbox.jmsconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsConsumerApplication {

    public static void main(String[] args) {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");
        System.setProperty("org.apache.activemq.artemis.jms.deserialization.whitelist", "*");
        SpringApplication.run(JmsConsumerApplication.class, args);
    }

}
