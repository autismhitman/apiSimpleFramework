package utils;

import org.json.JSONObject;

 

public class TestUtil {
	
	
	public static boolean hasKey(String json, String key) {
		
		JSONObject jo = new JSONObject(json);
	 
		return jo.has(key);
	}

		public static Object getJsonKeyValue(String json, String key) {
		
		JSONObject jo = new JSONObject(json);
		return  jo.get(key);
	}

}
