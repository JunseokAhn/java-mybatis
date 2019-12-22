package VO;

public class Reply {

	private int Reply_num;
	private String Contents;
	private int Movie_num;
	private String Consumer_id;
	private int Rereply_num;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	public Reply(String contents, int movie_num, String consumer_id) {
		super();
		Contents = contents;
		Movie_num = movie_num;
		Consumer_id = consumer_id;
	}
	public Reply(String contents, int movie_num, String id, int rereply_num) {
		// TODO Auto-generated constructor stub
		Contents = contents;
		Movie_num = movie_num;
		Consumer_id = id;
		Rereply_num = rereply_num;
	}
	@Override
	public String toString() {
		return "Reply [Reply_num=" + Reply_num + ", Contents=" + Contents + ", Movie_num=" + Movie_num
				+ ", Consumer_id=" + Consumer_id + ", Rereply_num=" + Rereply_num + "]";
	}
	public int getReply_num() {
		return Reply_num;
	}
	public void setReply_num(int reply_num) {
		Reply_num = reply_num;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
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
	public int getRereply_num() {
		return Rereply_num;
	}
	public void setRereply_num(int rereply_num) {
		Rereply_num = rereply_num;
	}
	
}
