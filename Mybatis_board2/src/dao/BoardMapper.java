package dao;

import java.util.ArrayList;

import VO.Board;

public interface BoardMapper {

	public int insertBoard(Board board);
	
	public ArrayList<Board> listBoard();
	
}
