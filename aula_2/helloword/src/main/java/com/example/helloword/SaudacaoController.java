package com.example.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaudacaoController {
    private  final AtomicLong contador = new AtomicLong();
    private static final String template = "Hello, %s";

    @GetMapping("/saudacao")
    public Saudacao saudacao(
            //http://localhost:8080/saudacao/name=user
            @RequestParam(value = "name", defaultValue = "Word")String name) {
            return new Saudacao(
                    contador.incrementAndGet(),
                    String.format(template, name));
    }

}
