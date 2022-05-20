package com.deep.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.deep.models.Company;

public class CompanyMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		Company bean = new Company();
		bean.setId(rs.getInt("ID"));
		bean.setName(rs.getString("NAME"));
		bean.setAge(rs.getInt("AGE"));
		bean.setAddress(rs.getString("ADDRESS"));
		bean.setSalary(rs.getFloat("SALARY"));
		return bean;
	}

}
