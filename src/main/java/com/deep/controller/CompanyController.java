package com.deep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/company")
	public List<Company> getCompany() {
		return bus.getCompany();
	}

}
