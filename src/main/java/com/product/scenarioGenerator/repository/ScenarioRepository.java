package com.product.scenarioGenerator.repository;

import com.product.scenarioGenerator.model.ScenarioEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ScenarioRepository {

    private final List<ScenarioEntry> allScenarios;

    public ScenarioRepository() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new ClassPathResource("scenarios.json").getInputStream();
        allScenarios = mapper.readValue(is, new TypeReference<List<ScenarioEntry>>() {});
    }

    public List<ScenarioEntry> findScenarios(String technology, String role, String environment) {
        return allScenarios.stream()
                .filter(s -> s.getTechnology().equalsIgnoreCase(technology))
                .filter(s -> s.getRole().equalsIgnoreCase(role))
                .filter(s -> s.getEnvironment().equalsIgnoreCase(environment))
                .collect(Collectors.toList());
    }
}
