package com.br.base_template.controller;

import com.br.base_template.dto.HealthCheckResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping({"/health", "/"})
    public HealthCheckResponse healthCheck() {
        return new HealthCheckResponse("Api is up");
    }
}