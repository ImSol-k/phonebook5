package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.select");

		return personList;
	}

	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");

		int count = sqlSession.insert("phonebook.insert", personVo);

		return count;
	}

	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);

		return personVo;
	}

	public int personUpdate(PersonVo personVo) {
		System.out.println("PhonebookDao.personUpdate()");

		int count = sqlSession.update("phonebook.update", personVo);
		System.out.println(count);

		return count;
	}

	public int personDelete(int no) {
		System.out.println("PhonebookDao.personDelete()");

		int count = sqlSession.delete("phonebook.delete", no);
		System.out.println(no);

		return count;
	}

}
