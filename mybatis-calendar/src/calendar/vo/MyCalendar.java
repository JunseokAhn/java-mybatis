package calendar.vo;

public class MyCalendar {
	private int calendar_no;
	private String calendar_name;
	private String calendar_title;
	private String calendar_content;
	private String calendar_indate;
	
	public MyCalendar() {
		super();
	}



	public MyCalendar(String calendar_name, String calendar_title, String calendar_content) {
		super();
		this.calendar_name = calendar_name;
		this.calendar_title = calendar_title;
		this.calendar_content = calendar_content;
	}



	public int getCalendar_no() {
		return calendar_no;
	}

	public void setCalendar_no(int calendar_no) {
		this.calendar_no = calendar_no;
	}

	public String getCalendar_name() {
		return calendar_name;
	}

	public void setCalendar_name(String calendar_name) {
		this.calendar_name = calendar_name;
	}

	public String getCalendar_title() {
		return calendar_title;
	}

	public void setCalendar_title(String calendar_title) {
		this.calendar_title = calendar_title;
	}

	public String getCalendar_content() {
		return calendar_content;
	}

	public void setCalendar_content(String calendar_content) {
		this.calendar_content = calendar_content;
	}

	public String getCalendar_indate() {
		return calendar_indate;
	}

	public void setCalendar_indate(String calendar_indate) {
		this.calendar_indate = calendar_indate;
	}

	@Override
	public String toString() {
		return "번호 :" + calendar_no + ", 이름 :" + calendar_name + ", 제목 :"
				+ calendar_title + ", 내용 :" + calendar_content + ", 작성일 :" + calendar_indate
				+ "]";
	}
}
