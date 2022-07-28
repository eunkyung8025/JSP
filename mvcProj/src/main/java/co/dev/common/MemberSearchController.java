package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String job = req.getParameter("job");

		if (id.isEmpty()) {
			req.setAttribute("error", "id를 입력하세요.");
			if (job.equals("search")) {
				Utils.forward(req, resp, "memberView/memberSearch.jsp");
			} else if (job.equals("update")) {
				Utils.forward(req, resp, "memberView/memberUpdate.jsp");
			} else if (job.equals("delete")) {
				Utils.forward(req, resp, "memberView/memberDelete.jsp");
			}
			return; // 리턴구문을 만나면 메소드는 중단됨
		}

		MemberService service = MemberService.getInstance();

		//멤버라는 속성을 가져와 아래값이 있으면 연결되게..
		req.setAttribute("member", service.getMember(id));
		
		MemberVO vo=service.getMember(id);
		if (vo==null) {
			req.setAttribute("result", "검색된 정보가 없습니다.");
		}
		
		if (job.equals("search")) {
			Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		} else if (job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
		} else if(job.equals("delete")) {
			Utils.forward(req, resp, "memberView/memberDelete.jsp");
		}
 
//		utils.forward메소드 만들어 활용하기
//		try {
//			req.getRequestDispatcher("memberResult/memberSearchOutput.jsp").forward(req, resp);			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
