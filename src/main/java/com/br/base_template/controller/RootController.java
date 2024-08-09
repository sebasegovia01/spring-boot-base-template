package com.br.base_template.controller;

import com.br.base_template.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/service-channels/v1")
    public void handleRoot() {
        throw new ResourceNotFoundException("The requested resource was not found");
    }
}