package de.neuefische.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/orders")
//@CrossOrigin(origins = "https://www.andreschreck.de", methods = RequestMethod.POST)
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping(consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }, produces = { MediaType.TEXT_HTML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public String order(@RequestParam MultiValueMap<String, String> paramMap, Principal principal) {
        orderRepository.save(new Order(null, paramMap.getFirst("product"), paramMap.getFirst("name"), paramMap.getFirst("street"), paramMap.getFirst("zip"), paramMap.getFirst("city"), principal.getName()));
        return "<html><body>success</body></html>";
    }

}
