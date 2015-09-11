package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppRest {
	@Autowired private JsonToFileService jsonToFileService;
	//------------BugTinyWiki------------------------------------
	String bugTinyWikiJsonFileName = "bugTinyWiki.json";
	@RequestMapping(value = "/saveBugTinyWiki", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> saveBugTinyWiki(@RequestBody Map<String, Object> bugTinyWikiJavaObject) {
		System.out.println(24);
		System.out.println(bugTinyWikiJsonFileName);
		jsonToFileService.saveJsonToFile(bugTinyWikiJavaObject,bugTinyWikiJsonFileName);
		return bugTinyWikiJavaObject;
	}
	
	@RequestMapping(value = "/page1/readBugTinyWiki", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> readBugTinyWiki() {
		return jsonToFileService.readJsonFromFile(bugTinyWikiJsonFileName);
	}
	//------------BugTinyWiki------------------------------------END

	//--------------componenten------------------------------
	@RequestMapping(value = "/page1/readJsonFromRam", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> readJsonFromRam() {
		Map<String, Object> map = new HashMap<>();
		map.put("text", "Hello World");
		map.put("int", 123);
		map.put("date", new Date());
		List<Integer> intList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3}));
		map.put("intList", intList);
		return map;
	}
	String firstJsonFileName = "javaObjectToJson.json";
	@RequestMapping(value = "/page1/json/save_json_to_file", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> saveJsonToFile(@RequestBody Map<String, Object> jsonToJavaObject) {
		jsonToFileService.saveJsonToFile(jsonToJavaObject,firstJsonFileName);
		return jsonToJavaObject;
	}
	@RequestMapping(value = "/page1/readJsonFromFile", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> readJsonFromFile() {
		return jsonToFileService.readJsonFromFile(firstJsonFileName);
	}

}
