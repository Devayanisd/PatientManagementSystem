package utility;

import java.util.HashMap;
import java.util.Map;

public class TestData {

	public static Map<String,String> getLoginData(){
		HashMap<String,String> data = new HashMap<>();
		data.put("admin", "pass123");
		data.put("admin","Admin123");
		return data;
		
	}

}
