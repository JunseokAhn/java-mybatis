package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Board;

public class BoardDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean insertBoard(Board board) {
		int res = 0;
		try {
			SqlSession session = factory.openSession();
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			res = mapper.insertBoard(board);
			
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (res == 1)
			return true;
		
		return false;
	}
	
	public ArrayList<Board> listBoard() {
		ArrayList<Board> list = null;
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			list = mapper.listBoard();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		return list;
	}
}






