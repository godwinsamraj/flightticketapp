package com.flightticketbooking.flightticketbooking.data;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	public AdminService(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	} 
	public List<Admin> getAdmin() {
		return adminRepository.findAll();
	}
	public Boolean addNewAdmin(Admin admin) {
		Optional<Admin> adminOptional=adminRepository.findAdminByEmail(admin.getEmail());
		if(adminOptional.isPresent()) return false;
		adminRepository.save(admin);
		return true;
	}
	public Boolean deleteAdmin(Long adminId) {
		if(!adminRepository.existsById(adminId)) return false;
		adminRepository.deleteById(adminId);
		return true;
	}
	@Transactional
	public void updateAdmin(Admin newAdmin, String adminName) {
		Admin admin=adminRepository.findAdminByName(adminName)
				.orElseThrow(()->new IllegalStateException("Admin with name:"+adminName+"does not exists"));
		if(newAdmin.getName()!=null && newAdmin.getName().length()>0 && !Objects.equals(admin.getName(),newAdmin.getName()))
			admin.setName(newAdmin.getName());
		if(newAdmin.getEmail()!=null && newAdmin.getEmail().length()>0 && !Objects.equals(admin.getEmail(),newAdmin.getEmail()))
			admin.setEmail(newAdmin.getEmail());
		if(newAdmin.getPassword()!=null && newAdmin.getPassword().length()>0 && !Objects.equals(admin.getPassword(),newAdmin.getPassword()))
			admin.setPassword(newAdmin.getPassword());
		if(newAdmin.getAdminCode()!=null && newAdmin.getAdminCode().length()>0 && !Objects.equals(admin.getAdminCode(),newAdmin.getAdminCode()))
			admin.setAdminCode(newAdmin.getAdminCode());
	}
	public Boolean loginAdmin(Admin admin) {
		String adminEmail=admin.getEmail();
		Optional<Admin> adminData=adminRepository.findAdminByEmail(adminEmail);
		try {if(admin.getPassword().equals(adminData.get().getPassword()))return true;}
		catch(Exception e) {}
		return false;
	}
}
