package com.example.neo4j;

import org.neo4j.driver.internal.value.IntegerValue;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;

/**
 * <p>Title: Neo4jConnByBolt </p>
 * <p>Description: TODO </p>
 * Date: 2016年11月11日 下午5:52:21
 * @author Administrator@hiynn.com
 * @version 1.0 </p> 
 * Significant Modify：
 * Date               Author           Content
 * ==========================================================
 * 2016年11月11日         Administrator         创建文件,实现基本功能
 * 
 * ==========================================================
 */
public class Neo4jConnByBolt {

	public static void main(String[] args) {
		Driver driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "123456"));
		Session session = driver.session();
		
		StatementResult result = null;//session.run("match (p:Person) where id(p)=22 return p");
		/*while (result.hasNext()) {
			Record record = result.next();
			System.out.println(record.fields());
			System.out.println(record.get("p").get("name").asString());
		}*/
		for (int i = 0; i < 30; i++) {
			result = session.run("create (p:Person {name:'cc', born:1990}) return id(p)");
			Record record = result.single();
			System.out.println(record.get(0).asInt());
		}
		
	}
}
