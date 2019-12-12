package calendar.ui;

import java.util.ArrayList;
import java.util.Scanner;

import calendar.dao.MyCalendarDAO;
import calendar.vo.MyCalendar;

/**
 * 게시판 UI
 */
public class MyCalendarUI {

	private Scanner sc = new Scanner(System.in);
	MyCalendarDAO dao = new MyCalendarDAO();

	public MyCalendarUI() {

		while (true) {
			// 메인 메뉴
			printMainMenu();

			// 메뉴 입력받기
			int no = 0;
			try {
				no = sc.nextInt();
			} catch (Exception e) { // 예외 발생시
				sc.nextLine(); // Scanner 초기화
			}
			/*
			 * ("1. 일정 등록"); "2. 전체 일정 조회");("3. 일정 읽기"); "4. 일정 삭제"); "5. 일정 검색"); 6. 일정
			 * 수정");"9. 종료");
			 */
			// 메뉴 기능
			switch (no) {
			// 일정등록
			case 1:
				insert();
				break;
			// 전체 일정 조회
			case 2:
				list();
				break;
			// 일정 1개 읽기
			case 3:
				read();
				break;
			// 일정 삭제
			case 4:
				delete();
				break;
			// 일정 검색
			case 5:
				search();
				break;
			// 일정 수정
			case 6:
				update();
				break;

			// 프로그램 종료
			case 9:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("잘못 입력하셨습니다. ");
			}
		}
	}

	/**
	 * 메인메뉴
	 */
	public void printMainMenu() {
		System.out.println("[ 메인 메뉴 ]");
		System.out.println("1. 일정 등록");
		System.out.println("2. 전체 일정 조회");
		System.out.println("3. 일정 읽기");
		System.out.println("4. 일정 삭제");
		System.out.println("5. 일정 검색");
		System.out.println("6. 일정 수정");
		System.out.println("9. 종료");
		System.out.print("* 번호를 입력해 주세요 > ");
	}

	/**
	 * 일정 등록
	 */
	void insert() {
		String calendar_name, calendar_title, calendar_content;

		System.out.println("[ 일정 등록 ]");
		sc.nextLine();
		System.out.print("작성자: ");
		calendar_name = sc.nextLine();
		System.out.print("일정 제목: ");
		calendar_title = sc.nextLine();
		System.out.print("일정 내용: ");
		calendar_content = sc.nextLine();

		// TODO
		// 일정 정보를 입력받아서 일정 등록을 한다.
		// 등록된 결과에 따라 메세지를 출력한다.
		MyCalendar m = new MyCalendar(calendar_name, calendar_title, calendar_content);
		if (dao.insert(m) == false)
			System.out.println("입력 실패");

		System.out.println("입력 성공");
	}

	/**
	 * 일정 목록 조회
	 */
	void list() {
		// TODO
		// 전체 일정을 조회한다.
		// 조회된 결과에 따라서 출력한다.
		ArrayList<MyCalendar> list = dao.list();
		System.out.println("[ 일정 목록 조회 ]");
		for (MyCalendar i : list) {
			System.out.println(i);
		}
		if (list == null)
			System.out.println("목록이 없습니다.");
	}

	/**
	 * 일정 1개 읽기
	 */
	void read() {
		System.out.println("[ 일정 읽기 ]");
		System.out.print("* 일정번호를 입력해주세요  : ");

		int n = 0;

		try {
			n = sc.nextInt();
		} catch (Exception e) {
			sc.nextLine();
		}
		MyCalendar list = dao.read(n);
		System.out.println(list);

	}

	/**
	 * 일정 삭제
	 */
	void delete() {
		System.out.println("[ 일정 삭제 ]");
		System.out.print("* 일정 번호를 입력해주세요  : ");
		int n = 0;

		try {
			n = sc.nextInt();
		} catch (Exception e) {
			sc.nextLine();
		}

		// TODO
		// 입력된 번호의 일정을 삭제한다.
		// 삭제된 결과에 따라서 출력한다.
		boolean res = dao.delete(n);
		if (res) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}

	}

	/**
	 * 일정 검색
	 */
	void search() {
		System.out.println("[ 일정 검색 ]");
		int col = 0;
		String word = null;

		try {
			System.out.print("* 검색조건 : 1.작성자  2.일정제목  3.일정내용 > ");
			col = sc.nextInt();
			System.out.print("* 검색어를 입력해 주세요  > ");
			sc.nextLine();
			word = sc.nextLine();
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("잘못 입력하셨습니다.");
			return;
		}

		// TODO
		// 입력된 정보로 일정을 검색한다.
		// 검색된 결과에 따라서 출력한다.
		MyCalendar res = dao.search(col, word);
		System.out.println(res);
		if(res ==null) {
			System.out.println("조건에 맞는 정보가 없습니다");
		}
	}

	void update() {
		System.out.println("[ 일정 수정 ]");
		System.out.print("* 일정 번호를 입력해주세요  : ");
		int calendar_no = 0;
		String calendar_title, calendar_content;

		try {
			calendar_no = sc.nextInt();
		} catch (Exception e) {
			sc.nextLine();
		}

		sc.nextLine();
		System.out.print("* 변경할 일정 제목을 입력해 주세요  > ");
		calendar_title = sc.nextLine();
		System.out.print("* 변경할 일정 내용을 입력해 주세요  > ");
		calendar_content = sc.nextLine();

		// TODO
		// 입력된 정보로 일정을 수정한다.
		// 수정된 결과에 따라서 출력한다.
		
		boolean res = dao.update(calendar_no, calendar_title, calendar_content);
		if(res) {
			System.out.println("변경 완료");
		}else {
			System.out.println("변경 실패");
		}
		
	}

}
