package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Consumer;
import VO.Producer;

public interface Mapper {
	Producer checkPro(String id);

	Consumer checkCon(String id);

	void signUp_producer(String id, String name);

	void signUp_producer(HashMap<String, String> map);

	void signUp_consumer(HashMap<String, String> map);

	ArrayList<Producer> listPro();

	ArrayList<Consumer> listCon();

	

}
