package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.domain.Codis;

@Repository
public class CodisRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public List<Codis> getCodis() {
		String sql = "select * from codis";
		List<Codis> codises = jdbcTemplate.query(sql, new RowMapper<Codis>() {

			@Override
			public Codis mapRow(ResultSet resultSet, int i) throws SQLException {
				Codis codis = new Codis();
				codis.setId(resultSet.getInt("id"));
				codis.setRequestId(resultSet.getInt("requestId"));
				return codis;
			}
		});
		return codises;
	}
}
