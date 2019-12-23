package book.dao;

import java.util.ArrayList;
import java.util.HashMap;

import book.vo.BookVO;

/**
 * Mapper XML과 매핑되는 인터페이스
 */
public interface BookMapper {

	int insertBook(BookVO vo);

	ArrayList<BookVO> listAll();

	BookVO getBook(int bnum);

	int deleteBook(int bnum);

	int updateBook(BookVO vo);

	ArrayList<BookVO> searchBook(HashMap<String, Object> map);


}
