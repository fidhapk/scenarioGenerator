package com.product.scenarioGenerator.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScenarioModelTest {

    @Test
    public void testScenarioRequestModel() {
        ScenarioRequest req = new ScenarioRequest();
        req.setTechnology("Tech");
        req.setRole("Role");
        req.setEnvironment("Env");

        assertEquals("Tech", req.getTechnology());
        assertEquals("Role", req.getRole());
        assertEquals("Env", req.getEnvironment());
    }

    @Test
    public void testScenarioResponseModel() {
        ScenarioResponse res = new ScenarioResponse("Tech", "Role", "Env", "Challenge", "Incident", "Troubleshooting");

        assertEquals("Tech", res.getTechnology());
        assertEquals("Role", res.getRole());
        assertEquals("Env", res.getEnvironment());
        assertEquals("Challenge", res.getChallenge());
        assertEquals("Incident", res.getIncident());
        assertEquals("Troubleshooting", res.getTroubleshooting());
    }

    @Test
    public void testScenarioEntryModel() {
        ScenarioEntry entry = new ScenarioEntry();
        entry.setChallenge("Challenge");
        entry.setIncident("Incident");
        entry.setTroubleshooting("Troubleshooting");

        assertEquals("Challenge", entry.getChallenge());
        assertEquals("Incident", entry.getIncident());
        assertEquals("Troubleshooting", entry.getTroubleshooting());
    }
}
