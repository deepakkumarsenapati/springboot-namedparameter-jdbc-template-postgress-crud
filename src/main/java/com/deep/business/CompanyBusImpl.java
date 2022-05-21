package com.deep.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.dao.CompanyDao;
import com.deep.models.Company;

@Service
public class CompanyBusImpl implements CompanyBus {

	@Autowired
	private CompanyDao dao;

	@Override
	public List<Company> getAllCompany() {
		return dao.getAllCompany();
	}

	@Override
	public Company getCompanyById(int id) {
		return dao.getCompanyById(id);
	}

	@Override
	public int insertCompany(Company comp) {
		return dao.insertCompany(comp);
	}

	@Override
	public int updateCompany(Company comp) {
		return dao.updateCompany(comp);
	}

	@Override
	public int deleteCompanyById(int id) {
		return dao.deleteCompanyById(id);
	}

}
