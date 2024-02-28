package com.javaex.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;


	public List<PersonVo> exeList() {

		System.out.println("PhoneDao.exeList()");
		List<PersonVo> personList = phonebookDao.personSelect();

		return personList;
	}

	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		int count = phonebookDao.personInsert(personVo);
		return count;
	}

	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");

		PersonVo personVo = phonebookDao.personSelectOne(no);

		return personVo;
	}

	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");

		int count = phonebookDao.personUpdate(personVo);

		return count;
	}

	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete");

		int count = phonebookDao.personDelete(no);

		return count;
	}

}
