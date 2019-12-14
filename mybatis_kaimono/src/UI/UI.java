package UI;

import java.util.Scanner;

import VO.Consumer;
import VO.Producer;
import dao.dao;

public class UI {
	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	dao dao = new dao();

	private int type;
	private int choice;
	private String id;
	private String pw;
	private String name;
	private String address; // nullable
	private String phone; // nullable

	public UI() {
		// TODO Auto-generated constructor stub
		while (true) {
			menu();
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1.로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 전체 이용자 조회");
		switch (sc.nextInt()) {
		case 1:
			login();
			break;
		case 2:
			signUp();
			break;
		case 3:
			list();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}

	}

	private void list() {
		// TODO Auto-generated method stub
		dao.list();
	}

	private void login() {
		// TODO Auto-generated method stub
		System.out.print("아이디를 입력하세요 : ");
		id = st.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		pw = st.nextLine(); // 아이디, 중복검사 > 없으면 없는 아이디입니다. 비밀번호안맞으면 비밀번호x
		type = dao.login(id, pw);// type을 반환받아서 생산자인지 소비자인지 구분
		if (type == 0)
			System.out.println("로그인 실패");
		else {
			System.out.println("로그인 성공");

			if (type == 1)
				consumerMenu();
			if (type == 2)
				producerMenu();
		}
	}

	private void consumerMenu() {
		// TODO Auto-generated method stub
		System.out.println("===========소비자 메뉴===========");

		System.out.println("============================");
	}

	private void producerMenu() {
		// TODO Auto-generated method stub
		System.out.println("===========생산자 메뉴===========");

		System.out.println("============================");
	}

	private void signUp() {
		// TODO Auto-generated method stub
		System.out.println("1. 소비자 회원가입");
		System.out.println("2. 생산자 회원가입");
		type = sc.nextInt();
		if (type != 1 && type != 2) {
			System.out.println("올바르지 않은 입력");
			signUp();
		}
		System.out.print("#필수# 아이디를 입력하세요 : "); // 필수값이 입력되지않으면 catch재입력
		id = st.nextLine();
		String str = dao.checkID(id, type);// id 중복검사
		if (str != null) {
			System.out.println("이미 존재하는 아이디입니다.");
			signUp();
		}
		System.out.print("#필수# 비밀번호를 입력하세요 : ");
		pw = st.nextLine();
		System.out.print("#필수# 이름을 입력하세요 : ");
		name = st.nextLine();
		System.out.print("#선택# 주소를 입력하세요 : ");
		address = st.nextLine();
		System.out.print("#선택# 전화번호를 입력하세요 : ");
		phone = st.nextLine();

		try {
			if (type == 1) {
				Consumer C = new Consumer(id, pw, name, address, phone);
				boolean res = dao.insertCon(C);
				if (res)
					System.out.println("등록 완료");
				else
					System.out.println("등록 실패");
			}
			if (type == 2) {
				Producer P = new Producer(id, pw, name, address, phone);
				boolean res = dao.insertPro(P);
				if (res)
					System.out.println("등록 완료");
				else
					System.out.println("등록 실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("필수 값을 입력해주세요");
			signUp();
		}
	}
}