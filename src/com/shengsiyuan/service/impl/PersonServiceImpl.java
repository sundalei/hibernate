package com.shengsiyuan.service.impl;

import java.util.List;

import com.shengsiyuan.dao.PersonDAO;
import com.shengsiyuan.dao.impl.PersonDAOImpl;
import com.shengsiyuan.model.Person;
import com.shengsiyuan.service.PersonService;

public class PersonServiceImpl implements PersonService {
	
	public void savePerson(Person person) {
		PersonDAO dao = new PersonDAOImpl();
		dao.savePerson(person);
	}

	@Override
	public List<Person> listAllPersons() {
		PersonDAO dao = new PersonDAOImpl();
		return dao.listAllPersons();
	}

	@Override
	public void deletePerson(int id) {
		PersonDAO dao = new PersonDAOImpl();
		dao.removePerson(id);
	}

	@Override
	public Person getSinglePersonById(int id) {
		PersonDAO dao = new PersonDAOImpl();
		return dao.getSinglePerson(id);
	}
}
