package Dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Dao {
	SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	public int checkId(String id, String name) {
		// TODO Auto-generated method stub
		SqlSession openSession = factory.openSession();
		Mapper mapper = openSession.getMapper(Mapper.class);
		int res = mapper.checkId();
		
		return 0;
	}
	
	
	
	
}
