package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Dao.Dao;
import VO.Login;
import VO.Movie;

public class UI {

	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	private String name;
	private String id;
	Dao dao = new Dao();
	private Movie M;
	private Login L;
	private int Movie_num;
	private String Movie_name;
	private int seki;
	private int price;
	private String Producer_id;
	private String Producer_name;
	private boolean condition;

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
		L = dao.logIn(id);
		if (L == null) {
			System.out.println("ID가 존재하지 않습니다.");
			return;
		}
		if (L.getType() == 1) {
			condition = true;
			while (condition) {
				ProducerMenu();
			}
		}
		if (L.getType() == 2) {
			condition = true;
			while (condition) {
				ConsumerMenu();
			}
		}
	}

	private void ConsumerMenu() {
		try {
			// TODO Auto-generated method stub
			System.out.println("----------------------------------------------------");
			System.out.println("1. 영화표 구매");
			System.out.println("2. 내가 본 영화");
			System.out.println("3. 리플달기"); // 대댓글도
			System.out.println("0. 로그아웃");
			System.out.println("----------------------------------------------------");
			switch (sc.nextInt()) {
			case 1:
				koubai();
				break;
			case 2:

				break;
			case 0:
				condition = false;
			default:
				System.out.println("올바른 숫자를 입력하세요");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 입력하세요");
		}

	}

	private void koubai() {
		// TODO Auto-generated method stub
		ArrayList<Movie> list = dao.eigaList();
		for(Movie i : list)
			System.out.println(i);
		System.out.print("구매할 영화 번호 : ");
		Movie_num=sc.nextInt();
	}

	private void ProducerMenu() {
		try {
			// TODO Auto-generated method stub
			System.out.println("----------------------------------------------------");
			System.out.println("1. 영화촬영");
			System.out.println("2. 내가 촬영한 영화"); // 총 수입
			System.out.println("3. 리플달기"); // 대댓글로
			System.out.println("4. 영화 내리기");
			System.out.println("9. 은퇴하기");
			System.out.println("0. 로그아웃");
			System.out.println("----------------------------------------------------");
			switch (sc.nextInt()) {
			case 1:
				satuee();
				break;
			case 2:
				eigaListPro();
				break;
			case 0:
				condition = false;
			default:
				System.out.println("올바른 숫자를 입력하세요");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("숫자만 입력하세요");
		}

	}

	private void eigaListPro() {
		// TODO Auto-generated method stub
		ArrayList<Movie> list = dao.eigaListPro(L.getId());
		for (Movie i : list)
			System.out.println(i);

	}

	private void satuee() {
		// TODO Auto-generated method stub
		System.out.print("이름 : ");
		Movie_name = st.nextLine();
		System.out.print("좌석 :               ##미입력시 5석 생성");
		seki = sc.next();
		System.out.print("가격 : ");
		price = sc.nextInt();
		M = new Movie(Movie_name, seki, price, L.getId(), L.getName());
		dao.satuee(M);

	}
}
