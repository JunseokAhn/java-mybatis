package dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Bridge;
import VO.Syoubinn;
import VO.Tyuumon;

public interface Mapper2 {

	Syoubinn searchSyo(int syoubinn_id);

	ArrayList<Tyuumon> buyList(String id);

	int downStock(HashMap<String, Object> map);

	int buy(Tyuumon t);

	int getBridge(int syoubinn_id);

	Tyuumon selectTyu(String id);

	int buyCancel(Tyuumon tyu);

	int checkStock(HashMap<String, Integer> map);

	Syoubinn selectSyo(Bridge bri);

	int upStock(Syoubinn syo);

	Bridge getBridge2(int tyuumon_id);

	int deleteUser(String id);

	void updateUserPw(HashMap<String, String> map);

	void updateUserName(HashMap<String, String> map);

	void updateUserAddress(HashMap<String, String> map);

	void updateUserPhone(HashMap<String, String> map);


}
