package calendar.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import calendar.vo.MyCalendar;

public class MyCalendarDAO {

	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public boolean insert(MyCalendar m) {
		SqlSession session = null;
		MyCalendarMapper mapper = null;

		int res = 0;
		try {
			session = factory.openSession();
			mapper = session.getMapper(MyCalendarMapper.class);
			res = mapper.insert(m);
			session.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res > 0;
	}

	public ArrayList<MyCalendar> list() {
		// TODO Auto-generated method stub
		SqlSession session = null;
		MyCalendarMapper mapper = null;
		ArrayList<MyCalendar> list = null;

		try {
			session = factory.openSession();
			mapper = session.getMapper(MyCalendarMapper.class);
			list = mapper.list();
			session.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public MyCalendar read(int n) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		MyCalendarMapper mapper = null;
		MyCalendar list = null;
		try {
			session = factory.openSession();
			mapper = session.getMapper(MyCalendarMapper.class);
			list = mapper.read(n);
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean delete(int n) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		MyCalendarMapper mapper = null;
		int res = 0;
		try {
			session = factory.openSession();
			mapper = session.getMapper(MyCalendarMapper.class);
			res = mapper.delete(n);
			session.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res > 0;
	}

	public MyCalendar search(int col, String word) {
		// TODO Auto-generated method stub
		MyCalendar res = null;
		SqlSession session = null;
		MyCalendarMapper mapper = null;
		try {
			session = factory.openSession();
			mapper = session.getMapper(MyCalendarMapper.class);
			HashMap<String, Object> map = new HashMap<>();
			map.put("col", col);
			map.put("word", word);
			res = mapper.search(map);
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public boolean update(int calendar_no, String calendar_title, String calendar_content) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		MyCalendarMapper mapper = null;
		int res = 0;
		try {
			session = factory.openSession();
			mapper = session.getMapper(MyCalendarMapper.class);
			HashMap <String, Object> map = new HashMap<>();
			map.put("calendar_no", calendar_no);
			map.put("calendar_title",calendar_title);
			map.put("calendar_content",calendar_content);
			
			res = mapper.update(map);
			session.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res>0;
	}

}
