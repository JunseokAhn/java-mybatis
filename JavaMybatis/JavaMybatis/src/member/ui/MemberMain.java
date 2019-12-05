package member.ui;

import java.util.ArrayList;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberMain {
	
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		
		Member member = new Member();
		member.setMember_name("김철수");
		member.setMember_age(20);
		member.setMember_phone("010-1111-2222");
		member.setMember_address("서울특별시 강남구");
		
		dao.insertMember(member);
		
		ArrayList<Member> list = dao.selectMember();
		
		for( Member m : list ) {
			System.out.println(m);
		}
		
	}
	
	
}
