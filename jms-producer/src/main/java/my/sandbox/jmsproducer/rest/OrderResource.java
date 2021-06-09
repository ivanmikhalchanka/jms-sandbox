package my.sandbox.jmsproducer.rest;

import my.sandbox.jmsproducer.model.Order;
import my.sandbox.jmsproducer.service.OrderMessagingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    private final Map<String, OrderMessagingService> messagingServices;

    public OrderResource(Map<String, OrderMessagingService> messagingServices) {
        this.messagingServices = messagingServices;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestParam(defaultValue = "default") String service,
                                            @RequestBody Order order) {
        messagingServices.get(service).sendOrder(order);

        return ResponseEntity.ok().build();
    }
}