package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.basic.BasicDAO;
import com.ict.db.basic.BasicVO;

public class LoginOKCommand implements Command{

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		BasicVO bvo = new BasicVO();
		bvo.setId(request.getParameter("id"));
		bvo.setPwd(request.getParameter("pwd"));
		
		BasicVO bvo2 = BasicDAO.getLogin(bvo);
		
		if(bvo2 == null) {
			return "view/basic/loginForm.jsp";
		} else {
			request.setAttribute("bvo", bvo2);
			// index 에 display 를 위해서(보이게 안보이게)
			request.setAttribute("res", 1);
			
			return "view/basic/index.jsp";
			
		}
		
	}

}
