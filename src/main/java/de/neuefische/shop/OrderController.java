package de.neuefische.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "https://www.andreschreck.de/xsrf-example.html")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public String order(@RequestBody Order order) {
        orderRepository.save(order);
        return "<html><body>success</body></html>";
    }

}
