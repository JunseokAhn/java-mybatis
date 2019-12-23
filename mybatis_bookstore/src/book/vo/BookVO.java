package book.vo;

/**
 * 도서 정보를 저장하는 VO 클래스
 */
public class BookVO {
	private int bnum;				//상품 번호
	private String title;			//제목
	private String author;			//저자
	private String publisher;		//출판사
	private String type;			//종류 (book:책, ebook:전자책, cd:음반)
	private int price;				//가격
	private String inputdate;		//정보 등록일
	
public BookVO() {
	// TODO Auto-generated constructor stub
}

public BookVO(int bnum, String title, String author, String publisher, String type, int price) {
	super();
	this.bnum = bnum;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.type = type;
	this.price = price;
}

public BookVO(String title, String author, String publisher, String type, int price) {
	super();
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.type = type;
	this.price = price;
}

public int getBnum() {
	return bnum;
}

public String toString1() {
	 return "[ " + bnum +	  "] "+type+"\t"+title+"\t"+author+"\t\t"+inputdate; }

public String toString2() {
	return  "[ " + bnum +	  "] "+type+"\t"+title+"\t"+author+"\t"+publisher+"\t"+price;
}

public void setBnum(int bnum) {
	this.bnum = bnum;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getPublisher() {
	return publisher;
}

public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getInputdate() {
	return inputdate;
}

public void setInputdate(String inputdate) {
	this.inputdate = inputdate;
}
}
