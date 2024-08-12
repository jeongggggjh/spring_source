package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController2 {
	@GetMapping("list2")
	@ResponseBody
	public Map<String, Object> getJsons() {
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", "래시포드");
		data.put("age", "28");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "가르나초");
		data.put("age", "20");
		dataList.add(data);
		
		data = new HashMap<String, String>();
		data.put("name", "마이누");
		data.put("age", "19");
		dataList.add(data);
		// return data;
		System.out.println("data : " + data);
		
		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("datas", dataList);
		System.out.println("dataList : " + dataList);
		// [{name=래시포드, age=28}, {name=가르나초, age=20}, {name=마이누, age=19}]
		// @ResponseBody에 의해  {"datas":[{"name":"래시포드","age":"28"},{"name":"가르나초","age":"20"},{"name":"마이누","age":"19"}]}
		
		return data2;
		
		
	}
}
