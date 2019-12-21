package VO;

public class Bridge {

	private int Movie_num;
	private String Consumer_id;
	private String Consumer_name;
	
	public Bridge() {
		// TODO Auto-generated constructor stub
	}

	public Bridge(int movie_num, String consumer_id, String consumer_name) {
		super();
		Movie_num = movie_num;
		Consumer_id = consumer_id;
		Consumer_name = consumer_name;
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

	public String getConsumer_name() {
		return Consumer_name;
	}

	public void setConsumer_name(String consumer_name) {
		Consumer_name = consumer_name;
	}

	@Override
	public String toString() {
		return "Bridge [Movie_num=" + Movie_num + ", Consumer_id=" + Consumer_id + ", Consumer_name=" + Consumer_name
				+ "]";
	}
}
