package co.dev.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.dev.common.SqlMapSessionFactory;
import co.dev.vo.MemberVO;

public class MemberDAOMybatis {
	
	//sqlSessionFactor 가져오도록
	
	SqlSessionFactory sessionFactory;
	
	//생성자
	private static MemberDAOMybatis instance = new MemberDAOMybatis();

	private MemberDAOMybatis() {
		sessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}
	
	public static MemberDAOMybatis getInstance() {
		return instance;
	}
	
	//전체 리스트 가져오는 것
	public List <MemberVO> getList() {
		
		SqlSession session= sessionFactory.openSession();
		//memberMapper.xml 파일에 적어둔 아이디값으로 sql문을 가져올 수 있음
		//매퍼의 namespace(co.dev.mybatisdb.memberMapper)+"id(.getMemberList)"
		List<MemberVO>list =session.selectList("co.dev.mybatisdb.memberMapper.getMemberList"); 
		session.close();
		return list;
	}
	
	//한건 조회
	public MemberVO searchMember(String id) {
		SqlSession session= sessionFactory.openSession();
		MemberVO member = session.selectOne("co.dev.mybatisdb.memberMapper.getMember",id);
		session.close();
		return member;
		
	}
	
	//입력
	public void insertMember(MemberVO vo) {
		SqlSession session = sessionFactory.openSession(true);
		session.insert("co.dev.mybatisdb.memberMapper.insertMember",vo);
		session.close();
	}
	
	//수정
	public void updateMember (MemberVO vo) {
		SqlSession session = sessionFactory.openSession(true);
		session.update("co.dev.mybatisdb.memberMapper.updateMember",vo);
		session.close();
	}
	
	//삭제
	public boolean deleteMember (String id) {
		SqlSession session = sessionFactory.openSession(true); //openSession(false);
		int r = session.delete("co.dev.mybatisdb.memberMapper.deleteMember",id);
		session.close();
		if (r>0) {
			return true;
		} else { 
			return false;
		}
		//session.commit();
	}
	
}
