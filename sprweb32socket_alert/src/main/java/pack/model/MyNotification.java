package pack.model;

public class MyNotification {
	private String type;
	private String message;
	
	public MyNotification() {
		// TODO Auto-generated constructor stub
	}
	
	public MyNotification(String type, String message) {
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
