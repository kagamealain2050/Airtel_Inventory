package com.airtel.inventory.dto;

public class LoginRequest {
    private String regno;
    private String password;

    // Constructors
    public LoginRequest() {}

    public LoginRequest(String regno, String password) {
        this.regno = regno;
        this.password = password;
    }

    // Getters and Setters
    public String getRegno() { return regno; }
    public void setRegno(String regno) { this.regno = regno; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}