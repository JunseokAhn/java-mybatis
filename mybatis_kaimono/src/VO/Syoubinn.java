package VO;

public class Syoubinn {

	private int syoubinn_id;//seq
	private String name;
	private String syuurui;
	private int price;
	private String producer_id;
	private String s_indate; //default
	
	public Syoubinn() {
		// TODO Auto-generated constructor stub
	}

	public Syoubinn(String name, String syuurui, int price, String producer_id) {
		super();
		this.name = name;
		this.syuurui = syuurui;
		this.price = price;
		this.producer_id = producer_id;
	}

	@Override
	public String toString() {
		return "syoubinn_id=" + syoubinn_id + ", name=" + name + ", syuurui=" + syuurui + ", price=" + price
				+ ", producer_id=" + producer_id + ", s_indate=" + s_indate;
	}

	public int getSyoubinn_id() {
		return syoubinn_id;
	}

	public void setSyoubinn_id(int syoubinn_id) {
		this.syoubinn_id = syoubinn_id;
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
		return producer_id;
	}

	public void setProducer_id(String producer_id) {
		this.producer_id = producer_id;
	}

	public String getS_indate() {
		return s_indate;
	}

	public void setS_indate(String s_indate) {
		this.s_indate = s_indate;
	}
}
