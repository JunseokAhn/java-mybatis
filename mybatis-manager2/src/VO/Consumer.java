package VO;

public class Consumer {

	private String Consumer_id;
	private String Consumer_name;
	private int Property;
	public Consumer() {
		// TODO Auto-generated constructor stub
	}
	public Consumer(String consumer_id, String consumer_name, int property) {
		super();
		Consumer_id = consumer_id;
		Consumer_name = consumer_name;
		Property = property;
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
	public int getProperty() {
		return Property;
	}
	public void setProperty(int property) {
		Property = property;
	}
	@Override
	public String toString() {
		return "Consumer [Consumer_id=" + Consumer_id + ", Consumer_name=" + Consumer_name + ", Property=" + Property
				+ "]";
	}
	
}
