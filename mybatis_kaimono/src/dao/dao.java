package dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class dao {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

}
