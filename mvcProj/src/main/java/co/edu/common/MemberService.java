package co.edu.common;

public class MemberService {

	//싱글턴 방식
	//이 필드는 생성자로 초기값을 가지도록,,?이런 모양은 또 처음보네..
	private static MemberService instance = new MemberService();
	
	//외부에서 접근 못하도록 private로 생성자 생성
	private MemberService () {}
	
	public static MemberService getInstance() {
		return instance;
	}

	MemberDAO dao = new MemberDAO();
	// 입력기능 -> MemberDAO에서 구현
	public void memberAdd(MemberVO vo) {
		dao.insertMember(vo);

	}
	

}
