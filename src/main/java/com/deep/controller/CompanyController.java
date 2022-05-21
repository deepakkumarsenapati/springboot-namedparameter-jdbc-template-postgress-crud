package com.deep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deep.business.CompanyBus;
import com.deep.models.Company;

@RestController
public class CompanyController {

	@Autowired
	private CompanyBus bus;

	@GetMapping("/")
	public String defaultMapping() {
		return "Welcome to spring boot app!";
	}

	@GetMapping("company")
	public List<Company> getAllCompany() {
		return bus.getAllCompany();
	}

	@GetMapping("company/{id}")
	public Company getCompanyById(@PathVariable int id) {
		return bus.getCompanyById(id);
	}

	@PostMapping("company")
	public int insertCompany(@RequestBody Company comp) {
		return bus.insertCompany(comp);
	}

	@PutMapping("company")
	public int updateCompany(@RequestBody Company comp) {
		return bus.updateCompany(comp);
	}

	@DeleteMapping("company/{id}")
	public int deleteCompanyById(@PathVariable int id) {
		return bus.deleteCompanyById(id);
	}

}
