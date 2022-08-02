package co.edu.service;

import java.util.List;

import co.edu.dao.BoardDAO;
import co.edu.vo.BoardVO;
import co.edu.vo.Criteria;

public class BoardService {
	
	private static BoardService instance=new BoardService();
	BoardDAO dao=new BoardDAO();
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		return instance;
	}
	
	//게시글 등록
	
	public void addBoard(BoardVO vo) {
		dao.addBoard(vo);
	}
	
	//게시글 목록
	public List<BoardVO> boardList() {
		return dao.getList();
	}
	
	//페이징
	public List<BoardVO> getListPaging(Criteria cri) {
		return dao.getListPaging(cri); //10건씩
	}
	

}
