

import java.sql.SQLException;
import java.util.List;

import board.BoardVO;
import board.impl.BoardDAO;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
//		vo.setTitle("myBaits 제목 0522");
//		vo.setWriter("홍길동0522");
//		vo.setContent("myBatis0522 내용입니다.....");
//		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("writer");
		vo.setSearchKeyword("홍길자");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println(board.toString());
		}
		


	}
}
