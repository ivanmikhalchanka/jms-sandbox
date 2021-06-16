package my.sandbox.jmsconsumer.web.rest;

import my.sandbox.jmsconsumer.model.Order;
import my.sandbox.jmsconsumer.service.OrderReceiverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderRestResource {
    private final Map<String, OrderReceiverService> receivers;

    public OrderRestResource(Map<String, OrderReceiverService> receivers) {
        this.receivers = receivers;
    }

    @GetMapping
    public ResponseEntity<Order> receive(@RequestParam(required = false, defaultValue = "default") String receiver) {
        Order order = receivers.get(receiver).receiveOrder();

        return ResponseEntity.ok(order);
    }
}
