package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.Jikwon;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;

	@GetMapping("jikwon")
	public String searchProcess(@RequestParam(name = "jikwon_jik", required = false) String jikwon_jik, Model model) {
		List<Jikwon> list;

		list = dataDao.getDataSearch(jikwon_jik);

		model.addAttribute("datas", list);
		return "list";
	}
}
