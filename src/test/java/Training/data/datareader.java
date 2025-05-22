package Training.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class datareader {

	public List<HashMap<String, String>> getJsondata() throws IOException
	{
		String jsonfile = FileUtils.readFileToString(new File("D:\\Studies\\Selenuim_JAVA_Udemy\\programs\\Training\\src\\test\\java\\Training\\data\\input.json"),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonfile, new TypeReference<List<HashMap<String, String>>>(){
			});
		return data;
		}
	
}
