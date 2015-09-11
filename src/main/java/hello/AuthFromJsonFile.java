package hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

@Component("authFromJsonFile")
public class AuthFromJsonFile {
	@Autowired private JsonToFileService jsonToFileService;
	public void addAuthentication(String fileName, AuthenticationManagerBuilder auth) {
		Map<String, Object> readJsonFromFile = jsonToFileService.readJsonFromFile(fileName);
		System.out.println(readJsonFromFile);
	}

}
