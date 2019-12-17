package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import VO.Bridge;
import VO.Syoubinn;
import VO.Tyuumon;

public class dao2 {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public boolean buy(String id, int syoubinn_id, int stock) {
		SqlSession session = null;
		int res = 0, res2 = 0, res3 = 0;
		try {
			session = factory.openSession();
			Mapper2 mapper2 = session.getMapper(Mapper2.class);
			Syoubinn syo = mapper2.searchSyo(syoubinn_id);
			Tyuumon tyu = new Tyuumon(id, syo.getName(), syo.getSyuurui(), syo.getPrice(), stock, syo.getS_indate());
			
			res = mapper2.buy(tyu);
			res2 = mapper2.downStock(syo);
			
			Bridge bri = new Bridge(tyu.getTyuumon_id(), syo.getSyoubinn_id());
			res3 = mapper2.getBridge(bri);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return (res > 0 && res2 > 0 && res3 > 0);
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

}