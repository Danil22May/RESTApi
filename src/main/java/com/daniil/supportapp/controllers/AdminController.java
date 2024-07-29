package com.daniil.supportapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniil.supportapp.models.Admin;
import com.daniil.supportapp.services.AdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/admin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		Admin newAdmin = adminService.createAdmin(admin);
		return new ResponseEntity<>(newAdmin, HttpStatus.OK);
	}

	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable Long id) {
		return adminService.getAdminById(id).orElseThrow();
	}

	@PostMapping("/login")
	public ResponseEntity<Admin> login(@RequestBody Admin admin) {
		List<Admin> admins = adminService.getAllAdmins();

		for (Admin element : admins) {
			if (admin.getUsername().equals(element.getUsername())
					&& admin.getPassword().equals(element.getPassword())) {
				return ResponseEntity.ok(element);
			}
		}
		return ResponseEntity.status(403).body(null);
	}

}
