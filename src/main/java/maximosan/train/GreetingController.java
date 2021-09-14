package maximosan.train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class GreetingController {
    @GetMapping(value="/")
    public String hello() {
        return "pepe";
    }
}
