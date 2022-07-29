package co.dev.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class AddMemberAjaxController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		resp.setContentType("text/json;charset=utf-8");
		
		//회원정보등록 -> json값 반환
		
		MemberService service = MemberService.getInstance();

		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String nm = req.getParameter("name");
		String ml = req.getParameter("mail");

		MemberVO vo = new MemberVO();

		vo.setId(id);
		vo.setName(nm);
		vo.setPasswd(pw);
		vo.setMail(ml);

		service.addMember(vo);

		// json반환.
		Gson gson=new GsonBuilder().create();
		try {
			resp.getWriter().print(gson.toJson(vo)); //id, name, passwd, mail
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
