package VO;

public class Login {
	private String id;
	private String pw;
	private String name;
	private String address; // nullable
	private String phone; // nullable
	private int type;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public Login(String id, String pw, String name, String address, String phone, int type) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", type=" + type + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
