package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ict.db.session.SessionVO;

public class SessionProfileCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// session 에 저장된 svo 를 꺼내자
		// HttpSession session = request.getSession();
		// object 를 가져와서 형변환 해야 한다.
		// SessionVO svo = (SessionVO) session.getAttribute("svo"); 
		
		
		// 비밀번호가 맞는지 틀리는지 확인
		// request.setAttribute("pwd", svo.getPwd());
		
		// EL 은
		// PageContext, application, request, session 
		// 에 저장되어 있어서 끄집어 낼 필요가 없다.
		return "view/session/profile.jsp";
	}
}
