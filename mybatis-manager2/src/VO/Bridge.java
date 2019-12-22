package VO;

public class Bridge {

	private int Movie_num;
	private String Consumer_id;

	
	public Bridge() {
		// TODO Auto-generated constructor stub
	}


	public Bridge(int movie_num, String consumer_id) {
		super();
		Movie_num = movie_num;
		Consumer_id = consumer_id;
	}


	public int getMovie_num() {
		return Movie_num;
	}


	public void setMovie_num(int movie_num) {
		Movie_num = movie_num;
	}


	public String getConsumer_id() {
		return Consumer_id;
	}


	public void setConsumer_id(String consumer_id) {
		Consumer_id = consumer_id;
	}


	@Override
	public String toString() {
		return "Bridge [Movie_num=" + Movie_num + ", Consumer_id=" + Consumer_id + "]";
	}
}
