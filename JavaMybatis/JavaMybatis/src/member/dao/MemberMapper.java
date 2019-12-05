package member.dao;

import java.util.ArrayList;

import member.vo.Member;

public interface MemberMapper {
	
	//회원 등록
	public int insertMember(Member member);
	//회원 조회
	public ArrayList<Member> selectMember();
}
