package dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Consumer;
import VO.Producer;
import VO.Syoubinn;

public interface Mapper {

	int insertCon(Consumer c);

	int insertPro(Producer p);

	String checkID(String id);

	String checkPW(HashMap<String, String> map);

	ArrayList<Consumer> consumer_list();

	ArrayList<Producer> producer_list();

	Consumer checkID1(String id);

	Producer checkID2(String id);

	boolean enroll(Syoubinn s);
	
}
