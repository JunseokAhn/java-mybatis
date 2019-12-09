package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BoardDAO;
import vo.Board;
import vo.Reply;

/**
 * �Խ��� ���α׷��� ����� ȭ��
 */
public class BoardUI {
	private BoardDAO dao = new BoardDAO();			//DB���� ó���� �ϴ� Ŭ������ ��ü
	private Scanner sc = new Scanner(System.in); 	//Ű����κ��� �Է¹ޱ� ���� Ŭ������ ��ü
	
	/**
	 * ������. �޴�ȭ���� ���� ������� �Է��� �޴´�.
	 * */
	public BoardUI() {
		
		while(true) {
			//���θ޴��� ����Ѵ�
			printMainMenu();
			
			//�޴���ȣ�� ���ڷ� �Է¹޴´�
			int no = 0;
			try {
				no = sc.nextInt();
			}
			catch (Exception e) {	//���ڷ� �Է¹��� �� ���� ������ �� ��� Exception ó��.
				sc.nextLine();		//���ۿ� �����ִ� ���ڵ� ����
			}
			
			//�Է¹��� ��ȣ�� ���� ó��
			switch(no){
				//�۾���
				case 1:  
					insert();
					break;
				
				//��ü �۸��
				case 2: 
					list();
					break;
					
				//�� 1�� �б�
				case 3: 
					read();
					break;
						
				//�� 1��  ����
				case 4: 
					delete();
					break;
					
				//�� �˻�
				case 5: 
					search();
					break;

				// ���α׷��� �����Ѵ�
				case 9: 
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					
				default:
					System.out.println("��ȣ�� �ٽ� �����ϼ���.");
			}
		}
	}
	

	
	/**
	 * ���� �޴��� ����Ѵ�.
	 * */
	public void printMainMenu(){
		System.out.println("[ �Խ��� ���� ]");
		System.out.println("1. �� ����");
		System.out.println("2. �� ��ü ���");
		System.out.println("3. �� �б�");
		System.out.println("4. �� ����");
		System.out.println("5. �� �˻�");
		System.out.println("9. ���α׷� ����");
		System.out.print("* �޴� ��ȣ�� �����ϼ��� > ");	
	}
	
	/**
	 * �۾���
	 */
	void insert() {
		String name, title, content;
		Board board;
		boolean res;
		
		System.out.println("[ �۾��� ]");
		sc.nextLine();			//�ռ� ���� ���๮�� ����
		System.out.print("�̸�: ");
		name = sc.nextLine();
		System.out.print("����: ");
		title = sc.nextLine();
		System.out.print("����: ");
		content = sc.nextLine();
		
		board = new Board(name, title, content);
		res = dao.insertBoard(board);
		
		if (res) {
			System.out.println("����Ǿ����ϴ�.");
		}
		else {
			System.out.println("���� �����Ͽ����ϴ�.");
		}
	}
	
	/**
	 * ��ü �� ���
	 */
	void list() {
		System.out.println("[ �۸�� ]");
		ArrayList<Board> list = dao.listBoard();
		
		if (list == null || list.size() == 0) {
			System.out.println("���� �����ϴ�.");
			return;
		}
		else {
			System.out.println("�� ��ȣ\t����\t�̸�\t�ۼ���");
			for (Board b : list) {
				System.out.print(b.getBoardnum() + "\t");
				System.out.print(b.getTitle() + "\t");
				System.out.print(b.getName() + "\t");
				System.out.print(b.getIndate() + "\n");
			}
		}
	}
	
	/**
	 * �� 1�� �б�
	 */
	void read() {
		System.out.println("[ ���б� ]");
		System.out.print("* ���� �� ��ȣ  : ");
		int n = 0;
		
		try {
			n = sc.nextInt();
		}
		catch (Exception e) {
			sc.nextLine();		//�߸��Էµ� ��� ���ۿ� �����ִ� ���ڵ� ����
		}
		
		while (true) {
			//���� �� �б�
			Board board = null;
			if (board == null) {
				System.out.println("�ش� ��ȣ�� ���� �����ϴ�.");
				return;
			}
			
			System.out.println("��ȣ : " + board.getBoardnum());
			System.out.println("�ۼ��� : " + board.getName());
			System.out.println("��ȸ�� : " + board.getHits());
			System.out.println("�ۼ���¥ : " + board.getIndate());
			System.out.println("���� : " + board.getTitle());
			System.out.println("���� : " + board.getContent());
			
			//�ش� �ۿ� �޸� ���� �б�
			listReply(n);
			
			int sel = 0;
			System.out.print("1:���� �ޱ�  0:���θ޴��� > ");
			try {
				sel = sc.nextInt();
			}
			catch (Exception e) {
				sc.nextLine();		//�߸��Էµ� ��� ���ۿ� �����ִ� ���ڵ� ����
			}
		
			if (sel != 1) return;
			//�ۿ� ���� �ޱ�
			insertReply(n);
		}
	}

	/**
	 * 1���� �ۿ� �޸� ���� �б�
	 */
	void listReply(int num) {
		ArrayList<Reply> relist = null;
		
		System.out.println("===== ���� =====");
		for (Reply r : relist) {

		}
	}
	
	/**
	 * �ۿ� ���� �ޱ�
	 */
	void insertReply(int boardnum) {
		String name, retext;
		Reply reply;
		boolean res;
		
		System.out.println("===== ���þ��� =====");
		sc.nextLine();			//�ռ� ���� ���๮�� ����
		System.out.print("�̸�: ");
		name = sc.nextLine();
		System.out.print("����: ");
		retext = sc.nextLine();
		
		reply = null;
		res = false;
		
		if (res) {
			System.out.println("������ ����Ǿ����ϴ�.");
		}
		else {
			System.out.println("���� �����Ͽ����ϴ�.");
		}		
	}

	/**
	 * �� 1�� ����
	 */
	void delete() {
		System.out.println("[ �ۻ��� ]");
		System.out.print("* ������ �� ��ȣ  : ");
		int n = 0;
		
		try {
			n = sc.nextInt();
		}
		catch (Exception e) {
			sc.nextLine();		//�߸� �Էµ� ��� ���ۿ� �����ִ� ���ڵ� ����
		}
		
		boolean res = false;
		if (res) {
			System.out.println("�����Ǿ����ϴ�.");
		}
		else {
			System.out.println("�ش� ��ȣ�� ���� �����ϴ�.");
		}
	}
	
	/**
	 * �˻�
	 */
	void search() {
		System.out.println("[ �۰˻� ]");
		int col = 0;
		String word = null;
		
		try {
			System.out.print("* �˻� ��� : 1.�ۼ���  2.����  3.���� > ");
			col = sc.nextInt();
			System.out.print("* �˻���  > ");
			sc.nextLine();
			word = sc.nextLine();
		}
		catch (Exception e) {
			sc.nextLine();
			System.out.println("�� �� �Է��߽��ϴ�.");
			return;
		}
		
		ArrayList<Board> list = null;
		
		if (list == null || list.size() == 0) {
			System.out.println("�˻� ����� �����ϴ�.");
			return;
		}
		else {
			for (Board b : list) {

			}
		}
	}
}