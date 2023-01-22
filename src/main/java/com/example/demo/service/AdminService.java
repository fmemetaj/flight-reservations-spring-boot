package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Flight;
import com.example.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin login(String username, String password) {
        // Validate the username and password, and return the corresponding user if successful
        // ...
        return null;
    }

    public Admin signUp(String username, String password) {
        // Create a new user with the given username and password, and set the admin status
        // ...
        // Save the new user to the database
        // ...
        return null;
    }

    public List<Admin> getAllAdmins() {
        return null;
    }

    public Admin addAdmin(Admin admin) {
        return null;
    }

    public Flight updateFlight(Long id, Flight flight) {
        return null;
    }

    public void deleteFlight(Long id) {
    }
}
