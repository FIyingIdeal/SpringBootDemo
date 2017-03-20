package com.example;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.config.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableNeo4jRepositories(basePackages = "com.example.dao")
@EnableTransactionManagement
public class MyConfiguration extends Neo4jConfiguration {

	@Bean
	public SessionFactory getSessionFactory() {
		return new SessionFactory(getConfiguration(), "com.example.domain.neo4j");
	}
	
	public Configuration getConfiguration() {
		Configuration config = new Configuration();
		config.driverConfiguration()
			.setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
			.setCredentials("neo4j", "123456")
			.setURI("http://localhost:7474");
		return config;
	}

	@Bean
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Session getSession() throws Exception {
		return super.getSession();
	}
	
	
	
}