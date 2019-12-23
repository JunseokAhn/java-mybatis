package book.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Scanner;

import book.dao.BookDAO;
import book.vo.BookVO;

public class BookUI {

	BookDAO dao = new BookDAO();

	boolean flag = true;
	Scanner sc = new Scanner(System.in);
	Scanner st = new Scanner(System.in);
	private int bnum; // 상품 번호
	private String title; // 제목
	private String author; // 저자
	private String publisher; // 출판사
	private String type; // 종류 (book:책, ebook:전자책, cd:음반)
	private int price; // 가격
	private String inputdate; // 정보 등록일

	public BookUI() {
		while (flag) {
			try {
				menu();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("잘못된 입력");
				sc.nextLine();
			}
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("\t[ 서점 관리]");
		System.out.println("1.\t도서정보 등록");
		System.out.println("2.\t전체목록 출력");
		System.out.println("3.\t도서정보 삭제");
		System.out.println("4.\t도서정보 수정");
		System.out.println("5.\t검색");
		System.out.println("0.\t프로그램 종료");
		System.out.print("* 번호선택 : ");
		switch (sc.nextInt()) {
		case 1:
			insertBook();
			break;
		case 2:
			listAll();
			break;
		case 3:
			deleteBook();
			break;
		case 4:
			updateBook();
			break;
		case 5:
			searchBook();
			break;
		case 0:
			flag = false;
			System.out.println("[알림] 프로그램을 종료합니다.");
			break;
		default:
			System.out.println("[알림] 다시 선택하세요.");
			break;
		}
	}

	private void searchBook() {
		try {
			// TODO Auto-generated method stub
			System.out.println("\t[검색]");
			System.out.print("검색할 대상 (1:제목 / 2:저자 : 3:출판사) : ");
			int choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3)
				throw new EmptyStackException();
			System.out.print("검색할 값 : ");
			String text = st.nextLine();
			ArrayList<BookVO> list = dao.searchBook(choice, text);
			if (list.size() == 0) {
				System.out.println("[알림] 검색 결과가 없습니다.");
				return;
			}
			System.out.println("번호 종류\t제목\t저자\t출판사\t가격");
			System.out.println("============================");
			for (BookVO i : list)
				System.out.println(i.toString2());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 입력");
			sc.nextLine();
			searchBook();
		}
	}

	private void updateBook() {
		try {
			// TODO Auto-generated method stub
			int count = 0;
			System.out.println("\t[ 도서정보 수정 ]");
			System.out.print("수정할 도서번호 : ");
			bnum = sc.nextInt();
			BookVO book = dao.getBook(bnum);
			if (book == null) {
				System.out.println("[알림] 수정할 데이터가 없습니다.");
				return;
			}
			System.out.println("* 기존 정보");
			System.out.println("번호 : " + book.getBnum());
			System.out.println("제목 : " + book.getTitle());
			System.out.println("저자 : " + book.getAuthor());
			System.out.println("출판사 : " + book.getPublisher());
			System.out.println("종류 : " + book.getType());
			System.out.println("가격 : " + book.getPrice());
			System.out.println("=====================");
			System.out.println("* 수정할 정보");
			System.out.print("제목 : ");
			title = st.nextLine();
			if (title.equals("")) {
				title = book.getTitle();
				count++;
			}
			System.out.print("저자 : ");
			author = st.nextLine();
			if (author.equals("")) {
				author = book.getAuthor();
				count++;
			}
			System.out.print("출판사 : ");
			publisher = st.nextLine();
			if (publisher.equals("")) {
				publisher = book.getPublisher();
				count++;
			}
			System.out.print("가격 : ");
			String temp = st.nextLine();
			if (temp.equals("")) {
				price = 0;
			} else {
				price = Integer.parseInt(temp);
			}
			if (price == 0) {
				price = book.getPrice();
				count++;
			}
			if (count == 4) {
				System.out.println("[알림] 수정되었습니다.");
				return;
			}
			BookVO vo = new BookVO(bnum, title, author, publisher, book.getType(), price);

			int res = dao.updateBook(vo);
			if (res > 0)
				System.out.println("[알림] 수정되었습니다.");
			else
				System.out.println("[알림] 수정 실패하였습니다");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 입력");
			sc.nextLine();
			updateBook();
		}
	}

	private void deleteBook() {
		try {
			// TODO Auto-generated method stub
			System.out.println("\t[ 도서정보 삭제 ]");
			System.out.print("삭제할 번호 : ");
			bnum = sc.nextInt();
			BookVO book = dao.getBook(bnum);
			if (book == null) {
				System.out.println("[알림] 삭제할 데이터가 없습니다.");
				return;
			}
			int res = dao.deleteBook(bnum);
			if (res > 0)
				System.out.println("[알림] 삭제되었습니다.");
			else
				System.out.println("[알림] 삭제 실패");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("잘못된 입력");
			sc.nextLine();
			deleteBook();
		}
	}

	private void listAll() {
		// TODO Auto-generated method stub
		ArrayList<BookVO> list = dao.listAll();
		if (list.size() == 0) {
			System.out.println("[알림] 등록된 데이터가 없습니다.");
			return;
		}
		System.out.println("\t[ 전체 도서목록 ]");
		System.out.println("번호 종류\t제목\t저자\t\t등록일");
		System.out.println("============================");
		String temp;
		String [] list2;
		for(int i=0; i<list.size(); i++) {
			temp = list.get(i).getInputdate();
			list2=temp.split(" ");
			list.get(i).setInputdate(list2[0].replace('-', '/').substring(2));
			System.out.println(list.get(i).toString1());
		}
	
	}

	private void insertBook() {
		try {
			// TODO Auto-generated method stub
			System.out.println("\t[ 새 도서정보 등록 ]");
			System.out.print(" 제목 : ");
			title = st.nextLine();
			System.out.print(" 저자 : ");
			author = st.nextLine();
			System.out.print(" 출판사 : ");
			publisher = st.nextLine();
			System.out.print(" 종류 (book:책, ebook:전자책, cd:음반 : ");
			type = st.nextLine();
			if (!type.equals("book") && !type.equals("ebook") && !type.equals("cd")) {
				System.out.println("올바른 종류를 입력해주세요");
				insertBook();
				return;
			}
			System.out.print(" 가격 : ");
			String temp = st.nextLine();
			if (temp.equals("")) {
				price = 0;
			} else {
				price = Integer.parseInt(temp);
			}
			BookVO vo = new BookVO(title, author, publisher, type, price);
			int res = dao.insertBook(vo);
			if (res == 1) {
				System.out.println("[알림] 저장되었습니다.");
			} else {
				System.out.println("[알림] 저장 실패하였습니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[알림] 잘못된 입력. 저장 실패하였습니다");
			sc.nextLine();
		}

	}

}
