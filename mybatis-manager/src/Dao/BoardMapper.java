package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Board;


public interface BoardMapper {
	
	public int insertBoard(Board Board);
	public ArrayList<Board> listBoard();
	public Board readBoard(int num);
	public void addHits(int num);
	public int delete(int n);
	public ArrayList<Board> search(HashMap<String, Object> map);
	
}
