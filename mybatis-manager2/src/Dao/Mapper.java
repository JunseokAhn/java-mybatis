package Dao;

import java.util.ArrayList;
import java.util.HashMap;

import VO.Consumer;
import VO.Movie;
import VO.Producer;
import VO.Reply;

public interface Mapper {
	Producer checkPro(String id);

	Consumer checkCon(String id);

	void signUp_producer(String id, String name);

	void signUp_producer(HashMap<String, String> map);

	void signUp_consumer(HashMap<String, String> map);

	ArrayList<Producer> listPro();

	ArrayList<Consumer> listCon();

	void satuee(Movie m);

	ArrayList<Movie> eigaListPro(String id);

	ArrayList<Movie> eigaListCon(String id);
	
	ArrayList<Movie> eigaList();

	Movie selectEiga(int movie_num);

	void updateCon(Consumer c);

	void updateMovie(Movie m);

	void insertBridge(HashMap<String, Object> map);

	void reply(Reply r);

	ArrayList<Reply> selectReply(String string);

	void rereply(Reply r);
	

}
