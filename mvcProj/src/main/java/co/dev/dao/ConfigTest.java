package co.dev.dao;

import java.util.List;

import co.dev.vo.MemberVO;

public class ConfigTest {
	
	public static void main(String[] args) {
		MemberDAOMybatis dao = MemberDAOMybatis.getInstance();
		
		//전체조회
//		List<MemberVO>list = dao.getList();
//		
//		for (MemberVO member : list) {
//			System.out.println(member.toString());
//			//run as > java application
//		}
		
		//단건조회
//		MemberVO vo = dao.searchMember("user1");
//		System.out.println(vo.toString());
		
		//삭제
		dao.deleteMember("user1");
		List<MemberVO>list = dao.getList();
		
		for (MemberVO member : list) {
		System.out.println(member.toString());
		
		}
		
	}

}
