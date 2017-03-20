package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RequestMapping("/test")*/
public class HelloController {

	@RequestMapping("/")
	public Object hello() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "人案");
		map1.put("value", 17257);
		map1.put("rateOfncrease", "14%");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "案案");
		map2.put("value", 6098);
		map2.put("rateOfncrease", "14%");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "人人");
		map3.put("value", 16538);
		map3.put("rateOfncrease", "28%");
		
		Map<String, Object>[] mapArray = new HashMap[3];
		mapArray[0] = map1;mapArray[1] = map2;mapArray[2] = map3;
		/*List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(map1);list.add(map2);list.add(map3);*/
		map.put("resultTotal", mapArray);

		return map;
		//return "Hello World";
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping("/cros")
	public String CROSTest() {
		return "CROS success!";
	}
}
