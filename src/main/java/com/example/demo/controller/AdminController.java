package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.model.SignUpRequest;
import com.example.demo.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Admin admin) {
        Admin loggedInAdmin = adminService.login(admin.getUsername(), admin.getPassword());
        if (loggedInAdmin != null) {
            return new ResponseEntity<>(loggedInAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Admin> signUp(@RequestBody SignUpRequest signUpRequestRequest) {
        Admin registeredUser = adminService.signUp(signUpRequestRequest.getUsername(), signUpRequestRequest.getPassword());
        if (registeredUser != null) {
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
