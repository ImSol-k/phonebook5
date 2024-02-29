package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;

	//리스트
	public List<PersonVo> exeList() {

		System.out.println("PhoneDao.exeList()");
		List<PersonVo> personList = phonebookDao.personSelect();

		return personList;
	}

	//추가
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		int count = phonebookDao.personInsert(personVo);
		return count;
	}
	public int exeWrite2(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite2()");
		
		System.out.println(name + hp + company);
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		phonebookDao.personInsert2(personMap);
		
		return 0;
	}

	//수정
	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");

		PersonVo personVo = phonebookDao.personSelectOne(no);

		return personVo;
	}
	public Map<String, Object> exeModifyForm2(int no) {
		System.out.println("PhonebookService.exeModifyForm2()");
		
		Map<String, Object> pMap = phonebookDao.personSelectOne2(no);
		
		return pMap;
	}
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");

		int count = phonebookDao.personUpdate(personVo);

		return count;
	}

	//삭제
	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete");

		int count = phonebookDao.personDelete(no);

		return count;
	}

}
