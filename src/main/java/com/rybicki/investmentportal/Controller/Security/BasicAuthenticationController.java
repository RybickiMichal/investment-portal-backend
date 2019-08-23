package com.rybicki.investmentportal.Controller.Security;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationBean authenticate(){
        return new AuthenticationBean("You are authenticated");
    }

}
