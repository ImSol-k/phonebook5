package com.javaex.controller;

import java.util.List;

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

	@RequestMapping(value = "/phone/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("phonebookController.list()");

		List<PersonVo> personList = phonebookService.exeList();
		model.addAttribute("pList", personList);

		return "list";
	}

	@RequestMapping(value = "/phone/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController>writeForm()");

		return "writeForm";
	}

	@RequestMapping(value = "/phone/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController>write()");

		phonebookService.exeWrite(personVo);

		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/modifyform", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "no") int no, Model model) {
		System.out.println("PhonebookController>modifyForm()");

		PersonVo personVo = phonebookService.exeModifyForm(no);
		model.addAttribute("personVo", personVo);

		return "modifyForm";
	}

	@RequestMapping(value = "/phone/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController>modify()");
		
		phonebookService.exeModify(personVo);

		return "redirect:/phone/list";

	}

	@RequestMapping(value = "/phone/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhonebookController>delete()");

		phonebookService.exeDelete(no);

		return "redirect:/phone/list";
	}

}
