package VO;

public class Syoubinn_list {

	private int tyuumon_id; 
	private int syoubinn_id; 
	
	public Syoubinn_list() {
		// TODO Auto-generated constructor stub
	}

	public Syoubinn_list(int tyuumon_id, int syoubinn_id) {
		super();
		this.tyuumon_id = tyuumon_id;
		this.syoubinn_id = syoubinn_id;
	}

	@Override
	public String toString() {
		return "tyuumon_id=" + tyuumon_id + ", syoubinn_id=" + syoubinn_id;
	}

	public int getTyuumon_id() {
		return tyuumon_id;
	}

	public void setTyuumon_id(int tyuumon_id) {
		this.tyuumon_id = tyuumon_id;
	}

	public int getSyoubinn_id() {
		return syoubinn_id;
	}

	public void setSyoubinn_id(int syoubinn_id) {
		this.syoubinn_id = syoubinn_id;
	}
}
