package com.product.scenarioGenerator.service;

import com.product.scenarioGenerator.model.ScenarioEntry;
import com.product.scenarioGenerator.model.ScenarioRequest;
import com.product.scenarioGenerator.model.ScenarioResponse;
import com.product.scenarioGenerator.repository.ScenarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ScenarioService {

    private final ScenarioRepository repository;

    public ScenarioService(ScenarioRepository repository) {
        this.repository = repository;
    }

    public ScenarioResponse generateScenario(ScenarioRequest request) throws Exception {
        List<ScenarioEntry> matches = repository.findScenarios(
                request.getTechnology(),
                request.getRole(),
                request.getEnvironment());

        if (matches.isEmpty()) {
            throw new Exception("No matching scenario found.");
        }

        ScenarioEntry selected = matches.get(new Random().nextInt(matches.size()));
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
