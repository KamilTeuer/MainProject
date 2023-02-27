package cz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController     // @RestController = Tahleta třída bude sloužít pro restová rozhraní:
public class HelloController {
    
    @GetMapping     // GetMapping = Na jakou HTTP metodu budu reagovat.
    public HelloDTO hello(@RequestParam(name = "name") String name) {   // @ RequestParam = Abych mohl přidat parametr do URL
        return new HelloDTO(name);
    }

}
