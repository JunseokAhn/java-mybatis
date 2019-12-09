package Dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Board;

public class BoardDao {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public boolean insertBoard(Board Board) {
		System.out.println(4);
		SqlSession session = factory.openSession();
		System.out.println(5);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		System.out.println(6);
		int res = mapper.insertBoard(Board);
		System.out.println(7);
		if (res == 1) {
			session.commit();
			session.close();
			return true;
		}
	
		session.close();
		return false;
	}

	public ArrayList<Board> listBoard() {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<Board> list =mapper.listBoard();
		session.close();
		return list;
	}
}
