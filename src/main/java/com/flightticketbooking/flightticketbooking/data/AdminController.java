package com.flightticketbooking.flightticketbooking.data;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {
	private final AdminService adminService;
	public AdminController(AdminService adminService) {
		this.adminService=adminService;
	}
	@GetMapping
	public List<Admin> getAdmin(){
		return adminService.getAdmin();
	}
	@PostMapping("/add")
	public Boolean registerNewAdmin(@RequestBody Admin admin) {
		return adminService.addNewAdmin(admin);
	}
	@DeleteMapping("/delete/{adminId}")
	public Boolean deleteAdmin(@PathVariable("adminId") Long adminId) {
		return adminService.deleteAdmin(adminId);
	}
	@PostMapping("/loginAdmin/{email}/{password}")
	public Boolean loginPerson(@ModelAttribute("admin") Admin admin) {
		return adminService.loginAdmin(admin);
	}
	@PutMapping("/update/{adminName}")
	public void updateAdmin(@RequestBody Admin newAdmin,@PathVariable("adminName") String adminName) {
		adminService.updateAdmin(newAdmin,adminName);
	}
}