package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String sijak(Model model) {
		model.addAttribute("msg", "타임리프~");
		model.addAttribute("msg2", "맨유 만세");
		
		// DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("제로콜라");
		sangpum.setPrice("2000");
		model.addAttribute("sangpum", sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("닥터페퍼");
		sangpum.setPrice("2000");
		list.add(sangpum);
		
		model.addAttribute("list", list);
		
		return "list1";
	}
	
}
