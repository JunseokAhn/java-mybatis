package VO;

public class Tyuumon {
	private int tyuumon_id; //seq
	private String consumer_id;
	private String t_indate; //default
	private int bridge_id; //로그인할떄마다 1씩증가
	
	public Tyuumon() {
		// TODO Auto-generated constructor stub
	}

	public Tyuumon(String consumer_id) {
		super();
		this.consumer_id = consumer_id;
	}

	@Override
	public String toString() {
		return "Tyuumon [tyuumon_id=" + tyuumon_id + ", consumer_id=" + consumer_id + ", t_indate=" + t_indate
				+ ", bridge_id=" + bridge_id + "]";
	}

	public int getTyuumon_id() {
		return tyuumon_id;
	}

	public void setTyuumon_id(int tyuumon_id) {
		this.tyuumon_id = tyuumon_id;
	}

	public String getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(String consumer_id) {
		this.consumer_id = consumer_id;
	}

	public String getT_indate() {
		return t_indate;
	}

	public void setT_indate(String t_indate) {
		this.t_indate = t_indate;
	}

	public int getBridge_id() {
		return bridge_id;
	}

	public void setBridge_id(int bridge_id) {
		this.bridge_id = bridge_id;
	}

	
}
