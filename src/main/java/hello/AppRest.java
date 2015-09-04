package hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppRest {
	@Autowired private AppService appService;
	//------------BugTinyWiki------------------------------------
	String bugTinyWikiJsonFileName = "bugtw/bugTinyWiki.json";
	@RequestMapping(value = "/saveBugTinyWiki", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> saveBugTinyWiki(@RequestBody Map<String, Object> bugTinyWikiJavaObject) {
		System.out.println(24);
		System.out.println(bugTinyWikiJsonFileName);
		appService.saveJsonToFile(bugTinyWikiJavaObject,bugTinyWikiJsonFileName);
		return bugTinyWikiJavaObject;
	}
	
	@RequestMapping(value = "/page1/readBugTinyWiki", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> readBugTinyWiki() {
		return appService.readJsonFromFile(bugTinyWikiJsonFileName);
	}
	//------------BugTinyWiki------------------------------------END
}
