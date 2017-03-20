package com.example.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Codis;

@Mapper
public interface CodisMapper {

	@Select("SELECT * FROM CODIS")
	public List<Codis> selectAll();
	
	@Insert("INSERT INTO CODIS(requestId, fileName, yangpingName, dataNum, type)"
			+ " values (#{requestId,jdbcType=INTEGER},#{fileName,jdbcType=VARCHAR},#{yangpingName,jdbcType=VARCHAR},"
			+ "#{dataNum,jdbcType=VARCHAR},#{type,jdbcType=INTEGER})")
	public int insertCodis(Codis codis);
}
