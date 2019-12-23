package book.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import book.vo.BookVO;

/**
 * DB관련 처리 클래스
 */
public class BookDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	public int insertBook(BookVO vo) {
		SqlSession openSession = factory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		int res = mapper.insertBook(vo);
		openSession.commit();
		openSession.close();
		return res;
	}

	public ArrayList<BookVO> listAll() {
		SqlSession openSession = factory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		ArrayList<BookVO> list = mapper.listAll();
		openSession.close();
		return list;
	}

	public BookVO getBook(int bnum) {
		SqlSession openSession = factory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		BookVO book = mapper.getBook(bnum);
		openSession.close();
		return book;
	}

	public int deleteBook(int bnum) {
		SqlSession openSession = factory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		int res = mapper.deleteBook(bnum);
		openSession.commit();
		openSession.close();
		return res;
	}

	public int updateBook(BookVO vo) {
		SqlSession openSession = factory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		int res = mapper.updateBook(vo);
		openSession.commit();
		openSession.close();

		return res;
	}

	public ArrayList<BookVO> searchBook(int choice, String text) {
		SqlSession openSession = factory.openSession();
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		HashMap<String, Object> map = new HashMap<>();
		map.put("choice", choice);
		map.put("text", text);
		ArrayList<BookVO> list = mapper.searchBook(map);
		openSession.close();
	
		return list;
	}

}
