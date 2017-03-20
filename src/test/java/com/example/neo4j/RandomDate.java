package com.example.neo4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

/**
 * <p>Title: RandomDate </p>
 * <p>Description: TODO </p>
 * Date: 2016年11月15日 下午2:01:37
 * @author Administrator@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年11月15日         Administrator         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class RandomDate {
	
	@Test
	public void main() {
		for (int i = 0; i < 50; i++) {
			Date randomDate = randomDate("1980-01-01", "2016-11-15");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(simpleDateFormat.format(randomDate));
		}
	}
	
	public Date randomDate(String beginDate, String endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = format.parse(beginDate);
			Date end = format.parse(endDate);
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public long random(long begin, long end) {
		long time = begin + (long)(Math.random() * (end - begin));
		if (time == begin || time == end) {
			return random(begin, end);
		}
		return time;
	}
}
