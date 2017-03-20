package com.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.CodisRepository;
import com.example.domain.Codis;
import com.example.service.CodisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private CodisRepository repository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCodis() {
		List<Codis> codisList = repository.getCodis();
		for (Codis codis : codisList) {
			System.out.println(codis.getId() + ", " + codis.getRequestId());
		}
	}

}
