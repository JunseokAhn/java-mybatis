package vo;

//게시판 글 정보 VO
public class Board {
	private int boardnum;		//게시글 일련번호
	private String name;		//작성자 이름
	private String title;		//글제목
	private String content;		//글내용
	private int hits;			//조회수
	private String indate;		//작성일
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(String name, String title, String content) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	@Override
	public String toString() {
		return "Board [boardnum=" + boardnum + ", name=" + name + ", title=" + title + ", content=" + content
				+ ", hits=" + hits + ", indate=" + indate + "]";
	}
}