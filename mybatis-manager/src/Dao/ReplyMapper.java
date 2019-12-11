package Dao;

import java.util.ArrayList;

import VO.Reply;

public interface ReplyMapper {

	ArrayList<Reply> listReply(int num);

	int insertReply(Reply reply);
	
}
