package com.airtel.inventory.controller;

import com.airtel.inventory.dto.LoginRequest;
import com.airtel.inventory.dto.LoginResponse;
import com.airtel.inventory.dto.RegisterRequest;
import com.airtel.inventory.entity.User;
import com.airtel.inventory.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepo;

    public AuthController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    // ==================== LOGIN USING REGNO ====================
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        // Login using regnumber instead of email
        User user = userRepo.findByRegno(request.getRegno())
                .orElseThrow(() -> new RuntimeException("User not found with this registration number"));

        // Simple password check
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponse(
                user.getUserId(),
                user.getFullName(),
                user.getEmail(),
                user.getRegno()
        );
    }

    // ==================== REGISTER NEW USER ====================
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {

        // Check if regno already exists
        if (userRepo.findByRegno(request.getRegno()).isPresent()) {
            throw new RuntimeException("Registration number already exists!");
        }

        // Check if email already exists
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists!");
        }

        // Create new user
        User user = new User();
        user.setFullName(request.getFullName());
        user.setRegno(request.getRegno());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword()); // In production, hash this password!

        return userRepo.save(user);
    }
}