package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/hello")
@SecurityRequirement(name = "bearer-key")
public class HelloController {

    @GetMapping()
    public String helloWorld(){
        String ayy = ("Ayyyy caramba").toUpperCase();
        return ayy;
    }

}
