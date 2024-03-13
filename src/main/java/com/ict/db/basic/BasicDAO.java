package com.ict.db.basic;
// 실제 DB처리하는 DAO

import org.apache.ibatis.session.SqlSession;



public class BasicDAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = BasicDBService.getFactory().openSession();
		}
		return ss;
	}

	// DB 처리하는 메서드
	// 회원가입
	public static int getJoin(BasicVO bvo) {
		int result = 0;
		result = getSession().insert("guestbook2.join", bvo);
		ss.commit();

		return result;

	}

	public static BasicVO getLogin(BasicVO bvo) {
		BasicVO bvo2 = null;
		bvo2 = getSession().selectOne("guestbook2.login", bvo);
		return bvo2;
	}

	public static BasicVO getDetail(String id) {
		BasicVO bvo2 = null;
		bvo2 = getSession().selectOne("guestbook2.detail", id);
		return bvo2;
	}

	// 삽입 (insert)
	public static int getInsert(BasicVO bvo) {
		int result = 0;
		result = getSession().insert("guestbook2.insert", bvo);
		ss.commit();
		return result;
	}

	// idx 가지고 삭제하기
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("guestbook2.delete", idx);
		ss.commit();
		return result;
	}

	// vo를 받아서 업데이트 한다.
	public static int getUpdate(BasicVO bvo) {
		int result = 0;
		result = getSession().update("guestbook2.update", bvo);
		ss.commit();
		return result;
	}

}
