package dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Consumer;
import VO.Producer;
import VO.Syoubinn;
import VO.Tyuumon;

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

	ArrayList<Syoubinn> selling();

	ArrayList<Tyuumon> selled();

	int addStock(HashMap<String, Object> map);

	Syoubinn checkShoubinn(int syoubinn_id);

	void changePrice(HashMap<String, Integer> map);

	void updateProPw(HashMap<String, String> map);

	void updateProName(HashMap<String, String> map);

	void updateProAddress(HashMap<String, String> map);

	void updateProPhone(HashMap<String, String> map);

	int deleteProducer(String id);

	ArrayList<Syoubinn> sellingPro(String id);

	ArrayList<Syoubinn> selledPro(String id);
	

	
}
