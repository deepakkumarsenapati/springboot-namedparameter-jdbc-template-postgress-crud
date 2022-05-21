package com.deep.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.deep.exceptions.DaoExceptionHandler;
import com.deep.mappers.CompanyMapper;
import com.deep.models.Company;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	@Override
	public List<Company> getAllCompany() {
		final String SQL = "select * from company";
		List<Company> resp = jdbc.query(SQL, new CompanyMapper());
		return resp;
	}

	@Override
	public Company getCompanyById(int id) {
		final String SQL = "select * from company where id = :id";
		SqlParameterSource sqlParamSource = new MapSqlParameterSource("id", id);
		Company result = null;
		try {
			result = (Company) jdbc.queryForObject(SQL, sqlParamSource, new CompanyMapper());
		} catch (Exception e) {
			throw new DaoExceptionHandler("Company id not foud - " + id);
		}
		return result;
	}

	@Override
	public int insertCompany(Company comp) {
		final String SQL = "INSERT INTO company (ID,NAME,AGE,ADDRESS,SALARY) VALUES (:id, :name, :age, :address, :salary)";
		MapSqlParameterSource mapSqlparamSource = new MapSqlParameterSource();
		mapSqlparamSource.addValue("id", comp.getId());
		mapSqlparamSource.addValue("name", comp.getName());
		mapSqlparamSource.addValue("age", comp.getAge());
		mapSqlparamSource.addValue("address", comp.getAddress());
		mapSqlparamSource.addValue("salary", comp.getSalary());
		int result = 0;
		try {
			result = jdbc.update(SQL, mapSqlparamSource);
		} catch (Exception e) {
			throw new DaoExceptionHandler("Company id " + comp.getId() + " is exists");
		}
		return result;
	}

	@Override
	public int updateCompany(Company comp) {
		final String SQL = "UPDATE COMPANY SET name = :name, age = :age, address = :address, salary = :salary  WHERE id = :id";
		MapSqlParameterSource mapSqlparamSource = new MapSqlParameterSource();
		mapSqlparamSource.addValue("id", comp.getId());
		mapSqlparamSource.addValue("name", comp.getName());
		mapSqlparamSource.addValue("age", comp.getAge());
		mapSqlparamSource.addValue("address", comp.getAddress());
		mapSqlparamSource.addValue("salary", comp.getSalary());
		return jdbc.update(SQL, mapSqlparamSource);

	}

	@Override
	public int deleteCompanyById(int id) {
		final String SQL = "DELETE FROM COMPANY WHERE id = :id";
		MapSqlParameterSource mapSqlparamSource = new MapSqlParameterSource("id", id);
		return jdbc.update(SQL, mapSqlparamSource);

	}

}
