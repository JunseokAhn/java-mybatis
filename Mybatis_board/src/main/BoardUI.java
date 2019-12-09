package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BoardDAO;
import vo.Board;
import vo.Reply;

/**
 * 게시판 프로그램의 사용자 화면
 */
public class BoardUI {
	private BoardDAO dao = new BoardDAO();			//DB관련 처리를 하는 클래스의 객체
	private Scanner sc = new Scanner(System.in); 	//키보드로부터 입력받기 위한 클래스의 객체
	
	/**
	 * 생성자. 메뉴화면을 띄우고 사용자의 입력을 받는다.
	 * */
	public BoardUI() {
		
		while(true) {
			//메인메뉴를 출력한다
			printMainMenu();
			
			//메뉴번호를 숫자로 입력받는다
			int no = 0;
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {	//숫자로 입력받을 수 없는 에러가 날 경우 Exception 처리.
				sc.nextLine();		//버퍼에 남아있는 문자들 삭제
			}
			
			//입력받은 번호에 따라 처리
			switch(no){
				//글쓰기
				case 1:  
					insert();
					break;
				
				//전체 글목록
				case 2: 
					list();
					break;
					
				//글 1개 읽기
				case 3: 
					read();
					break;
						
				//글 1개  삭제
				case 4: 
					delete();
					break;
					
				//글 검색
				case 5: 
					search();
					break;

				// 프로그램을 종료한다
				case 9: 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					
				default:
					System.out.println("번호를 다시 선택하세요.");
			}
		}
	}
	

	
	/**
	 * 메인 메뉴를 출력한다.
	 * */
	public void printMainMenu(){
		System.out.println("[ 게시판 연습 ]");
		System.out.println("1. 글 쓰기");
		System.out.println("2. 글 전체 목록");
		System.out.println("3. 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("9. 프로그램 종료");
		System.out.print("* 메뉴 번호를 선택하세요 > ");	
	}
	
	/**
	 * 글쓰기
	 */
	void insert() {
		String name, title, content;
		Board board;
		boolean res;
		
		System.out.println("[ 글쓰기 ]");
		sc.nextLine();			//앞서 남긴 개행문자 삭제
		System.out.print("이름: ");
		name = sc.nextLine();
		System.out.print("제목: ");
		title = sc.nextLine();
		System.out.print("내용: ");
		content = sc.nextLine();
		
		board = new Board(name, title, content);
		res = dao.insertBoard(board);
		
		if (res) {
			System.out.println("저장되었습니다.");
		}
		else {
			System.out.println("저장 실패하였습니다.");
		}
	}
	
	/**
	 * 전체 글 목록
	 */
	void list() {
		System.out.println("[ 글목록 ]");
		ArrayList<Board> list = dao.listBoard();
		
		if (list == null || list.size() == 0) {
			System.out.println("글이 없습니다.");
			return;
		}
		else {
			System.out.println("글 번호\t제목\t이름\t작성일");
			for (Board b : list) {
				System.out.print(b.getBoardnum() + "\t");
				System.out.print(b.getTitle() + "\t");
				System.out.print(b.getName() + "\t");
				System.out.print(b.getIndate() + "\n");
			}
		}
	}
	
	/**
	 * 글 1개 읽기
	 */
	void read() {
		System.out.println("[ 글읽기 ]");
		System.out.print("* 읽을 글 번호  : ");
		int n = 0;
		
		try {
			n = sc.nextInt();
		}
		catch (Exception e) {
			sc.nextLine();		//잘못입력된 경우 버퍼에 남아있는 문자들 삭제
		}
		
		while (true) {
			//본문 글 읽기
			Board board = null;
			if (board == null) {
				System.out.println("해당 번호의 글이 없습니다.");
				return;
			}
			
			System.out.println("번호 : " + board.getBoardnum());
			System.out.println("작성자 : " + board.getName());
			System.out.println("조회수 : " + board.getHits());
			System.out.println("작성날짜 : " + board.getIndate());
			System.out.println("제목 : " + board.getTitle());
			System.out.println("내용 : " + board.getContent());
			
			//해당 글에 달린 리플 읽기
			listReply(n);
			
			int sel = 0;
			System.out.print("1:리플 달기  0:메인메뉴로 > ");
			try {
				sel = sc.nextInt();
			}
			catch (Exception e) {
				sc.nextLine();		//잘못입력된 경우 버퍼에 남아있는 문자들 삭제
			}
		
			if (sel != 1) return;
			//글에 리플 달기
			insertReply(n);
		}
	}

	/**
	 * 1개의 글에 달린 리플 읽기
	 */
	void listReply(int num) {
		ArrayList<Reply> relist = null;
		
		System.out.println("===== 리플 =====");
		for (Reply r : relist) {

		}
	}
	
	/**
	 * 글에 리플 달기
	 */
	void insertReply(int boardnum) {
		String name, retext;
		Reply reply;
		boolean res;
		
		System.out.println("===== 리플쓰기 =====");
		sc.nextLine();			//앞서 남긴 개행문자 삭제
		System.out.print("이름: ");
		name = sc.nextLine();
		System.out.print("내용: ");
		retext = sc.nextLine();
		
		reply = null;
		res = false;
		
		if (res) {
			System.out.println("리플이 저장되었습니다.");
		}
		else {
			System.out.println("저장 실패하였습니다.");
		}		
	}

	/**
	 * 글 1개 삭제
	 */
	void delete() {
		System.out.println("[ 글삭제 ]");
		System.out.print("* 삭제할 글 번호  : ");
		int n = 0;
		
		try {
			n = sc.nextInt();
		}
		catch (Exception e) {
			sc.nextLine();		//잘못 입력된 경우 버퍼에 남아있는 문자들 삭제
		}
		
		boolean res = false;
		if (res) {
			System.out.println("삭제되었습니다.");
		}
		else {
			System.out.println("해당 번호의 글이 없습니다.");
		}
	}
	
	/**
	 * 검색
	 */
	void search() {
		System.out.println("[ 글검색 ]");
		int col = 0;
		String word = null;
		
		try {
			System.out.print("* 검색 대상 : 1.작성자  2.제목  3.내용 > ");
			col = sc.nextInt();
			System.out.print("* 검색어  > ");
			sc.nextLine();
			word = sc.nextLine();
		}
		catch (Exception e) {
			sc.nextLine();
			System.out.println("잘 못 입력했습니다.");
			return;
		}
		
		ArrayList<Board> list = null;
		
		if (list == null || list.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		else {
			for (Board b : list) {

			}
		}
	}
}