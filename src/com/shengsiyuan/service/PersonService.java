package com.shengsiyuan.service;

import java.util.List;

import com.shengsiyuan.model.Person;

public interface PersonService {
	public void savePerson(Person person);
	
	public List<Person> listAllPersons();
}
