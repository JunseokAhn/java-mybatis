package dao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Consumer;
import VO.Login;
import VO.Producer;
import VO.Syoubinn;

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

	public Login login(String id, String pw) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		Consumer C = mapper.checkID1(id);
		Producer P = mapper.checkID2(id);
		Login L=null;
	
		if(C!=null) {
			boolean check =pw.equals(C.getPw());
			if(check)
				L = new Login(C.getConsumer_id(), C.getPw(), C.getName(), C.getAddress(), C.getPhone(), 1);
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				L = new Login("0", "0", "0", "0", "0", 0);
			}
		}else if(P!=null){
			boolean check =pw.equals(P.getPw());
			if(check)
				L = new Login(P.getProducer_id(), P.getPw(), P.getName(), P.getAddress(), P.getPhone(), 2);
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				L = new Login("0", "0", "0", "0", "0", 0);
			}
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
			L = new Login("0", "0", "0", "0", "0", 0);
		}


		return L;
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

	public boolean enroll(Syoubinn s) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		boolean res = mapper.enroll(s);
		
		
		return res;
	}

}
