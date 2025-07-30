package com.product.scenarioGenerator.model;

public class ScenarioEntry {
    private String technology;
    private String role;
    private String environment;
    private String challenge;
    private String incident;
    private String troubleshooting;

    // Getters and Setters
    public String getTechnology() { return technology; }
    public void setTechnology(String technology) { this.technology = technology; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }

    public String getChallenge() { return challenge; }
    public void setChallenge(String challenge) { this.challenge = challenge; }

    public String getIncident() { return incident; }
    public void setIncident(String incident) { this.incident = incident; }

    public String getTroubleshooting() { return troubleshooting; }
    public void setTroubleshooting(String troubleshooting) { this.troubleshooting = troubleshooting; }
}
