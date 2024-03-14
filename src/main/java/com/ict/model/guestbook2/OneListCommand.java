package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.GuestBook2DAO;
import com.ict.db.guestbook2.GuestBook2VO;
import com.ict.model.basic.Command;

public class OneListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		GuestBook2VO g2vo = GuestBook2DAO.getOnelist(idx);
		if(g2vo != null) {
			request.setAttribute("g2vo", g2vo); // g2vo 저장
			return "view/guestbook2/onelist.jsp";
			
		}else {
			return "view/guestbook2/error.jsp";
		}
	}
}
