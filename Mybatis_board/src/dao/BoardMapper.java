package dao;

import java.util.ArrayList;

import vo.Board;

public interface BoardMapper {
	public int insertBoard(Board board);
	
	public ArrayList<Board> listBoard();
}
