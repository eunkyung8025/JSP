package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addMember")
public class AddMemberServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//사용자가 값 입력 user_name=user2 & user_pass=1234 & role=1
		String name= req.getParameter("user_name"); 
		String pass=req.getParameter("user_pass");
		String role=req.getParameter("role");
		
		//get:수정 post:입력
		//DB에 입력하는 기능		
		EmpDAO dao= new EmpDAO();
		boolean isTrue=false;
		if(req.getMethod().toUpperCase().equals("GET")) {
			isTrue= dao.upadateMember(name, pass, role); 

		} else {
			dao.insertMember(name, pass, role);
		}
		if(isTrue)	
		resp.getWriter().print("Completed.");
		else	
		resp.getWriter().print("Failed.");
		
	}
	

}
