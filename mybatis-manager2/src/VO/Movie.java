package VO;

public class Movie {

	private int Movie_num;
	private String Movie_name;
	private int seki;
	private int price;
	private String Producer_id;

	
	public Movie() {
		// TODO Auto-generated constructor stub
	}


	public Movie(String movie_name, int seki, int price, String producer_id) {
		super();
		Movie_name = movie_name;
		this.seki = seki;
		this.price = price;
		Producer_id = producer_id;
	}


	public int getMovie_num() {
		return Movie_num;
	}


	public void setMovie_num(int movie_num) {
		Movie_num = movie_num;
	}


	public String getMovie_name() {
		return Movie_name;
	}


	public void setMovie_name(String movie_name) {
		Movie_name = movie_name;
	}


	public int getSeki() {
		return seki;
	}


	public void setSeki(int seki) {
		this.seki = seki;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getProducer_id() {
		return Producer_id;
	}


	public void setProducer_id(String producer_id) {
		Producer_id = producer_id;
	}


	@Override
	public String toString() {
		return "Movie [Movie_num=" + Movie_num + ", Movie_name=" + Movie_name + ", seki=" + seki + ", price=" + price
				+ ", Producer_id=" + Producer_id + "]";
	}

}
