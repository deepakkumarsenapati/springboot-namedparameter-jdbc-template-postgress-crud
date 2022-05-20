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
	public List<Company> getCompany() {
		return dao.getCompany();
	}

}
