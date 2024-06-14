package com.example.pagina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mapa {
    @GetMapping("/hola")
    public String holaMundo() {
        return "index"; // Nombre del archivo HTML en el directorio templates, sin la extensión .html
    }
}
