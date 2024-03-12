package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartView {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 장바구니 보여주기
		// 세션에 다 넣었기 때문에 할일은 없다.
		// 클라이언트에게 보여주기 때문
		
		return "view/session_cart/session_cart_view.jsp";
	
	}
}
