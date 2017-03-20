package com.example.neo4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

/**
 * <p>Title: Person </p>
 * <p>Description: TODO </p>
 * Date: 2016年11月15日 下午1:42:23
 * @author Administrator@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年11月15日         Administrator         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class Person {
	
	String name;
	int age;
	double height;
	double weight;
	String birthdate;
	String province_code;
	String city_code;
	String city_name;
	
	@Test
	public void getProvince() {
		String province = "安徽,北京,福建,甘肃,广东,广西,贵州,海南,河北,河南,黑龙江,湖北,湖南,吉林,江苏,江西,辽宁,内蒙古,宁夏,青海,山东,山西,陕西,上海,四川,天津,西藏,新疆,云南,浙江,重庆";
		String[] provinces = province.split(",");
		StringBuilder stringBuilder = new StringBuilder();
		for (String pro : provinces) {
			stringBuilder.append("\"" + pro + "\",");
		}
		System.out.println(stringBuilder.toString());
	}
	
	@Test
	public void dateTest() {
		String dateString = "2016-11-24";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(dateString);
			System.out.println(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date now = new Date();
		System.out.println(now.getTime());
		System.out.println(now.getHours());
		System.out.println(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}
	
	@Test
	public void test() {
		String dateString = "2016-11-24";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		try {
			Date date = dateFormat.parse(dateString);
			now = dateFormat.parse(dateFormat.format(now));
			System.out.println(date.equals(now) ? 0 : date.after(now) ? 1 : -1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		String dateSring = "2016-11-25";
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateSring);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void rplaceTest() {
		String date = "2016/11/25";
		System.out.println(date.replaceAll("/", "-"));
	}
	
	@Test
	public void random() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			int randomInt =random.nextInt(30 - 0) + 0;
			if (randomInt > 29) {
				System.out.println(randomInt);
			}
		}
	}

}
