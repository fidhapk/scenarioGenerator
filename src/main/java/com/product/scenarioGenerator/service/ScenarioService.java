package com.product.scenarioGenerator.service;

import com.product.scenarioGenerator.model.ScenarioEntry;
import com.product.scenarioGenerator.model.ScenarioRequest;
import com.product.scenarioGenerator.model.ScenarioResponse;
import com.product.scenarioGenerator.repository.ScenarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service  // Marks this class as a Spring service component
public class ScenarioService {

    private final ScenarioRepository repository;

    // Constructor-based dependency injection of the repository
    public ScenarioService(ScenarioRepository repository) {
        this.repository = repository;
    }

    /**
     * Generates a random IT scenario that matches the user input.
     *
     * @param request The user request containing technology, role, and environment
     * @return A ScenarioResponse object with a randomly selected matching scenario
     * @throws Exception if no matching scenario is found
     */
    public ScenarioResponse generateScenario(ScenarioRequest request) throws Exception {
        // Query the repository to find all matching scenarios based on input criteria
        List<ScenarioEntry> matches = repository.findScenarios(
                request.getTechnology(),
                request.getRole(),
                request.getEnvironment());

        // If no match is found, throw an exception to return 404 to the client
        if (matches.isEmpty()) {
            throw new Exception("No matching scenario found.");
        }

        // Randomly select one of the matching scenarios
        ScenarioEntry selected = matches.get(new Random().nextInt(matches.size()));

        // Create and return a response DTO based on the selected entry
        return new ScenarioResponse(
                selected.getTechnology(),
                selected.getRole(),
                selected.getEnvironment(),
                selected.getChallenge(),
                selected.getIncident(),
                selected.getTroubleshooting()
        );
    }
}
