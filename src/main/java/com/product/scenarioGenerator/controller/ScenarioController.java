package com.product.scenarioGenerator.controller;

import com.product.scenarioGenerator.model.ScenarioRequest;
import com.product.scenarioGenerator.model.ScenarioResponse;
import com.product.scenarioGenerator.service.ScenarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")  // Allows cross-origin requests from any domain (useful for local frontend testing)
@RestController  // Marks this class as a REST controller so Spring can handle HTTP requests/responses
@RequestMapping("/api/scenario")  // Base path for all endpoints in this controller
public class ScenarioController {

    private final ScenarioService scenarioService;

    // Constructor-based dependency injection for the service layer
    public ScenarioController(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    /**
     * Endpoint to generate a random IT scenario based on user input
     * URL: POST /api/scenario/generate-scenario
     * 
     * @param request The user's input containing technology, role, and environment
     * @return A matching random ScenarioResponse or error message if not found
     */
    @PostMapping("/generate-scenario")
    public ResponseEntity<?> generateScenario(@RequestBody ScenarioRequest request) {
        try {
            // Call service layer to fetch a matching scenario
            ScenarioResponse response = scenarioService.generateScenario(request);
            return ResponseEntity.ok(response);  // Return 200 OK with the scenario
        } catch (Exception e) {
            // If no matching scenario is found, return 404 with the error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
