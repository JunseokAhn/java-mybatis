package VO;

public class Bridge {

private String tyuumon_id;
private String syoubinn_id;

public Bridge() {
	// TODO Auto-generated constructor stub
}

public Bridge(String tyuumon_id, String syoubinn_id) {
	super();
	this.tyuumon_id = tyuumon_id;
	this.syoubinn_id = syoubinn_id;
}

@Override
public String toString() {
	return "Bridge [tyuumon_id=" + tyuumon_id + ", syoubinn_id=" + syoubinn_id + "]";
}

public String getTyuumon_id() {
	return tyuumon_id;
}

public void setTyuumon_id(String tyuumon_id) {
	this.tyuumon_id = tyuumon_id;
}

public String getSyoubinn_id() {
	return syoubinn_id;
}

public void setSyoubinn_id(String syoubinn_id) {
	this.syoubinn_id = syoubinn_id;
}


}