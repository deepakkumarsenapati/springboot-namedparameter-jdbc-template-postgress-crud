package com.deep.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deep.mappers.CompanyMapper;
import com.deep.models.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public List<Company> getCompany() {
		final String SQL = "select * from company";
		List<Company> resp = jdbc.query(SQL, new CompanyMapper());
		return resp;
	}

}
