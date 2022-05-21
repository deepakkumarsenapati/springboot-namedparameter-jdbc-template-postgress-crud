package com.deep.business;

import java.util.List;

import com.deep.models.Company;

public interface CompanyBus {
	public List<Company> getAllCompany();

	public Company getCompanyById(int id);

	public int insertCompany(Company comp);

	public int updateCompany(Company comp);
	
	public int deleteCompanyById(int id);
}
