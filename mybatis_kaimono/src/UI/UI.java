package UI;

import java.util.ArrayList;
import java.util.Scanner;

import VO.Consumer;
import VO.Login;
import VO.Producer;
import VO.Syoubinn;
import VO.Tyuumon;
import dao.dao;
import dao.dao2;

public class UI {
	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	dao dao = new dao();
	dao2 dao2 = new dao2();

	private int type;
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
			try {
				menu();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못된 입력입니다.");
				sc.nextLine();
			}
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 관리자 메뉴");
		switch (sc.nextInt()) {
		case 1:
			login();
			break;
		case 2:
			signUp();
			break;
		case 3:
			adminMenu();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
		}

	}

	private void adminMenu() {
		// TODO Auto-generated method stub
		System.out.println("1. 전체 이용자 조회");
		System.out.println("2. 판매중인 전체 상품 조회");
		System.out.println("3. 판매된 전체 상품 조회");
		System.out.println("0. 돌아가기");
		switch (sc.nextInt()) {
		case 1:
			list();
			adminMenu();
			break;
		case 2:
			selling();
			adminMenu();
			break;
		case 3:
			selled();
			adminMenu();
			break;
		case 0:
			menu();
			break;
		default:
			System.out.println("올바르지 않은 입력");

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
		id = L.getId();

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
		System.out.println("===========소비자 메뉴===========");
		System.out.println("1. 구매");
		System.out.println("2. 구매한 목록 리스트"); // 총 소비금액
		System.out.println("3. 구매 취소");
		System.out.println("4. 회원정보 수정");
		System.out.println("5. 탈퇴");
		System.out.println("\n0. 로그 아웃");
		System.out.println("============================");
		switch (sc.nextInt()) {
		case 1:
			buy(id);
			break;
		case 2:
			buyList(id);
			break;
		case 3:
			buyCancel(id);
			break;
		case 4:
			userUpdate(id);
			break;
		case 5:
			userDelete(id);
			break;

		case 0:
			menu();
			break;

		default:
			System.out.println("올바르지 않은 입력");
		}

	}

	private void userDelete(String id) {
		System.out.print("비밀번호를 입력하세요 : ");
		try {
			pw = st.nextLine();
			if (L.getPw().equals(pw) == false) {
				System.out.println("비밀번호가 틀립니다.");
				return;
			}
			boolean res = dao2.deleteUser(L.getId());
			if (res) {
				System.out.println("삭제 성공");
				menu();
			} else
				System.out.println("삭제 실패");
		} catch (Exception e) {
			System.out.println("비밀번호를 다시 확인해주세요.");
			sc.nextLine();
		}
	}

	private void userUpdate(String id) {
		while (true) {
			try {
				System.out.print("\n비밀번호를 입력하세요 : ");
				pw = st.nextLine();

				if (L.getPw().equals(pw) == false) {
					System.out.println("비밀번호가 틀립니다.");
					return;
				}

				System.out.println("----------------------------");
				System.out.println("1. 비밀번호 변경");
				System.out.println("2. 이름 변경");
				System.out.println("3. 주소 변경");
				System.out.println("4. 전화번호 변경");
				System.out.println("\n0. 상위 메뉴");
				System.out.println("----------------------------");
				System.out.print("메뉴 입력 : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("변경하실 비밀번호를 입력하세요");
						pw = st.nextLine();
						dao2.updateUserPw(L.getId(), pw);
						L.setPw(pw);
						System.out.println("변경 완료 \n다시 로그인해주세요");
						menu();
						break;
					case 2:
						System.out.println("변경하실 이름을 입력하세요");
						name = st.nextLine();
						dao2.updateUserName(L.getId(), name);
						System.out.println("변경 완료");
						break;
					case 3:
						System.out.println("변경하실 주소를 입력하세요");
						address = st.nextLine();
						dao2.updateUserAddress(L.getId(), address);
						System.out.println("변경 완료");
						break;
					case 4:
						System.out.println("변경하실 전화번호를 입력하세요");
						phone = st.nextLine();
						dao2.updateUserPhone(L.getId(), phone);
						System.out.println("변경 완료");
						break;

					case 0:
						return;
					default:
						System.out.println("올바르지 않은 입력");
						break;
					}
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
					sc.nextLine();
				}

			} catch (Exception e) {
				System.out.println("비밀번호를 다시 확인해주세요.");
				sc.nextLine();
			}
		}
	}

	private void buyCancel(String id) {
		try {
			buyList(id);
			System.out.print("\n취소 주문번호 입력 : ");
			int tyuumon_id = sc.nextInt();
			System.out.println("취소 수량 입력 : ");
			int stock = sc.nextInt();

			boolean res = dao2.buyCancel(id, tyuumon_id, stock);
			if (res) {
				System.out.println("취소 성공\n");
				buyList(id);
			} else
				System.out.println("취소 실패");
		} catch (Exception e) {
			System.out.println("주문번호와 수량을 재확인해주세요.");
			sc.nextLine();
		}
	}

	private void buy(String id) {
		selling();

		System.out.print("\n상품 ID 입력 : ");
		int syoubinn_id = sc.nextInt();

		if (dao.checkSyoubinn(L.getId(), syoubinn_id) == 0) {
			System.out.println("해당 상품이 존재하지 않습니다.");
			return;
		}
		System.out.print("구매 개수 입력 : ");
		int stock = sc.nextInt();
		boolean res2 = dao2.checkStock(syoubinn_id, stock);
		if (res2 == false) {
			System.out.println("재고가 모자랍니다.");
			return;
		}
		boolean res = dao2.buy(id, syoubinn_id, stock);
		if (res) {
			System.out.println("구매 성공\n");

			while (true) {
				System.out.println("==============================");
				System.out.println("1. 구매내역 보기");
				System.out.println("0. 상위 메뉴");
				System.out.print("메뉴 선택 : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						ArrayList<Tyuumon> tyu = dao2.buyList(id);
						if (tyu != null)
							System.out.println(tyu.toString());
						else
							System.out.println("주문내역이 없습니다.");
					case 0:
						return;
					default:
						System.out.println("잘못 입력하였습니다.");
					}
				} catch (Exception e) {
					System.out.println("숫자만 입력해주세요.");
					sc.nextLine();
				}
			}
		} else
			System.out.println("구매 실패");
	}

	private void buyList(String id) {
		ArrayList<Tyuumon> tyu = dao2.buyList(id);
		if (tyu != null) {
			for (Tyuumon i : tyu)
				System.out.println(i);
		} else
			System.out.println("주문내역이 없습니다.");
	}

	private void producerMenu() {
		// TODO Auto-generated method stub
		System.out.println("===========생산자 메뉴===========");
		System.out.println("1. 상품등록");
		System.out.println("2. 판매중 목록 리스트");
		System.out.println("3. 판매된 목록 리스트"); // 미구현, // +팔린 총 금액
		System.out.println("4. 판매정보 수정");
		System.out.println("5. 회원정보 수정");
		System.out.println("9. 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.println("============================");
		switch (sc.nextInt()) {
		case 1:
			enroll();
			break;
		case 2: // id랑 일치하는 목록만 보기
			sellingPro();
			break;
		case 3:
			selledPro();
			break;
		case 4:
			updateSyoubinn();
			break;
		case 5:
			updateProducer();
			break;
		case 9:
			deleteProducer();
			break;
		case 0:
			menu();
			break;
		default:
			System.out.println("올바르지 않은 입력");

		}
	}

	private void selledPro() {
		// TODO Auto-generated method stub
		ArrayList<Tyuumon> list = dao.selledPro(L.getId());
		if (list == null)
			return;
		for (Tyuumon i : list)
			System.out.println(i);
	}

	private void sellingPro() {
		// TODO Auto-generated method stub
		ArrayList<Syoubinn> list = dao.sellingPro(L.getId());
		for (Syoubinn i : list)
			System.out.println(i);
	}

	private void deleteProducer() {
		// TODO Auto-generated method stub
		System.out.print("비밀번호를 입력하세요 : ");
		pw = st.nextLine();
		if (L.getPw().equals(pw) == false) {
			System.out.println("비밀번호가 틀립니다.");
			return;
		}
		boolean res = dao.deleteProducer(L.getId());
		if (res) {
			System.out.println("삭제 성공");
			menu();
		} else
			System.out.println("삭제 실패");
	}

	private void updateProducer() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.print("비밀번호를 입력하세요 : ");
			pw = st.nextLine();
			if (L.getId().equals(id)) {
				if (L.getPw().equals(pw) == false) {
					System.out.println("비밀번호가 틀립니다.");
					return;
				}
			} else
				return;
			System.out.println("----------------------------");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 이름 변경");
			System.out.println("3. 주소 변경");
			System.out.println("4. 전화번호 변경");
			System.out.println("0. 상위메뉴로");
			System.out.println("----------------------------");

			switch (sc.nextInt()) {
			case 1:
				System.out.println("변경하실 비밀번호를 입력하세요");
				pw = st.nextLine();
				dao.updateProPw(L.getId(), pw);
				L.setPw(pw);
				break;
			case 2:
				System.out.println("변경하실 이름을 입력하세요");
				name = st.nextLine();
				dao.updateProName(L.getId(), name);
				break;
			case 3:
				System.out.println("변경하실 주소를 입력하세요");
				address = st.nextLine();
				dao.updateProAddress(L.getId(), address);
				break;
			case 4:
				System.out.println("변경하실 전화번호를 입력하세요");
				phone = st.nextLine();
				dao.updateProPhone(L.getId(), phone);
				break;
			case 0:
				return;
			default:
				System.out.println("올바르지 않은 입력");
				break;
			}
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
			System.out.println("다른 생산자의 상품입니다.");// 안됨
		}
		if (res == 2) {

			System.out.println("----------------------------");
			System.out.println("1. 가격 변경");
			System.out.println("2. 재고 추가");
			System.out.println("3. 판매 종료");
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
				dao.addStock(syoubinn_id, stock);
				System.out.println("추가되었습니다");
				break;
			case 3:
				dao.deleteSyoubinn(syoubinn_id);
				System.out.println("판매 종료되었습니다.");
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
		System.out.print("재고를 입력하세요 : ");
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