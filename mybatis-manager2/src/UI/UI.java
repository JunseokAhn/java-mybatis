package UI;

import java.util.Scanner;

import Dao.Dao;

public class UI {

	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	private String name;
	private String id;
	Dao dao = new Dao();

	public UI() {
		// TODO Auto-generated constructor stub

		try {
			while (true) {
				menu();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 입력");
			e.printStackTrace();
			st.nextLine();
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("=============================");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("=============================");

		switch (sc.nextInt()) {
		case 1:
			logIn();
			break;
		case 2:
			signUp();
			break;
		case 3:
			dao.list();
			break;
		default:
			System.out.println("올바르지 않은 입력");
			break;
		}
	}

	private void signUp() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------------------------------");
		System.out.println("1. 영화감독 회원가입");
		System.out.println("2. 관객 회원가입");
		System.out.println("----------------------------------------------------");
		switch (sc.nextInt()) {
		case 1:
			signUp_producer();
			break;
		case 2:
			signUp_consumer();
			break;
		default:
			System.out.println("올바르지 않은 입력");
			signUp();
			break;

		}
	}

	private void signUp_consumer() {
		// TODO Auto-generated method stub
		System.out.print("ID를 입력해주세요 : ");
		id = st.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		name = st.nextLine();
		int checkId = dao.checkId(id, name);
		if (checkId != 0) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		dao.signUp_Consumer(id, name);
		System.out.println("장려금 5만원을 드립니다!!");
	}

	private void signUp_producer() {
		// TODO Auto-generated method stub
		System.out.print("ID를 입력해주세요 : ");
		id = st.nextLine();
		System.out.print("이름을 입력해주세요 : ");
		name = st.nextLine();
		int checkId = dao.checkId(id, name);
		if (checkId != 0) {
			System.out.println("이미 존재하는 아이디입니다.");
			return;
		}
		dao.signUp_producer(id, name);
		System.out.println("장려금 10만원을 드립니다!!");

	}

	private void logIn() {
		// TODO Auto-generated method stub
		System.out.print("ID를 입력해주세요 : ");
		id = st.nextLine();
		
		
		
	}
}
