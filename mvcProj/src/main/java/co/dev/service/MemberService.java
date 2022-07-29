package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

//업무처리를 해주는 비지니스 영역
public class MemberService {

	//싱글톤 방식으로
	private static MemberService instance=new MemberService();
	MemberDAO dao = new MemberDAO();
	private MemberService() {}
	public static MemberService getInstance() {
		return instance;
	}
	
	//회원가입
	public void addMember(MemberVO vo) {
		dao.insertMember(vo);
	}
	//회원목록을 가져오는 기능
	public List<MemberVO> memberList() {
		//getList의 결과값을 반환
		return dao.getList();
	}
	//회원조회
	public MemberVO getMember(String id) {
		return dao.searchMember(id);
	}
	//회원정보 수정
	public void modifyMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	//회원정보 삭제
	public boolean deleteMember(String id) {
		
		return dao.deleteMember(id);
	}
}
