package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Consumer;
import VO.Login;
import VO.Movie;
import VO.Producer;

public class Dao {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	private Consumer C;
	private Producer P;
	private int num=0;
	private Login L;
	private Movie M;
	

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

	public void satuee(Movie m) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		
		mapper.satuee(m);
		openSession.commit();
		openSession.close();
	}


	public ArrayList<Movie> eigaListPro(String id) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		ArrayList<Movie> M = mapper.eigaListPro(id);
		openSession.close();
		return M;
	}

	public ArrayList<Movie> eigaList() {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		ArrayList<Movie> M = mapper.eigaList();
		openSession.close();
		return M;
	}


	public int koubai(int movie_num, int seki) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		M = mapper.selectEiga(movie_num);
		System.out.println(M);
		if(M==null)
			return 0;
		if(M.getSeki()<seki)
			return 1;
		if(M.getPrice()*seki>L.getProperty())
			return 2;
	
		L.setProperty(L.getProperty()-M.getPrice()*seki);
		C = new Consumer(L.getId(), L.getName(), L.getProperty());
		System.out.println(C);
		mapper.updateCon(C);
		System.out.println(1);
		M.setSeki(M.getSeki()-seki);
		System.out.println(M);
		mapper.updateMovie(M);
		System.out.println(2);
		HashMap <String, Object> map = new HashMap<>();
		map.put("Movie_num", movie_num);
		map.put("Consumer_id", L.getId());
		mapper.insertBridge(map);
		openSession.commit();
		openSession.close();
		return 3;
	}


	public ArrayList<Movie> eigaListCon(String id) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		ArrayList<Movie> M = mapper.eigaListCon(id);
		openSession.close();
		return M;
	}
	
	
	
	
	
}
