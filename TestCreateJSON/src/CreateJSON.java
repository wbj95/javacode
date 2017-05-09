import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateJSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonObject object = new JsonObject();
		object.addProperty("cat", "it");
		
		JsonArray array = new JsonArray();
		JsonObject lan1 = new JsonObject();
		lan1.addProperty("id", 1);
		lan1.addProperty("name", "java");
		lan1.addProperty("ide", "Eclipse");
		array.add(lan1);
		
		JsonObject lan2 = new JsonObject();
		lan1.addProperty("id", 2);
		lan1.addProperty("name", "Swift");
		lan1.addProperty("ide", "XCode");
		array.add(lan1);
		
		JsonObject lan3 = new JsonObject();
		lan1.addProperty("id", 3);
		lan1.addProperty("name", "C#");
		lan1.addProperty("ide", "Visual Studio");
		array.add(lan1);
		
		object.add("language", array);
		object.addProperty("pop", true);
		
		System.out.println(object.toString());
	}

}
