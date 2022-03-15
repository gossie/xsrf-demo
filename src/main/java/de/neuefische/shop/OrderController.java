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

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public void order(@RequestBody Order order) {
        orderRepository.save(order);
    }

}
