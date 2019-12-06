package member.dao;

import java.util.ArrayList;

import member.vo.Member;

public interface MemberMapper {
	
	//회원 등록 - insert delete update = 실행이 성공해도 따로 출력되는게 없어서 반환형이 무조건 int다/ void도 되네
	public int insertMember(Member member);
	//회원 조회 - select는 결과가 나오니까 반환형이 있음
	public ArrayList<Member> selectMember();
}
