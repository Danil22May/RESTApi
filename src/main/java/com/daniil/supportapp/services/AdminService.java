package com.daniil.supportapp.services;

import com.daniil.supportapp.repositories.AdminRepository;
import com.daniil.supportapp.models.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Optional<Admin> getAdminById(Long id) {
		return adminRepository.findById(id);
	}
}
