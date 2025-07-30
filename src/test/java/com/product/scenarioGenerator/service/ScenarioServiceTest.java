package com.product.scenarioGenerator.service;

import com.product.scenarioGenerator.model.ScenarioEntry;
import com.product.scenarioGenerator.model.ScenarioRequest;
import com.product.scenarioGenerator.model.ScenarioResponse;
import com.product.scenarioGenerator.repository.ScenarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ScenarioServiceTest {

    private ScenarioService service;
    private ScenarioRepository mockRepo;

    //Initializes mock dependencies before each test.
    @BeforeEach
    public void setup() {
        mockRepo = mock(ScenarioRepository.class);
        service = new ScenarioService(mockRepo);
    }

    //Test case: No matching scenarios are found for the user's input.
    @Test
    public void testGenerateScenario_NoMatchFound_ThrowsException() {
        ScenarioRequest request = new ScenarioRequest();
        request.setTechnology("TestTech");
        request.setRole("TestRole");
        request.setEnvironment("TestEnv");

        when(mockRepo.findScenarios("TestTech", "TestRole", "TestEnv"))
                .thenReturn(Collections.emptyList());

        Exception exception = assertThrows(Exception.class, () ->
                service.generateScenario(request));

        assertEquals("No matching scenario found.", exception.getMessage());
    }

    //Test case: A matching scenario is found for the given request.
    @Test
    public void testGenerateScenario_Success() throws Exception {
        ScenarioRequest request = new ScenarioRequest();
        request.setTechnology("java");
        request.setRole("developer");
        request.setEnvironment("cloud");

        // Create a mock ScenarioEntry to match input
        ScenarioEntry entry = new ScenarioEntry();
        entry.setTechnology("java");  // lowercase here
        entry.setRole("developer");
        entry.setEnvironment("cloud");
        entry.setChallenge("Challenge A");
        entry.setIncident("Incident A");
        entry.setTroubleshooting("Troubleshooting A");

         // Mock repository to return a match
        when(mockRepo.findScenarios("java", "developer", "cloud"))
                .thenReturn(List.of(entry));

        ScenarioResponse response = service.generateScenario(request);

        // Call service and verify response
        assertNotNull(response);
        assertEquals("java", response.getTechnology());  // lowercase check
        assertEquals("developer", response.getRole());
        assertEquals("cloud", response.getEnvironment());
    }

}
