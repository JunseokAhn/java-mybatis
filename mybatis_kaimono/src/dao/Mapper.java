package dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Consumer;
import VO.Producer;

public interface Mapper {

	int insertCon(Consumer c);

	int insertPro(Producer p);

	String checkID(String id);

	String checkPW(HashMap<String, String> map);

	ArrayList<Consumer> consumer_list();

	ArrayList<Producer> producer_list();

	String checkID1(String id);

	String checkID2(String id);
	
}
