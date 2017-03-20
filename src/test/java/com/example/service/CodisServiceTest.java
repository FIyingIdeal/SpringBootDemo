package com.example.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Codis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodisServiceTest {

	@Autowired
	private CodisService codisService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSelectAllCodis() {
		for (Codis codis : codisService.selectAllCodis()) {
			System.out.println(codis.getId() + "  " + codis.getYangpingName());
		}
	}
	
	@Test
	public void testInsertCodis() {
		try {
			System.out.println(codisService.insertCodis());
		} catch (Exception e) {
			System.out.println("Exception occurred");
			e.printStackTrace();
		}
	}

}
