package UI;

import java.util.ArrayList;
import java.util.Scanner;

import VO.Consumer;
import VO.Login;
import VO.Producer;
import VO.Syoubinn;
import VO.Tyuumon;
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

	private int syoubinn_id;
	private String syuurui;
	private int price;
	private String producer_id;
	private int stock;
	Login L;

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

		L = dao.login(id, pw);// type을 반환받아서 생산자인지 소비자인지 구분

		type = L.getType();

		if (type == 0)
			System.out.println("로그인 실패");
		else {
			System.out.println("로그인 성공");

			if (type == 1)
				while (type == 1) {
					consumerMenu();
				}
			if (type == 2)
				while (type == 2) {
					producerMenu();
				}
		}
	}

	private void consumerMenu() {
		// TODO Auto-generated method stub
		// bridge +1

		System.out.println("===========소비자 메뉴===========");
		System.out.println("1. 구매");
		System.out.println("2. 구매한 목록 리스트"); // 총 소비금액
		System.out.println("0. 로그아웃");
		System.out.println("============================");
		switch (sc.nextInt()) {
		case 1:
			buy();
			break;
		case 2:

			break;
		case 0:
			menu();
			break;
		
		default:
			System.out.println("올바르지 않은 입력");
		}

	}

	private void buy() {
		// TODO Auto-generated method stub
		selling();
		System.out.println("상품id를 입력하세요");
		boolean res = false;
		if (res)
			System.out.println("구매 성공");
		else
			System.out.println("구매 실패");

	}

	private void producerMenu() {
		// TODO Auto-generated method stub
		System.out.println("===========생산자 메뉴===========");
		System.out.println("1. 상품등록");
		System.out.println("2. 판매중 목록 리스트");
		System.out.println("3. 판매된 목록 리스트"); // 팔린 총 금액
		System.out.println("4. 판매정보 수정");
		System.out.println("5. 회원정보 수정");
		System.out.println("9. 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.println("============================");
		switch (sc.nextInt()) {
		case 1:
			enroll();
			break;
		case 2:
			selling();
			break;
		case 3:
			selled();
			break;
		case 4:
			updateSyoubinn();
			break;
		case 5:
			updateProducer();
			break;
		case 9:
			
			break;
		case 0:
			menu();
			break;
		default:
			System.out.println("올바르지 않은 입력");

		}
	}

	private void updateProducer() {
		// TODO Auto-generated method stub
		System.out.print("비밀번호를 입력하세요 : ");
		pw = st.nextLine();
		if (L.getPw().equals(pw) == false) {
			System.out.println("비밀번호가 틀립니다.");
			return;
		}
		System.out.println("----------------------------");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 주소 변경");
		System.out.println("4. 휴대폰번호 변경");
		System.out.println("----------------------------");
		
		switch(sc.nextInt()) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			System.out.println("올바르지 않은 입력");
			break;
		}
	}

	private void updateSyoubinn() {
		// TODO Auto-generated method stub
		System.out.print("비밀번호를 입력하세요 : ");
		pw = st.nextLine();
		if (L.getPw().equals(pw) == false) {
			System.out.println("비밀번호가 틀립니다.");
			return;
		}
		System.out.print("상품id를 입력하세요 : ");
		syoubinn_id = sc.nextInt();
		// res = 0이면 해당상품이 없습니다. 1=권한이없습니다(프로듀서id랑안맞음)
		// 2=메뉴출력
		int res = dao.checkSyoubinn(L.getId(), syoubinn_id);
		if (res == 0) {
			System.out.println("해당 상품이 존재하지 않습니다.");
		}
		if (res == 1) {
			System.out.println("다른 생산자의 상품입니다.");
		}
		if (res == 2) {

			System.out.println("----------------------------");
			System.out.println("1. 가격 변경");
			System.out.println("2. 재고 추가");
			System.out.println("----------------------------");
			switch (sc.nextInt()) {
			case 1:
				System.out.print("가격을 입력하세요 : ");
				price = sc.nextInt();
				dao.changePrice(syoubinn_id, price);
				System.out.println("변경되었습니다.");
				break;
			case 2:
				System.out.println("재고를 입력하세요 : ");
				stock = sc.nextInt();
				dao.addStock(id, stock);
				System.out.println("추가되었습니다");
				break;
			default:
				System.out.println("올바르지 않은 입력");
			}
		}

	}

	private void selled() {
		// TODO Auto-generated method stub
		ArrayList<Tyuumon> list = dao.selled();
		for (Tyuumon i : list)
			System.out.println(i);
	}

	private void selling() {
		// TODO Auto-generated method stub
		ArrayList<Syoubinn> list = dao.selling();
		for (Syoubinn i : list)
			System.out.println(i);
	}

	private void enroll() {
		// TODO Auto-generated method stub
		System.out.print("이름을 입력하세요 : ");
		name = st.nextLine();

		System.out.print("종류룰 입력하세요 : ");
		syuurui = st.nextLine();
		System.out.print("가격을 입력하세요 : ");
		price = sc.nextInt();
		producer_id = L.getId();
		System.out.print("재고를 입력하세요");
		stock = sc.nextInt();
		Syoubinn S = new Syoubinn(name, syuurui, price, producer_id, stock);
		boolean res = dao.enroll(S);
		if (res)
			System.out.println("등록 성공");
		else
			System.out.println("등록 실패");
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