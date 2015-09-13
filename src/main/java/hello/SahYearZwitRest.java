package hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SahYearZwitRest {
	@Autowired private JsonToFileService jsonToFileService;
	@RequestMapping(value = "/page1/readSahYearZwit", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> readSahYearZwit() {
		return jsonToFileService.readJsonFromFile(AppConfig.sahYearZwitJsonFileName);
	}
	@RequestMapping(value = "/saveRegion", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> saveSah(@RequestBody Map<String, Object> qaJsonJavaObject) {
		System.out.println(21);
		System.out.println(AppConfig.sahYearZwitJsonFileName);
		jsonToFileService.saveJsonToFile(qaJsonJavaObject,AppConfig.sahYearZwitJsonFileName);
		return qaJsonJavaObject;
	}
}
