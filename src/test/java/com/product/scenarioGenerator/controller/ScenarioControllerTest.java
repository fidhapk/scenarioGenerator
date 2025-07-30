package com.product.scenarioGenerator.controller;

import com.product.scenarioGenerator.model.ScenarioRequest;
import com.product.scenarioGenerator.model.ScenarioResponse;
import com.product.scenarioGenerator.service.ScenarioService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ScenarioControllerTest {

    // Test case: Valid scenario request returns a matching scenario.
    @Test
    public void testGenerateScenario_Success() throws Exception {
        ScenarioRequest request = new ScenarioRequest();
        request.setTechnology("java");
        request.setRole("developer");
        request.setEnvironment("cloud");

        ScenarioResponse response = new ScenarioResponse(
                "java", "developer", "cloud",
                "challenge", "incident", "troubleshooting"
        );

        ScenarioService mockService = mock(ScenarioService.class);
        when(mockService.generateScenario(any(ScenarioRequest.class))).thenReturn(response);

        ScenarioController controller = new ScenarioController(mockService);

        ResponseEntity<?> entity = controller.generateScenario(request);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(response, entity.getBody());
    }

    // Test case: No matching scenario is found for the request.
    @Test
    public void testGenerateScenario_NotFound() throws Exception {
        ScenarioRequest request = new ScenarioRequest();
        request.setTechnology("unknown");
        request.setRole("unknown");
        request.setEnvironment("unknown");

        ScenarioService mockService = mock(ScenarioService.class);
        when(mockService.generateScenario(any(ScenarioRequest.class)))
                .thenThrow(new Exception("No matching scenario found."));

        ScenarioController controller = new ScenarioController(mockService);

        ResponseEntity<?> entity = controller.generateScenario(request);

        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
        assertEquals("No matching scenario found.", entity.getBody());
    }
}
