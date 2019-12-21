package UI;

import java.util.Scanner;

import Dao.Dao;
import VO.Login;

public class UI {

	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	private String name;
	private String id;
	Dao dao = new Dao();
	private int Movie_num;
	private String Movie_name;
	private int seki;
	private int price;
	private String Producer_id;
	private String Producer_name;
	
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
		System.out.println("3. 전체 회원조회");
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
		Login L = dao.logIn(id);
		if (L == null) {
			System.out.println("ID가 존재하지 않습니다.");
			return;
		}
		if (L.getType() == 1)
			ProducerMenu();
		if (L.getType() == 2)
			ConsumerMenu();
	}

	private void ConsumerMenu() {
		// TODO Auto-generated method stub

	}

	private void ProducerMenu() {
		try {
			// TODO Auto-generated method stub
			System.out.println("----------------------------------------------------");
			System.out.println("1. 영화촬영");
			System.out.println("2. 내가 촬영한 영화");
			System.out.println("----------------------------------------------------");
			switch (sc.nextInt()) {
			case 1:
				satuee();
				break;
			case 2:
				
				break;
			
			default:
				System.out.println("올바른 숫자를 입력하세요");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 입력하세요");
			ProducerMenu();
		}
		
		
	}

	private void satuee() {
		// TODO Auto-generated method stub
		System.out.print("이름 : ");
		Movie_name = st.nextLine();
		System.out.print("좌석 :               ##미입력시 5석 생성");
		seki = sc.nextInt();
		System.out.print("가격 : ");
		price = sc.nextInt();
		dao.satuee(Movie_name, seki, price);
		
	}
}
