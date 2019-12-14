package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Consumer;
import VO.Producer;

public class dao {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public String checkID(String id, int type) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		String res = mapper.checkID(id);
		session.close();
		return res;
	}

	public boolean insertCon(Consumer c) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		int res = mapper.insertCon(c);
		session.commit();
		session.close();
		return res > 0;
	}

	public boolean insertPro(Producer p) {
		// TODO Auto-generated method stub

		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		int res = mapper.insertPro(p);
		session.commit();
		session.close();
		return res > 0;
	}

	public int login(String id, String pw) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		String str = mapper.checkID1(id);
		int type=1;
		System.out.println(1);
		if (str==null) {
			System.out.println(2);
			str = mapper.checkID2(id);
			type=2;
			if (str==null) {
				System.out.println("아이디가 존재하지 않습니다.");
				return type=0;
			}
		}
		if(pw.equals(str)) {
			return type;
		}
		System.out.println("비밀번호가 일치하지 않습니다.");
		return type=0;
	}
	
	public void list() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		ArrayList<Consumer> list = mapper.consumer_list();
		ArrayList<Producer> list2 = mapper.producer_list();
		for (Consumer i : list)
			System.out.println(i);
		for (Producer i : list2)
			System.out.println(i);
	}

}
