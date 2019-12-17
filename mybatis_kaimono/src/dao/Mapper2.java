package dao;

import java.util.ArrayList;

import VO.Bridge;
import VO.Syoubinn;
import VO.Tyuumon;

public interface Mapper2 {

	Syoubinn searchSyo(int num);

	ArrayList<Tyuumon> buyList(String id);

	int downStock(Syoubinn syo);

	int buy(Tyuumon tyu);

	int getBridge(Bridge bri);

}
