package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.dto.MemberDto;
import pack.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@GetMapping("/member/mlist")
	public String memlist(Model model) {
		mService.getList(model);
		
		return "member/mlist";
	}
	
	// 추가
	@GetMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@PostMapping("/member/insert")
	public String insert(MemberDto fbean) {
		mService.insert(fbean);
		
		return "member/insert";
	}
	
	// 회원 수정
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam("num") Long num, Model model) {
		mService.getData(num, model);
		
		return "member/updateform";
	}
	
	@PostMapping("/member/update")
	public String update(MemberDto fbean) {
		// mService.update(fbean);
		mService.update2(fbean);
		
		return "member/update";
	}
	
	// 회원 삭제
	@GetMapping("/member/delete")
	public String deleteform(@RequestParam("num") Long num) {
		mService.delete(num);
		
		return "redirect:/member/mlist";
	}
	
}
