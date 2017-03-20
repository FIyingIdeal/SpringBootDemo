package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CodisMapper;
import com.example.domain.Codis;

@Service
public class CodisService {

	@Autowired
	private CodisMapper codisMapper;
	
	public List<Codis> selectAllCodis() {
		List<Codis> allCodis = codisMapper.selectAll();
		return allCodis;
	}
	
	@Transactional(rollbackFor = Exception.class, value = "dsTxManager")//由于有两个事务管理器，需要显示指定名字
	public int insertCodis() throws Exception {
		int requestId = 20130621;
		int num = 0;
		for (int i = 0; i < 5; i++) {
			Codis codis = new Codis();
			codis.setFileName("spring boot test");
			codis.setRequestId(requestId);
			codis.setYangpingName("test");
			codis.setType(num);
			num += codisMapper.insertCodis(codis);
			requestId += i;
			if (i == 3) {
				throw new Exception();
			}
		}
		return num;
	}
}
