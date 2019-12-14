package VO;

public class Producer {

	private String producer_id;
	private String pw;
	private String name;
	private String address; // nullable
	private String phone; // nullable

	public Producer() {
		// TODO Auto-generated constructor stub
	}

	public Producer(String producer_id, String pw, String name, String address, String phone) {

		super();
		this.producer_id = producer_id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "producer_id=" + producer_id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", phone="
				+ phone;
	}

	public String getProducer_id() {
		return producer_id;
	}

	public void setProducer_id(String producer_id) {

		this.producer_id = producer_id;
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
