package VO;

public class Bridge {

private int bridge_id; //로그인할때마다 bridge_id 1씩 증가

public Bridge() {
	// TODO Auto-generated constructor stub
}
public Bridge(int bridge_id) {
	super();
	this.bridge_id = bridge_id;
}
@Override
public String toString() {
	return "Bridge [bridge_id=" + bridge_id + "]";
}
public int getBridge_id() {
	return bridge_id;
}
public void setBridge_id(int bridge_id) {
	this.bridge_id = bridge_id;
}



}