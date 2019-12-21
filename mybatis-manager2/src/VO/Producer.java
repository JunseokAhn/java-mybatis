package VO;

public class Producer {
	
	private String Producer_id;
	private String Producer_name;
	private int Property;
	
	public Producer() {
		// TODO Auto-generated constructor stub
	}public Producer(String producer_id, String producer_name, int property) {
		super();
		Producer_id = producer_id;
		Producer_name = producer_name;
		Property = property;
	}

	@Override
	public String toString() {
		return "Producer [Producer_id=" + Producer_id + ", Producer_name=" + Producer_name + ", Property=" + Property
				+ "]";
	}
	public String getProducer_id() {
		return Producer_id;
	}

	public void setProducer_id(String producer_id) {
		Producer_id = producer_id;
	}

	public String getProducer_name() {
		return Producer_name;
	}

	public void setProducer_name(String producer_name) {
		Producer_name = producer_name;
	}

	public int getProperty() {
		return Property;
	}

	public void setProperty(int property) {
		Property = property;
	}

	
}
