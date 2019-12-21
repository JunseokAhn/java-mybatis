package VO;

public class Login {
	private String id;
	private String name;
	private int Property;
	private int type;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public Login(String id, String name, int property, int type) {
		super();
		this.id = id;
		this.name = name;
		Property = property;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", Property=" + Property + ", type=" + type
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
