package dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Bridge;
import VO.Syoubinn;
import VO.Tyuumon;

public class dao2 {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public boolean buy(String id, int syoubinn_id, int stock) {
		SqlSession session = factory.openSession();
		Mapper2 mapper2 = session.getMapper(Mapper2.class);
		HashMap <String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("syoubinn_id", syoubinn_id);
		map.put("stock", stock);
		Syoubinn S = mapper2.searchSyo(syoubinn_id);
		mapper2.downStock(map);
		Tyuumon T = new Tyuumon(id, S.getName(), S.getSyuurui(), S.getPrice(), stock, S.getS_indate());
		mapper2.buy(T);
		mapper2.getBridge(syoubinn_id);
		session.commit();
		session.close();
		return true;
	}

	public ArrayList<Tyuumon> buyList(String id) {
		SqlSession session = null;
		ArrayList<Tyuumon> tyu = null;
		try {
			session = factory.openSession();
			Mapper2 mapper2 = session.getMapper(Mapper2.class);
			tyu = mapper2.buyList(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return tyu;
	}

	public boolean checkStock(int syoubinn_id, int stock) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		Mapper2 mapper2 = session.getMapper(Mapper2.class);
		HashMap <String, Integer> map = new HashMap<>();
		map.put("syoubinn_id", syoubinn_id);
		map.put("stock", stock);
		int res = mapper2.checkStock(map);
	
		if(res>=stock)
			return true;
		else
			return false;
	}

	public boolean buyCancel(String id, int tyuumon_id, int stock) {
		SqlSession session = null;
		Tyuumon tyu = null;
		Syoubinn syo = null;
		Bridge bri = null;
		int res = 0, res2 = 0, res3 = 0;
		try {
			session = factory.openSession();
			Mapper2 mapper2 = session.getMapper(Mapper2.class);
			tyu = new Tyuumon(tyuumon_id,id,stock);
			res = mapper2.buyCancel(tyu);
			Bridge B = mapper2.getBridge2(tyuumon_id);
			System.out.println(B);
			syo =  mapper2.selectSyo(B);
			System.out.println(syo);
			syo.setStock(syo.getStock()+stock);
			res2 = mapper2.upStock(syo);
			System.out.println(res2);
			//스톡이 0되면 주문정보삭제
//			if(tyu.getStock() == 0) {
//				res3 = mapper2.deleteTyu(no);
//				if(res3 > 0) System.out.println("주문정보가 삭제되었습니다.");
//			}
			session.commit();
		} 
		catch (Exception e) {System.out.println("주문번호와 수량을 재확인해주세요.");}
		finally {if(session != null) session.close();}
		return res > 0 && res2 > 0;
	}

	 public void updateUserPw(String id, String pw) {
	      SqlSession session = null;
	      try {
	         session = factory.openSession();
	         Mapper2 mapper2 = session.getMapper(Mapper2.class);
	         HashMap<String, String> map = new HashMap<>();
	         map.put("id", id);
	         map.put("pw", pw);
	         mapper2.updateUserPw(map);
	         session.commit();
	      } 
	      catch (Exception e) {System.out.println("비밀번호 변경 실패");} 
	      finally {if(session!=null) session.close();}
	   }


	   public void updateUserName(String id, String name) {
	      SqlSession session = null;
	      try {
	         session = factory.openSession();
	         Mapper2 mapper2 = session.getMapper(Mapper2.class);
	         HashMap<String, String> map = new HashMap<>();
	         map.put("id", id);
	         map.put("name", name);
	         mapper2.updateUserName(map);
	         session.commit();
	      } 
	      catch (Exception e) {System.out.println("이름 변경 실패");} 
	      finally {if(session!=null) session.close();}      
	   }


	   public void updateUserAddress(String id, String address) {
	      SqlSession session = null;
	      try {
	         session = factory.openSession();
	         Mapper2 mapper2 = session.getMapper(Mapper2.class);
	         HashMap<String, String> map = new HashMap<>();
	         map.put("id", id);
	         map.put("address", address);
	         mapper2.updateUserAddress(map);
	         session.commit();
	      } 
	      catch (Exception e) {System.out.println("주소 변경 실패");} 
	      finally {if(session!=null) session.close();}         
	   }


	   public void updateUserPhone(String id, String phone) {
	      SqlSession session = null;
	      try {
	         session = factory.openSession();
	         Mapper2 mapper2 = session.getMapper(Mapper2.class);
	         HashMap<String, String> map = new HashMap<>();
	         map.put("id", id);
	         map.put("phone", phone);
	         mapper2.updateUserPhone(map);
	         session.commit();
	      } 
	      catch (Exception e) {System.out.println("주소 변경 실패");} 
	      finally {if(session!=null) session.close();}         
	   }


	   public boolean deleteUser(String id) {
	      SqlSession session = null;
	      int res = 0;
	      try {
	         session = factory.openSession();
	         Mapper2 mapper2 = session.getMapper(Mapper2.class);
	         res = mapper2.deleteUser(id);
	         session.commit();
	      } 
	      catch (Exception e) {System.out.println("ID 삭제 실패");}
	      finally {if(session!=null) session.close();}
	      
	      return res > 0;
	   }
	
}