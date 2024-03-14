package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.GuestBook2DAO;
import com.ict.db.guestbook2.GuestBook2VO;
import com.ict.model.basic.Command;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 실제 저장 위치 먼저 받기
			String path = request.getServletContext().getRealPath("upload");
			
			// 파일 업로드에 올라가짐
			MultipartRequest mr = 
					new MultipartRequest(request, path, 
							500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			GuestBook2VO g2vo = new GuestBook2VO();
			g2vo.setName(mr.getParameter("name"));
			g2vo.setSubject(mr.getParameter("subject"));
			g2vo.setContent(mr.getParameter("content"));
			g2vo.setEmail(mr.getParameter("email"));
			g2vo.setPwd(mr.getParameter("pwd"));
			
			// 첨부파일이 있을 때와 없을 때를 구분하자.
			if(mr.getFile("f_name") != null) {
				g2vo.setF_name(mr.getFilesystemName("f_name"));
			}else {
				g2vo.setF_name(""); // 없을때 ""을 넣어줌
			}
			int result = GuestBook2DAO.getInsert(g2vo);
			if(result > 0) { // 0 보다 크면 성공
				return "GuestBook2Controller?cmd=list";
				
			} 
			return "view/guestbook2/error.jsp";
			
		} catch (Exception e) {
			System.out.println(e);
			return "view/guestbook2/error.jsp";
		}
		
		
	}
}
