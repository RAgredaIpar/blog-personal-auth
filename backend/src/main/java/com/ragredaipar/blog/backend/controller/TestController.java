package com.ragredaipar.blog.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/protected")
public class TestController {

    @GetMapping
    public String protectedEndpoint() {
        return "Solo puedes ver esto si estás autenticado con un JWT válido.";
    }
}
