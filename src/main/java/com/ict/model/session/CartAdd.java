package com.ict.model.session;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartAdd {
	// session 카트에 담기
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String fruits = request.getParameter("fruits");
		HttpSession session = request.getSession(); // 세션 불러오기
		
		// 장바구니의 크기를 알 수 없다. ( 컬렉션에 담아야 한다.)
		
		// session 에 있는 list 호출
		ArrayList<String> list = 
				(ArrayList<String>) session.getAttribute("list"); // 기존 장바구니의 담아져 있는 정보를 먼저 가져온다.
		// 맨 처음에는 해당 페이지로 오면 session 에는 list 가 없다.
		if(list == null) {
			list = new ArrayList<String>(); // 만들어주고
			session.setAttribute("list", list); // 리스트에 담아라.
		}
		// 리스트에 정보를 추가
		list.add(fruits);
		
		return "view/session_cart/session_cart.jsp";
	}
}
