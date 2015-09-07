package hello;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QaRest {
	@Autowired private AppService appService;
	String qaJsonFileName = "qa.json";
	@RequestMapping(value = "/saveQa", method = RequestMethod.POST)
	public  @ResponseBody Map<String, Object> saveQa(@RequestBody Map<String, Object> qaJsonJavaObject) {
		System.out.println(18);
		System.out.println(qaJsonFileName);
		appService.saveJsonToFile(qaJsonJavaObject,qaJsonFileName);
		return qaJsonJavaObject;
	}
	@RequestMapping(value = "/qa/read", method = RequestMethod.GET)
	public  @ResponseBody Map<String, Object> readBugTinyWiki() {
		Map<String, Object> readJsonFromFile = appService.readJsonFromFile(qaJsonFileName);
		return readJsonFromFile;
	}
	@RequestMapping(value = "/qa/randomQa", method = RequestMethod.POST)
	public  @ResponseBody Set<Integer> randomQa(@RequestBody Map<String, Object> randomQa) {
		System.out.println(randomQa);
		int qForTest = (int) randomQa.get("qForTest");
//		int maxAsk = 5;
		int qMax = (int) randomQa.get("qMax");
		Set s = new HashSet<Integer>();
		int cnt = 0;
		System.out.println(qForTest+"/"+qMax+"/"+cnt);
		while (s.size()<qForTest) {
			cnt++;
			double random = Math.random();
			int n = (int) (qMax*random);
			System.out.println(s.size()+"/"+cnt+"/"+random+"//"+n);
			if(n==0)
				continue;
			s.add(n);
			if(cnt > 100)
				break;
		}
		System.out.println(s+"/"+qMax+"/"+cnt);
		return s;
	}
}
