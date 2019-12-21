package VO;

public class Login {
	private String id;
	private String Consumer_name;
	private int Property;
	private int type;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public Login(String id, String consumer_name, int property, int type) {
		super();
		this.id = id;
		Consumer_name = consumer_name;
		Property = property;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", Consumer_name=" + Consumer_name + ", Property=" + Property + ", type=" + type
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConsumer_name() {
		return Consumer_name;
	}

	public void setConsumer_name(String consumer_name) {
		Consumer_name = consumer_name;
	}

	public int getProperty() {
		return Property;
	}

	public void setProperty(int property) {
		Property = property;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
