package com.airtel.inventory.dto;

public class LoginResponse {
    private Long userId;
    private String fullName;
    private String email;
    private String regno;

    public LoginResponse(Long userId, String fullName, String email, String regno) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.regno = regno;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRegno() { return regno; }
    public void setRegno(String regno) { this.regno = regno; }
}