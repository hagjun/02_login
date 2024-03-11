package com.ict.db.cookie;
// 실제 DB처리하는 DAO

import org.apache.ibatis.session.SqlSession;

public class CookieDAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = CookieDBService.getFactory().openSession();
		}
		return ss;
	}
	
	// DB 처리하는 메서드
	// 회원가입
	public static int getJoin(CookieVO bvo) {
		int result = 0;
		result = getSession().insert("cookieUser.c_join", bvo);
		ss.commit();
		
		return result;
		
	}
	
	public static CookieVO getLogin(CookieVO bvo) {
		CookieVO bvo2 = null;
		bvo2 = getSession().selectOne("cookieUser.c_login", bvo);
		return bvo2;
	}
	
	public static CookieVO getDetail(String id) {
		CookieVO bvo2 = null;
		bvo2 = getSession().selectOne("cookieUser.c_detail", id);
		return bvo2;
	}
	
	
	
	
}
