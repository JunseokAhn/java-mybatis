package member.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.vo.Member;

/**
 * Mybatis를 사용하여 Java로 DB를 접근
 * */

public class MemberDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//회원 등록
	public void insertMember(Member member) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.insertMember(member);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//회원 조회
	public ArrayList<Member> selectMember(){
		SqlSession session = null;
		ArrayList<Member> list = null;
		
		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.selectMember();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return list;
	}
	
}
