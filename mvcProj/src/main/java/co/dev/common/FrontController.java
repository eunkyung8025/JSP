package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;


public class FrontController extends HttpServlet {
	
	String enc;
	//요청할 컨트롤을 담아놓고,,?
	Map<String, Controller> mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		
		mappings=new HashMap<>();
        //"/memberInsert.do"라는 요청이 들어오면 (구현객체) 기능을 실행
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberSearch.do", new MemberSearchController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		String uri=req.getRequestURI(); //
		//System.out.println(uri);
		String contextPath=req.getContextPath();
		//System.out.println(contextPath);
		String path= uri.substring(contextPath.length());
		System.out.println(path);
		
		Controller cntrl=mappings.get(path);//키 값의 벨류를 가져옴
		cntrl.execute(req, resp);
			
		
		//입력해주는 페이지 -> 뷰페이지 
		
//		MemberService service=MemberService.getInstance();
//		//파라메터값들을 읽어줌
//		if(path.equals("/memberInsert.do")) {
//			
//		String id = req.getParameter("id");
//		String pw=req.getParameter("passwd");
//		String nm=req.getParameter("name");
//		String ml=req.getParameter("mail");
//		
//		MemberVO vo = new MemberVO();
//		
//		vo.setId(id);
//		vo.setName(nm);
//		vo.setPasswd(pw);
//		vo.setMail(ml);
//		
//		service.addMember(vo);
//		
//		//요청 처리결과 뷰페이지 전송
//		req.setAttribute("member", vo);
//		RequestDispatcher rd=req.getRequestDispatcher("memberResult/memberInsertOutput.jsp");
//		rd.forward(req, resp);
//		
//		
//		} else if(path.equals("/memberList.do")) {
//			req.setAttribute("list", service.memberList());
//			RequestDispatcher rd=req.getRequestDispatcher("memberResult/memberListOutput.jsp");
//			rd.forward(req, resp);
//	}

}
}
