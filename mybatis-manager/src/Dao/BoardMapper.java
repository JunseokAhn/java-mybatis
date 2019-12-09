package Dao;

import java.util.ArrayList;

import VO.Board;

public interface BoardMapper {
	
	public int insertBoard(Board Board);
	public ArrayList<Board> listBoard();
}
