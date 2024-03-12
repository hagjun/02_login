package com.ict.db.session;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionDBService {
	static private SqlSessionFactory factory;
	static String resource = "com/ict/db/session/session_config.xml";
	// static 초기화
	static {
		try {
			// "com/ict/db/basic_config.xml" 읽으세요~
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
		}
	}
	
	// DAO에서 factory를 호출할 메서드
	public static SqlSessionFactory getFactory() {
		// factory : config.xml파일을 읽어드린 factory 정보를 가져온다.
		return factory;
	}
}
