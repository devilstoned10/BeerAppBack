package com.crudapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crudapp.dao.BeerDAO;
import com.crudapp.model.Beer;

@Repository
public class BeerDAOImpl implements BeerDAO {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Beer> getAllBeers() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM BEER;");
		return jdbcTemplate.query(sql.toString(), new RowMapper<Beer>() {

			public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Beer beer = new Beer();
				beer.setAlcoholPercent(rs.getDouble(3));
				beer.setDescription(rs.getString(4));
				beer.setId(rs.getInt(1));
				beer.setName(rs.getString(2));
				return beer;
			}
		});
		
	}

	public int addBeer(Beer beer) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BEER(NAME,ALCOHOL_PERCENT,DESCRIPTION) VALUES (:name,:alcohol,:desc);");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", beer.getName());
		paramMap.put("alcohol", Double.valueOf(beer.getAlcoholPercent()));
		paramMap.put("desc", beer.getDescription());
		return jdbcTemplate.update(sql.toString(), paramMap);
	}

	public Beer updateBeer(Beer beer) {
		// To be implemented.
		return beer;
	}

	public int deleteBeer(Beer beer) {
		// To be implemented
		return 1;
	}

}
