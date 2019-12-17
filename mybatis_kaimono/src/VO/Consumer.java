package VO;

public class Consumer {

	private String consumer_id;
	private String pw;
	private String name;
	private String address; // nullable
	private String phone; // nullable

	public Consumer() {
		// TODO Auto-generated constructor stub
	}

	public Consumer(String consumer_id, String pw, String name, String address, String phone) {
		super();
		this.consumer_id = consumer_id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "소비자id :" + consumer_id + ", pw :" + pw + ", 이름 :" + name + ", 주소 :" + address + ", 번호 :"
				+ phone;
	}

	public String getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(String consumer_id) {
		this.consumer_id = consumer_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
