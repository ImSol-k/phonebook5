package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	//리스트
	@RequestMapping(value = "/phone/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("phonebookController.list()");

		List<PersonVo> personList = phonebookService.exeList();
		model.addAttribute("pList", personList);

		return "list";
	}

	//추가
	@RequestMapping(value = "/phone/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController>writeForm()");

		return "writeForm";
	}
	@RequestMapping(value = "/phone/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController>write()");

		phonebookService.exeWrite(personVo);

		return "redirect:/phone/list";
	}
	@RequestMapping(value = "/phone/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value="name") String name,
						 @RequestParam(value="hp") String hp,
						 @RequestParam(value="company") String company) {
		System.out.println("PhonebookController>write2()");

		phonebookService.exeWrite2(name, hp, company);

		return "redirect:/phone/list";
	}

	//수정
	@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("PhonebookController>modifyForm()");

		PersonVo personVo = phonebookService.exeModifyForm(no);
		model.addAttribute("personVo", personVo);

		return "modifyForm";
	}
	@RequestMapping(value = "/phone/modifyform2", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm2(@RequestParam(value = "no") int no, Model model) {
		System.out.println("PhonebookController>modifyForm2()");
		
		Map<String, Object> pMap = phonebookService.exeModifyForm2(no);
		model.addAttribute("pMap", pMap);
		
		return "modifyForm2";
	}
	@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController>modify()");
		
		phonebookService.exeModify(personVo);

		return "redirect:/phone/list";

	}

	//삭제
	@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhonebookController>delete()");

		phonebookService.exeDelete(no);

		return "redirect:/phone/list";
	}

}
