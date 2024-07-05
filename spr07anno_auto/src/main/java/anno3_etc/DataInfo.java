package anno3_etc;

import org.springframework.stereotype.Component;

@Component
public class DataInfo {
	private String name = "래시포드";
	private String part = "축구부";
	
	public String job = "축구선수";
	
	public String getName() {
		return name;
	}
	
	public String getPart() {
		return part;
	}
}
