package com.product.scenarioGenerator.repository;

import com.product.scenarioGenerator.model.ScenarioEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScenarioRepositoryTest {

    @Test
    public void testFindScenarios_ReturnsMatchingEntries() throws Exception {
        ScenarioRepository repo = new ScenarioRepository();
        List<ScenarioEntry> results = repo.findScenarios("java", "developer", "cloud");

        assertNotNull(results);
        assertFalse(results.isEmpty());
        for (ScenarioEntry entry : results) {
            assertEquals("java", entry.getTechnology());
            assertEquals("developer", entry.getRole());
            assertEquals("cloud", entry.getEnvironment());
        }
    }

    @Test
    public void testFindScenarios_NoMatch_ReturnsEmptyList() throws Exception {
        ScenarioRepository repo = new ScenarioRepository();
        List<ScenarioEntry> results = repo.findScenarios("unknown", "unknown", "unknown");

        assertNotNull(results);
        assertTrue(results.isEmpty());
    }
}
