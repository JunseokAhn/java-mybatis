package VO;

public class Consumer {
	
	private int consumer_id;
	private String pw;
	private String name;
	private String address; //nullable
	private String phone; //nullable
	
	public Consumer() {
		// TODO Auto-generated constructor stub
	}

	public Consumer(int consumer_id, String pw, String name, String address, String phone) {
		super();
		this.consumer_id = consumer_id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "consumer_id=" + consumer_id + ", pw=" + pw + ", name=" + name + ", address=" + address
				+ ", phone=" + phone;
	}

	public int getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(int consumer_id) {
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
