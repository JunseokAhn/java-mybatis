package VO;

public class Tyuumon {
	private int tyuumon_id; // seq
	private String name;
	private String syuurui;
	private int price;
	private String consumer_id;
	private int stock;
	private String s_indate; //default
	private String t_indate;

	public Tyuumon() {
		// TODO Auto-generated constructor stub
	}

	public Tyuumon(String name, String syuurui, int price, String consumer_id, int stock) {
		super();
		this.name = name;
		this.syuurui = syuurui;
		this.price = price;
		this.consumer_id = consumer_id;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Tyuumon [tyuumon_id=" + tyuumon_id + ", name=" + name + ", syuurui=" + syuurui + ", price=" + price
				+ ", consumer_id=" + consumer_id + ", stock=" + stock + ", s_indate=" + s_indate + ", t_indate="
				+ t_indate + "]";
	}

	public int getTyuumon_id() {
		return tyuumon_id;
	}

	public void setTyuumon_id(int tyuumon_id) {
		this.tyuumon_id = tyuumon_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSyuurui() {
		return syuurui;
	}

	public void setSyuurui(String syuurui) {
		this.syuurui = syuurui;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProducer_id() {
		return consumer_id;
	}

	public void setProducer_id(String consumer_id) {
		this.consumer_id = consumer_id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getS_indate() {
		return s_indate;
	}

	public void setS_indate(String s_indate) {
		this.s_indate = s_indate;
	}

	public String getT_indate() {
		return t_indate;
	}

	public void setT_indate(String t_indate) {
		this.t_indate = t_indate;
	}

	
	

}
