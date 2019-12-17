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
import VO.Tyuumon;

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
		Login L = null;

		if (C != null) {
			boolean check = pw.equals(C.getPw());
			if (check)
				L = new Login(C.getConsumer_id(), C.getPw(), C.getName(), C.getAddress(), C.getPhone(), 1);
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				L = new Login("0", "0", "0", "0", "0", 0);
			}
		} else if (P != null) {
			boolean check = pw.equals(P.getPw());
			if (check)
				L = new Login(P.getProducer_id(), P.getPw(), P.getName(), P.getAddress(), P.getPhone(), 2);
			else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				L = new Login("0", "0", "0", "0", "0", 0);
			}
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
			L = new Login("0", "0", "0", "0", "0", 0);
		}

		session.close();
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
		session.close();
	}

	public boolean enroll(Syoubinn s) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		boolean res = mapper.enroll(s);
		session.commit();
		session.close();
		return res;
	}

	public ArrayList<Syoubinn> selling() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		ArrayList<Syoubinn> list = mapper.selling();

		return list;
	}

	public ArrayList<Tyuumon> selled() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		ArrayList<Tyuumon> list = mapper.selled();
		
		return list;
	}

	public boolean addStock(int syoubinn_id, int stock) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("syoubinn_id", syoubinn_id);
		map.put("stock", stock);
		int res = mapper.addStock(map);
		session.commit();
		session.close();
		return res > 0;
	}

	public int checkSyoubinn(String id, int syoubinn_id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		Syoubinn S = mapper.checkShoubinn(syoubinn_id);
		session.close();
		if (S == null)
			return 0;
		else {

			if (S.getProducer_id().equals(id)) {
				return 2;
			} else {
				return 1;
			}
		}

	}

	public void changePrice(int syoubinn_id, int price) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("syoubinn_id", syoubinn_id);
		map.put("price", price);
		mapper.changePrice(map);
		session.commit();
		session.close();
	}

	public void updateProPw(String id, String pw) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		mapper.updateProPw(map);
		session.commit();
		session.close();
		
	}

	public void updateProName(String id, String name) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("name", name);
		mapper.updateProName(map);
		session.commit();
		session.close();
			
	}

	public void updateProAddress(String id, String address) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("address", address);
		mapper.updateProAddress(map);
		session.commit();
		session.close();
	}

	public void updateProPhone(String id, String phone) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("address", phone);
		mapper.updateProPhone(map);
		session.commit();
		session.close();
			
	}

	public boolean deleteProducer(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		int res = mapper.deleteProducer(id);
		session.commit();
		session.close();
		
		return res>0;
	}

	public ArrayList<Syoubinn> sellingPro(String id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		ArrayList<Syoubinn> list=mapper.sellingPro(id);
		session.close();
		return list;
	}

	public ArrayList<Tyuumon> selledPro(String id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		ArrayList<Tyuumon> list=mapper.selledPro(id);
		
		
		session.close();
		return list;
	}

	public void deleteSyoubinn(int syoubinn_id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper mapper = session.getMapper(Mapper.class);
		mapper.deleteSyoubinn(syoubinn_id);
		session.commit();
		session.close();
	}



}
