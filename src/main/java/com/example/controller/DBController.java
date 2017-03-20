package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/2.
 */
@RestController
@EnableAutoConfiguration
/*@RequestMapping("/db")*/
public class DBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/getCodis")
    public List<Map<String, Object>> getData() {
        String sql = "select * from codis";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }
    
    @RequestMapping("/test")
    public String test() {
    	return "spring boot";
    }
}

