package Dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Board;
import VO.Reply;

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
		session.commit();
		session.close(); 
		if (res == 1) {
			return true;
		}

		
		return false;
	}

	public ArrayList<Board> listBoard() {
		ArrayList<Board> list;
		SqlSession session = null;

		session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		list = mapper.listBoard();
		session.close();
		return list;

	}

	public Board readBoard(int num) {
		SqlSession session = factory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.addHits(num);
		Board board = mapper.readBoard(num);
		session.commit();
		session.close();
		return board;
	}

	public ArrayList<Reply> listReply(int num) {
		SqlSession session = factory.openSession();
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		ArrayList<Reply> list = mapper.listReply(num);
		session.close();
		return list;
	}

}
