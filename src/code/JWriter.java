/*package code;

import static code.Window.*;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JWriter {
	private static final String jsonFilePath = "./src/out/test.json";
		public static void main(String[] args) {
			JsonObject jsonObject1 = new JsonObject();
			JsonArray jsonArray = new JsonArray();
			JsonElement jsonElement = null;
			
			jsonObject1.addProperty("displayName", name);
			jsonObject1.addProperty("test", toolTip);

			try{
				
				FileWriter jsonFileWriter = new FileWriter(jsonFilePath);
				jsonFileWriter.write(jsonObject1.toString());
				jsonFileWriter.flush();
				jsonFileWriter.close();
				System.out.println(jsonObject1);
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
}
*/