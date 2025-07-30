package com.product.scenarioGenerator.controller;

import com.product.scenarioGenerator.model.ScenarioRequest;
import com.product.scenarioGenerator.model.ScenarioResponse;
import com.product.scenarioGenerator.service.ScenarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")  
@RestController
@RequestMapping("/api/scenario")
public class ScenarioController {

    private final ScenarioService scenarioService;

    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    @PostMapping("/generate-scenario")
    public ResponseEntity<?> generateScenario(@RequestBody ScenarioRequest request) {
        try {
            ScenarioResponse response = scenarioService.generateScenario(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
