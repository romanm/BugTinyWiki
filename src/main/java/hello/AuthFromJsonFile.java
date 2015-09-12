package hello;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

@Component("authFromJsonFile")
public class AuthFromJsonFile {
	@Autowired private JsonToFileService jsonToFileService;
	public void addAuthentication(String fileName, AuthenticationManagerBuilder auth) {
		Map<String, Object> authInfo = jsonToFileService.readJsonFromFile(fileName);
		System.out.println(authInfo);
		List<Map<String,Object>> users = (List<Map<String, Object>>) authInfo.get("users");
		for (Map<String, Object> map : users) {
			try {
				System.out.println(map);
				String user = (String) map.get("user");
				String password = (String) map.get("password");
				String role = (String) map.get("role");
				auth.inMemoryAuthentication()
				.withUser(user).password(password).roles(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
