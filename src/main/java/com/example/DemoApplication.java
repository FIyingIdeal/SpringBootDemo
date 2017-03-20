package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.dao.CodisMapper;

@EnableTransactionManagement	//启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@EnableScheduling		//发现注解@Scheduled的任务并后台执行
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CodisMapper codisMapper;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//启动执行
	@Override
	public void run(String... arg0) throws Exception {
		//System.out.println(this.codisMapper.selectAll());
	}
	
	//同一个工程中存在多个事务管理器（在Neo4j中存在一个），需要显示声明所需的事务管理器，并指定名字
	@Bean(name = "dsTxManager")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
