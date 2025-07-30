package com.product.scenarioGenerator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ScenarioGeneratorApplicationTest {

    @Test
    public void testMainMethodRunsWithoutException() {
        assertDoesNotThrow(() -> new SpringApplicationBuilder(ScenarioGeneratorApplication.class)
                .web(WebApplicationType.NONE) // <- disables Tomcat startup
                .run());
    }
}
