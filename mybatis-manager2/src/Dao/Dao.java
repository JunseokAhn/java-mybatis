package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Consumer;
import VO.Login;
import VO.Producer;

public class Dao {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	private Consumer C;
	private Producer P;
	private int num=0;
	private Login L;
	

	public int checkId(String id, String name) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		
		P = mapper.checkPro(id);
		C = mapper.checkCon(id);
		openSession.close();
		if(P==null||C==null)
			return 0;
		if(C!=null) {
			return 2;
		}
		if(P!=null) {
			return 1;
		}
		return 0;
	}


	public void signUp_producer(String id, String name) {
		// TODO Auto-generated method stub
		
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		HashMap <String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		mapper.signUp_producer(map);
		openSession.commit();
		openSession.close();
	}


	public void signUp_Consumer(String id, String name) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		HashMap <String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		mapper.signUp_consumer(map);
		openSession.commit();
		openSession.close();
	}


	public void list() {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		ArrayList<Producer> P = mapper.listPro();
		ArrayList<Consumer>C = mapper.listCon();
		for(Producer i : P)
			System.out.println(i);
		for(Consumer i : C)
			System.out.println(i);
	}


	public Login logIn(String id) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		C = mapper.checkCon(id);
		P = mapper.checkPro(id);
		if(C==null||P==null)
			L=null;
		if(P!=null)
			L=new Login(P.getProducer_id(), P.getProducer_name(), P.getProperty(), 1);
		if(C!=null)
			L=new Login(C.getConsumer_id(), C.getConsumer_name(), C.getProperty(), 2);
		return L;
	}


	public void satuee(String movie_name, int seki, int price) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	
}
