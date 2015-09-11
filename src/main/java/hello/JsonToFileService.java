package hello;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component("jsonToFileService")
public class JsonToFileService {

	ObjectMapper mapper = new ObjectMapper();
	public void saveJsonToFile(Map<String, Object> javaObjectToJson, String fileName) {
		File file = new File(AppConfig.applicationDbFolderPfad + fileName);
		System.out.println(file);
		ObjectWriter writerWithDefaultPrettyPrinter = mapper.writerWithDefaultPrettyPrinter();
		System.out.println(23);
		try {
			System.out.println(25);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			System.out.println(27);
			System.out.println(fileOutputStream);
			writerWithDefaultPrettyPrinter.writeValue(fileOutputStream, javaObjectToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> readJsonFromFile(String fileName) {
		File file = new File(AppConfig.applicationDbFolderPfad + fileName);
		System.out.println(37);
		System.out.println(file);
		Map<String, Object> readJsonFileToJavaObject = null;
		try {
			readJsonFileToJavaObject = mapper.readValue(file, Map.class);
		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return readJsonFileToJavaObject;
	}

}
