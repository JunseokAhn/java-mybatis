package Dao;

import java.util.ArrayList;

import VO.Board;


public interface BoardMapper {
	
	public int insertBoard(Board Board);
	public ArrayList<Board> listBoard();
	public Board readBoard(int num);
	public void addHits(int num);
	
}
